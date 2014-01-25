package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class AnuncioSelection extends Activity {

	private final static String TAG = AnuncioSelection.class.toString();

	Spinner atributo1, atributo2, atributo3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.selection_layout);

		atributo1 = (Spinner) findViewById(R.id.atributo1);
		atributo2 = (Spinner) findViewById(R.id.atributo2);
		atributo3 = (Spinner) findViewById(R.id.atributo3);
		atributo2.setEnabled(false);
		atributo3.setEnabled(false);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.atributo1, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		atributo1.setAdapter(adapter1);

		atributo1
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							android.view.View v, int position, long id) {
						String a1;
						a1 = atributo1.getSelectedItem().toString();
						if (a1.equals("Electrónica")) {
							atributo2.setEnabled(true);
							ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
									.createFromResource(
											AnuncioSelection.this,
											R.array.atributo2Electronica,
											android.R.layout.simple_spinner_item);
							adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							atributo2.setAdapter(adapter2);

							atributo2
									.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

										public void onItemSelected(
												AdapterView<?> parent,
												android.view.View v,
												int position, long id) {

											String a2;
											a2 = atributo2.getSelectedItem()
													.toString();

											if (a2.equals("Imágen y Sonido")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3ImagenSonido,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
												
												
											}

											else if (a2.equals("Informática")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Informatica,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2
													.equals("Consolas y Videojuegos")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Consolas,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2
													.equals("Cámaras y Fotografía")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Camaras,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2
													.equals("Móviles y Telefonía")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Moviles,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);

											}

											else if (a2.equals("Otros")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});

						}

						else if (a1.equals("Motor")) {
							atributo2.setEnabled(true);
							ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
									.createFromResource(
											AnuncioSelection.this,
											R.array.atributo2Motor,
											android.R.layout.simple_spinner_item);
							adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							atributo2.setAdapter(adapter2);

							atributo2
									.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

										public void onItemSelected(
												AdapterView<?> parent,
												android.view.View v,
												int position, long id) {

											String a2;
											a2 = atributo2.getSelectedItem()
													.toString();

											if (a2.equals("Coches")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Coches,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Herramientas")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3HerramientasMotor,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Motos")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Motos,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Otros")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Entretenimiento")) {
							atributo2.setEnabled(true);
							ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
									.createFromResource(
											AnuncioSelection.this,
											R.array.atributo2Entretenimiento,
											android.R.layout.simple_spinner_item);
							adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							atributo2.setAdapter(adapter2);

							atributo2
									.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

										public void onItemSelected(
												AdapterView<?> parent,
												android.view.View v,
												int position, long id) {

											String a2;
											a2 = atributo2.getSelectedItem()
													.toString();

											if (a2.equals("Libros y Cómics")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Libros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Música")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Musica,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2
													.equals("DVD y Películas")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3DVD,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Otros")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Hogar")) {
							atributo2.setEnabled(true);
							ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
									.createFromResource(
											AnuncioSelection.this,
											R.array.atributo2Hogar,
											android.R.layout.simple_spinner_item);
							adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							atributo2.setAdapter(adapter2);

							atributo2
									.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

										public void onItemSelected(
												AdapterView<?> parent,
												android.view.View v,
												int position, long id) {

											String a2;
											a2 = atributo2.getSelectedItem()
													.toString();

											if (a2.equals("Herramientas")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3HerramientasHogar,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Muebles")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Muebles,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Cocina")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Cocina,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2
													.equals("Electrodomésticos")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Electrodomesticos,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Decoración")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Decoracion,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);

											}

											else if (a2.equals("Otros")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Deportes")) {
							atributo2.setEnabled(true);
							ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
									.createFromResource(
											AnuncioSelection.this,
											R.array.atributo2Deportes,
											android.R.layout.simple_spinner_item);
							adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							atributo2.setAdapter(adapter2);

							atributo2
									.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

										public void onItemSelected(
												AdapterView<?> parent,
												android.view.View v,
												int position, long id) {

											String a2;
											a2 = atributo2.getSelectedItem()
													.toString();

											if (a2.equals("Atletismo")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Atletismo,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Baloncesto")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Baloncesto,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Ciclismo")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Ciclismo,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2
													.equals("Esquí")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Esqui,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

											else if (a2.equals("Futbol")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Futbol,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);

											}

											else if (a2.equals("Tenis")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Tenis,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);

											}
											else if (a2.equals("Otros")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Otros")) {
							atributo2.setEnabled(true);
							ArrayAdapter<CharSequence> adapter2 = ArrayAdapter
									.createFromResource(
											AnuncioSelection.this,
											R.array.otros,
											android.R.layout.simple_spinner_item);
							adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
							atributo2.setAdapter(adapter2);

							atributo2
									.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

										public void onItemSelected(
												AdapterView<?> parent,
												android.view.View v,
												int position, long id) {

											String a2;
											a2 = atributo2.getSelectedItem()
													.toString();

											if (a2 != null) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}
					}

					public void onNothingSelected(AdapterView<?> parent) {

					}

				});
	}
}
