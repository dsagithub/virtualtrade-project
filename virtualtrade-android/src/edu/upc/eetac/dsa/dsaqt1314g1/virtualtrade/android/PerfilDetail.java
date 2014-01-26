package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.User;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilDetail extends Activity {

	private final static String TAG = PerfilDetail.class.toString();
	VirtualtradeAPI api;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.anuncio_detail_layout);

		api = new VirtualtradeAPI();
		URL url = null;
		try {
			url = new URL((String) getIntent().getExtras().get("url"));
		} catch (MalformedURLException e) {
		}
		(new FetchAnuncioTask()).execute(url);

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
		email.setText(user.getEmail());
		phone.setText(user.getPhone());
		ciudad.setText(user.getCiudad());
		calle.setText(user.getCalle());
		numero.setText(user.getNumero());
		piso.setText(user.getPiso());
		puerta.setText(user.getPuerta());

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

	private class FetchAnuncioTask extends AsyncTask<URL, Void, User> {
		private ProgressDialog pd;

		@Override
		protected User doInBackground(URL... params) {
			User user = api.getUser(params[0]);
			return user;
		}

		@Override
		protected void onPostExecute(Anuncio result) {
			loadAnuncio(result);
			ImagenCollection imagenes = new ImagenCollection();
			imagenes.setImagenes(result.getImagenes());

			new DownloadImageTask(
					(ImageView) findViewById(R.id.imagenesanuncio))
					.execute(imagenes.getImagenes().get(0).getUrlimagen());
			if (pd != null) {
				pd.dismiss();
			}
		}

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(AnuncioDetail.this);
			pd.setTitle("Loading...");
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}

	}

}
