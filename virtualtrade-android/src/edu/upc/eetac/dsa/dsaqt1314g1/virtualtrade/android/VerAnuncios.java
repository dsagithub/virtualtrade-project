package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.AnuncioCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

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
		try {
			url = new URL("http://" + serverAddress + ":" + serverPort
					+ "/virtualtrade-api/anuncios?&offset=0&length=20");
		} catch (MalformedURLException e) {
			Log.d(TAG, e.getMessage(), e);
			finish();
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
			addAnuncios(result);
			if (pd != null) {
				pd.dismiss();
			}
		}

	}

	private void addAnuncios(AnuncioCollection anuncios) {
		anuncioList.addAll(anuncios.getAnuncios());
		adapter.notifyDataSetChanged();
	}

}
