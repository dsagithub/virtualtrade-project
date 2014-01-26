package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.User;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilDetail extends Activity {

	String serverAddress;
	String serverPort;

	String email;
	String password;

	private final static String TAG = PerfilDetail.class.toString();
	VirtualtradeAPI api;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

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

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password.toCharArray());
			}
		});

		setContentView(R.layout.perfil_layout);
		api = new VirtualtradeAPI();
		URL url = null;

		try {

			url = new URL("http://" + serverAddress + ":" + serverPort
					+ "/virtualtrade-api/users/" + email);
		} catch (MalformedURLException e) {
			Log.d(TAG, e.getMessage(), e);
			finish();
		}

		(new FetchUsuarioTask()).execute(url);

	}

	private void loadUser(User user) {
		TextView name = (TextView) findViewById(R.id.name);
		TextView email = (TextView) findViewById(R.id.email);
		TextView phone = (TextView) findViewById(R.id.phone);
		TextView ciudad = (TextView) findViewById(R.id.ciudad);
		TextView calle = (TextView) findViewById(R.id.calle);
		TextView numero = (TextView) findViewById(R.id.numero);
		TextView piso = (TextView) findViewById(R.id.piso);
		TextView puerta = (TextView) findViewById(R.id.puerta);

		name.setText(user.getName());
		email.setText("Email usuario: " + user.getEmail());
		phone.setText("Teléfono: " + Integer.toString((user.getPhone())));
		ciudad.setText("Ciudad: " + user.getCiudad());
		calle.setText("Calle: " + user.getCalle());
		numero.setText("Número: " + Integer.toString(user.getNumero()));
		piso.setText("Piso: " + Integer.toString(user.getPiso()));
		puerta.setText("Puerta :" + Integer.toString(user.getPuerta()));

	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}

		@Override
		protected Bitmap doInBackground(String... url) {
			String urldisplay = url[0];
			Bitmap bitmap = null;
			try {

				URL imageUrl = null;
				HttpURLConnection conn = null;
				imageUrl = new URL(urldisplay);
				conn = (HttpURLConnection) imageUrl.openConnection();
				conn.connect();
				bitmap = BitmapFactory.decodeStream(conn.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}

	}

	private class FetchUsuarioTask extends AsyncTask<URL, Void, User> {
		private ProgressDialog pd;

		@Override
		protected User doInBackground(URL... params) {
			User user = api.getUser(params[0]);
			return user;
		}

		@Override
		protected void onPostExecute(User result) {
			loadUser(result);

			new DownloadImageTask((ImageView) findViewById(R.id.userimage))
					.execute(result.getFoto());
			if (pd != null) {
				pd.dismiss();
			}
		}

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(PerfilDetail.this);
			pd.setTitle("Loading...");
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}

	}

}
