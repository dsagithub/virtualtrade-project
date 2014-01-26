package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.AnuncioCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;

public class VerAnuncios extends ListActivity {

	private final static String TAG = VerAnuncios.class.toString();

	String serverAddress;
	String serverPort;

	VirtualtradeAPI api;
	private ArrayList<Anuncio> anuncioList;
	private AnuncioAdapter adapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate()");

		String a1 = null;
		String a2 = null;
		String a3 = null;
		String a4 = null;
		a1 = ((String) getIntent().getExtras().get("a1"));
		a2 = ((String) getIntent().getExtras().get("a2"));
		a3 = ((String) getIntent().getExtras().get("a3"));
		a4 = ((String) getIntent().getExtras().get("a4"));

		AssetManager assetManager = getAssets();
		Properties config = new Properties();
		try {
			config.load(assetManager.open("config.properties"));
			serverAddress = config.getProperty("server.address");
			serverPort = config.getProperty("server.port");

			Log.d(TAG, "Configured server " + serverAddress + ":" + serverPort);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage(), e);
			finish();
		}

		setContentView(R.layout.anuncios_layout);

		anuncioList = new ArrayList<Anuncio>();
		adapter = new AnuncioAdapter(this, anuncioList);
		setListAdapter(adapter);

		api = new VirtualtradeAPI();
		URL url = null;

		if (a1 != null && a2 == null && a3 == null && a4 == null) {

			if (a1.equals("Todas las categorías")) {
				try {

					if (a1.equals("Todas las categorías)")) {

					}
					url = new URL(
							"http://"
									+ serverAddress
									+ ":"
									+ serverPort
									+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20"
									+ a1);
				} catch (MalformedURLException e) {
					Log.d(TAG, e.getMessage(), e);
					finish();
				}
			}

			else {
				try {

					if (a1.equals("Todas las categorías)")) {

					}
					url = new URL(
							"http://"
									+ serverAddress
									+ ":"
									+ serverPort
									+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20&atributo1="
									+ a1);
				} catch (MalformedURLException e) {
					Log.d(TAG, e.getMessage(), e);
					finish();
				}
			}
		}

		else if (a1 != null && a2 != null && a3 == null && a4 == null) {

			if (a2.equals("Todas las subcategorías")) {

				try {
					url = new URL(
							"http://"
									+ serverAddress
									+ ":"
									+ serverPort
									+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20&atributo1="
									+ a1);
				} catch (MalformedURLException e) {
					Log.d(TAG, e.getMessage(), e);
					finish();
				}

			}

			else {
				try {
					url = new URL(
							"http://"
									+ serverAddress
									+ ":"
									+ serverPort
									+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20&atributo1="
									+ a1 + "&atributo2=" + a2);
				} catch (MalformedURLException e) {
					Log.d(TAG, e.getMessage(), e);
					finish();
				}
			}

		}

		else if (a1 != null && a2 != null && a3 != null && a4 == null) {

			if (a3.equals("Todas las subcategorías")) {
				try {
					url = new URL(
							"http://"
									+ serverAddress
									+ ":"
									+ serverPort
									+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20&atributo1="
									+ a1 + "&atributo2=" + a2);
				} catch (MalformedURLException e) {
					Log.d(TAG, e.getMessage(), e);
					finish();
				}
			}

			else {
				try {
					url = new URL(
							"http://"
									+ serverAddress
									+ ":"
									+ serverPort
									+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20&atributo1="
									+ a1 + "&atributo2=" + a2 + "&atributo3="
									+ a3);
				} catch (MalformedURLException e) {
					Log.d(TAG, e.getMessage(), e);
					finish();
				}
			}
		}

		else if (a1 != null && a2 != null && a3 != null && a4 != null) {
			try {
				url = new URL(
						"http://"
								+ serverAddress
								+ ":"
								+ serverPort
								+ "/virtualtrade-api/anuncios/atributos?&offset=0&length=20&atributo1="
								+ a1 + "&atributo2=" + a2);
			} catch (MalformedURLException e) {
				Log.d(TAG, e.getMessage(), e);
				finish();
			}
		}

		(new FetchAnunciosTask()).execute(url);

	}

	private class FetchAnunciosTask extends
			AsyncTask<URL, Void, AnuncioCollection> {
		private ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(VerAnuncios.this);
			pd.setTitle("Searching...");
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}

		@Override
		protected AnuncioCollection doInBackground(URL... params) {
			AnuncioCollection anuncios = api.getAnuncios(params[0]);
			return anuncios;
		}

		@Override
		protected void onPostExecute(AnuncioCollection result) {

			if (result != null) {
				addAnuncios(result);
				if (pd != null) {
					pd.dismiss();
				}

			}

			else {
				pd.dismiss();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						VerAnuncios.this);
				builder.setMessage("No se han encontrado anuncios")
						.setCancelable(false)
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										finish();
									}
								});
				builder.create();
				builder.show();
			}

		}

	}

	private void addAnuncios(AnuncioCollection anuncios) {

		anuncioList.addAll(anuncios.getAnuncios());
		adapter.notifyDataSetChanged();

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Anuncio anuncio = anuncioList.get(position);

		URL url = null;
		try {
			url = new URL(anuncio.getLinks().get(0).getUri());
		} catch (MalformedURLException e) {
			return;
		}

		Log.d(TAG, url.toString());

		Intent intent = new Intent(this, AnuncioDetail.class);
		intent.putExtra("url", url.toString());
		startActivity(intent);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();

	}

}
