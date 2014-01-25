package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.Mensaje;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api.VirtualtradeAPI;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MensajeDetail extends Activity {

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
		(new FetchMensajeTask()).execute(url);

	}

	private void loadMensaje(Mensaje mensaje) {
		TextView tvDetailSubject = (TextView) findViewById(R.id.tvDetailSubject);
		TextView tvDetailContent = (TextView) findViewById(R.id.tvDetailContent);
		TextView tvDetailEmailOrgen = (TextView) findViewById(R.id.tvDetailEmailOrigen);
		TextView tvDetailDate = (TextView) findViewById(R.id.tvDetailDate);

		tvDetailSubject.setText(mensaje.getSubject());
		tvDetailContent.setText(mensaje.getContent());
		tvDetailEmailOrgen.setText(mensaje.getEmailorigen());
		tvDetailDate.setText(SimpleDateFormat.getInstance().format(
				mensaje.getCreation_timestamp()));
	}

	private class FetchMensajeTask extends AsyncTask<URL, Void, Mensaje> {
		private ProgressDialog pd;

		@Override
		protected Mensaje doInBackground(URL... params) {
			Mensaje mensaje = api.getMensaje(params[0]);
			return mensaje;
		}

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(MensajeDetail.this);
			pd.setTitle("Loading...");
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}

		@Override
		protected void onPostExecute(Mensaje result) {
			loadMensaje(result);

			if (pd != null) {
				pd.dismiss();
			}
		}

	}

}
