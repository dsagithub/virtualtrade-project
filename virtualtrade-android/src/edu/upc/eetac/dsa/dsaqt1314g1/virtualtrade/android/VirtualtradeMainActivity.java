package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Properties;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.AnuncioCollection;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class VirtualtradeMainActivity extends Activity {

	private final static String TAG = VirtualtradeMainActivity.class.toString();

	String serverAddress;
	String serverPort;

	String email;
	String password;
	SharedPreferences prefs;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate()");

		prefs = getSharedPreferences("virtualtrade-profile",
				Context.MODE_PRIVATE);

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

		email = prefs.getString("email", null);
		password = prefs.getString("password", null);

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password.toCharArray());
			}
		});
		Log.d(TAG, "authenticated with " + email + ":" + password);
	}

	public void verAnuncios(View view) {
		Intent i = new Intent(this, AnuncioSelection.class);
		startActivity(i);
	}

	public void verMensajes(View view) {
		Intent i = new Intent(this, VerMensajes.class);
		startActivity(i);
	}

	public void verPerfil(View view) {
		Intent i = new Intent(this, PerfilDetail.class);
		startActivity(i);
	}

	public void cerrarSesion(View view) {

		prefs.edit().clear().commit();
		Intent i = new Intent(this, Login.class);
		startActivity(i);
	}

}
