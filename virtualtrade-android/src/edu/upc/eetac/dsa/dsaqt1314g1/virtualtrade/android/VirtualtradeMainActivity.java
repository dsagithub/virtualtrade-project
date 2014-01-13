package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.AnuncioCollection;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class VirtualtradeMainActivity extends Activity {

	private final static String TAG = VirtualtradeMainActivity.class.toString();

	String serverAddress;
	String serverPort;

	/** Called when the activity is first created. */
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

		setContentView(R.layout.virtualtrade_layout);

	}

	public void verAnuncios(View view) {
		Intent i = new Intent(this, AnuncioSelection.class);
		startActivity(i);
	}

}
