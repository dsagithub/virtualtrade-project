package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity {
	private final static String TAG = Login.class.toString();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate()");

		SharedPreferences prefs = getSharedPreferences("virtualtrade-profile",
				Context.MODE_PRIVATE);

		String username = prefs.getString("username", null);
		String password = prefs.getString("password", null);

		// Uncomment the next two lines to test the application without login
		// each time
		// username = "alicia";
		// password = "alicia";
		// recordamos el login
		if ((username != null) && (password != null)) {
			Intent i = new Intent(this, VirtualtradeMainActivity.class);
			startActivity(i);
			finish();
		}
		setContentView(R.layout.login_layout);
	}

	public void signIn(View v) {
		// cogemos los valores del usuario
		EditText etUsername = (EditText) findViewById(R.id.etUsername);
		EditText etPassword = (EditText) findViewById(R.id.etPassword);

		String username = etUsername.getText().toString();
		String password = etPassword.getText().toString();
		// deberíamos verificar que el usuario y la contraseña es correcto
		// Launch a background task to check if credentials are correct
		// If correct, store username and password and start Beeter activity
		// else, handle error

		// I'll suppose that u/p are correct:
		SharedPreferences prefs = getSharedPreferences("virtualtrade-profile",
				Context.MODE_PRIVATE);

		// recuerda los valores de usuario y contraseña
		SharedPreferences.Editor editor = prefs.edit();
		editor.clear();
		editor.putString("username", username);
		editor.putString("password", password);
		boolean done = editor.commit();
		if (done)
			Log.d(TAG, "preferences set");
		else
			Log.d(TAG, "preferences not set. THIS A SEVERE PROBLEM");

		// arrancamos la actividad Virtualtrade
		startVirtualtradeActivity();
	}

	private void startVirtualtradeActivity() {
		Intent i = new Intent(this, VirtualtradeMainActivity.class);
		startActivity(i);
		finish();
	}
	
//	private class LoginTask extends AsyncTask<Params, Progress, User>
//	{
//
//		@Override
//		protected Result doInBackground(Params... arg0) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//	}
	
}
