package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Anuncio;
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
		(new FetchStingTask()).execute(url);
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

	private class FetchStingTask extends AsyncTask<URL, Void, Anuncio> {
		private ProgressDialog pd;

		@Override
		protected Anuncio doInBackground(URL... params) {
			Anuncio anuncio = api.getAnuncio(params[0]);
			return anuncio;
		}

		@Override
		protected void onPostExecute(Anuncio result) {
			loadAnuncio(result);
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
