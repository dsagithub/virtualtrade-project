package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Imagen;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.ImagenCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;

public class AnuncioDetail extends Activity {
	private final static String TAG = AnuncioDetail.class.toString();
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

	private void loadAnuncio(Anuncio anuncio) {
		TextView tvDetailSubject = (TextView) findViewById(R.id.tvDetailSubject);
		TextView tvDetailContent = (TextView) findViewById(R.id.tvDetailContent);
		TextView tvDetailUsername = (TextView) findViewById(R.id.tvDetailEmail);
		TextView tvDetailDate = (TextView) findViewById(R.id.tvDetailDate);

		tvDetailSubject.setText(anuncio.getSubject());
		tvDetailContent.setText(anuncio.getContent());
		tvDetailUsername.setText(anuncio.getEmail());
		tvDetailDate.setText(SimpleDateFormat.getInstance().format(
				anuncio.getCreation_timestamp()));
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

	private class FetchAnuncioTask extends AsyncTask<URL, Void, Anuncio> {
		private ProgressDialog pd;

		@Override
		protected Anuncio doInBackground(URL... params) {
			Anuncio anuncio = api.getAnuncio(params[0]);
			return anuncio;
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
