package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity {
	private final static String TAG = Login.class.toString();

	String serverAddress;
	String serverPort;
	String email;
	String password;

	VirtualtradeAPI api;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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

		if ((email != null) && (password != null)) {
			Intent i = new Intent(this, VirtualtradeMainActivity.class);
			startActivity(i);
			finish();
		}
		setContentView(R.layout.login_layout);

	}

	public void signIn(View v) {
		// cogemos los valores del usuario
		EditText etEmail = (EditText) findViewById(R.id.etEmail);
		EditText etPassword = (EditText) findViewById(R.id.etPassword);

		email = etEmail.getText().toString();
		password = etPassword.getText().toString();

		(new LoginTask()).execute();

	}

	private void startVirtualtradeActivity() {
		Intent i = new Intent(this, VirtualtradeMainActivity.class);
		startActivity(i);
		finish();
	}

	private class LoginTask extends AsyncTask<URL, Integer, String> {
		String success = null;

		@Override
		protected String doInBackground(URL... params) {

			HttpURLConnection urlConnection = null;

			URL url = null;
			try {
				url = new URL("http://" + serverAddress + ":" + serverPort
						+ "/virtualtrade-auth/LoginServlet?email="+email+"&password="+password);

			} catch (MalformedURLException e) {
				Log.d(TAG, e.getMessage(), e);
				finish();
			}
			try {

//				ArrayList<NameValuePair> uservalues = new ArrayList<NameValuePair>(
//						2);
//				uservalues.add(new BasicNameValuePair("email", email));
//				uservalues.add(new BasicNameValuePair("userpass", password));

				urlConnection = (HttpURLConnection) url.openConnection();

				urlConnection.setDoInput(true);
				//urlConnection.setDoOutput(true);
				urlConnection.connect();
//				PrintWriter writer = new PrintWriter(
//						urlConnection.getOutputStream());
//				writer.println(uservalues.toString());
//				writer.close();

				// leemos la respuesta
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(urlConnection.getInputStream()));

				try {
					JSONObject result = new JSONObject(reader.readLine());
					success = Boolean.toString(result.getBoolean("success"));

				} catch (JSONException ex) {
					Log.w("Aviso", ex.toString());

				}

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return success;
		}

		@Override
		protected void onPostExecute(String result) {
			if (success == "true") {

				SharedPreferences prefs = getSharedPreferences(
						"virtualtrade-profile", Context.MODE_PRIVATE);

				SharedPreferences.Editor editor = prefs.edit();
				editor.clear();
				editor.putString("username", email);
				editor.putString("password", password);
				boolean done = editor.commit();
				if (done)
					Log.d(TAG, "preferences set");
				else
					Log.d(TAG, "preferences not set. THIS A SEVERE PROBLEM");

				// arrancamos la actividad Virtualtrade
				startVirtualtradeActivity();

			} else if (success == "true") {

			}

		}
	}
}
