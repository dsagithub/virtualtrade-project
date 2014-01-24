package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.AnuncioCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Mensaje;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.MensajeCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;

public class VerMensajes extends ListActivity {

	private final static String TAG = VerMensajes.class.toString();

	String serverAddress;
	String serverPort;

	String email;
	String password;

	VirtualtradeAPI api;
	private ArrayList<Mensaje> mensajeList;
	private MensajeAdapter adapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate()");

		SharedPreferences prefs = getSharedPreferences("virtualtrade-profile",
				Context.MODE_PRIVATE);

		email = prefs.getString("email", null);
		password = prefs.getString("password", null);

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
		mensajeList = new ArrayList<Mensaje>();
		adapter = new MensajeAdapter(this, mensajeList);
		setListAdapter(adapter);

		api = new VirtualtradeAPI();
		URL url = null;
		try {
			url = new URL("http://" + serverAddress + ":" + serverPort
					+ "/virtualtrade-api/mensajes/'" + email
					+ "'?offset=0&length=20");
		} catch (MalformedURLException e) {
			Log.d(TAG, e.getMessage(), e);
			finish();
		}
		(new FetchMensajesTask()).execute(url);

	}

	private class FetchMensajesTask extends
			AsyncTask<URL, Void, MensajeCollection> {
		private ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(VerMensajes.this);
			pd.setTitle("Searching...");
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}

		@Override
		protected MensajeCollection doInBackground(URL... params) {
			MensajeCollection mensajes = api.getMensajes(params[0]);
			return mensajes;
		}

		@Override
		protected void onPostExecute(MensajeCollection result) {
			addMensajes(result);
			if (pd != null) {
				pd.dismiss();
			}
		}

	}

	private void addMensajes(MensajeCollection mensajes) {
		mensajeList.addAll(mensajes.getMensajes());
		adapter.notifyDataSetChanged();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Mensaje mensaje = mensajeList.get(position);

		URL url = null;
		try {
			url = new URL(mensaje.getLinks().get(0).getUri());
		} catch (MalformedURLException e) {
			return;
		}

		Log.d(TAG, url.toString());

		Intent intent = new Intent(this, AnuncioDetail.class);
		intent.putExtra("url", url.toString());
		startActivity(intent);

	}

}
