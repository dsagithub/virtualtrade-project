package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AnuncioSelection extends Activity {

	private final static String TAG = AnuncioSelection.class.toString();

	Spinner atributo1, atributo2, atributo3, atributo4;
	String a1=null, a2=null, a3=null, a4=null;
	Button verAnuncios;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.selection_layout);

		atributo1 = (Spinner) findViewById(R.id.atributo1);
		atributo2 = (Spinner) findViewById(R.id.atributo2);
		atributo3 = (Spinner) findViewById(R.id.atributo3);
		atributo4 = (Spinner) findViewById(R.id.atributo4);
		verAnuncios = (Button) findViewById(R.id.verAnuncios);
		atributo2.setEnabled(false);
		atributo3.setEnabled(false);
		atributo4.setEnabled(false);
		verAnuncios.setEnabled(false);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.atributo1, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		atributo1.setAdapter(adapter1);

		atributo1
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent,
							android.view.View v, int position, long id) {
						verAnuncios.setEnabled(true);
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4ImagenSonido,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});

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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Informatica,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Consolas,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);
																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Camaras,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Moviles,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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
							verAnuncios.setEnabled(true);
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

											a3 = atributo3.getSelectedItem()
													.toString();

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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Coches,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Motos,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Entretenimiento")) {
							verAnuncios.setEnabled(true);
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

											a3 = atributo3.getSelectedItem()
													.toString();

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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Hogar")) {
							verAnuncios.setEnabled(true);
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

											a3 = atributo3.getSelectedItem()
													.toString();

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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);
																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Electrodomesticos,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);
																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});

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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Deportes")) {
							verAnuncios.setEnabled(true);
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {
																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Atletismo,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Baloncesto,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Ciclismo,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
											}

											else if (a2.equals("Esquí")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.atributo3Esqui,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Esqui,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Futbol,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});

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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Tenis,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});

											} else if (a2.equals("Otros")) {
												atributo3.setEnabled(true);
												ArrayAdapter<CharSequence> adapter3 = ArrayAdapter
														.createFromResource(
																AnuncioSelection.this,
																R.array.otros,
																android.R.layout.simple_spinner_item);
												adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
												atributo3.setAdapter(adapter3);

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
											}

										}

										@Override
										public void onNothingSelected(
												AdapterView<?> arg0) {

										}
									});
						}

						else if (a1.equals("Otros")) {
							verAnuncios.setEnabled(true);
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

												atributo3
														.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

															public void onItemSelected(
																	AdapterView<?> parent,
																	android.view.View v,
																	int position,
																	long id) {

																a3 = atributo3
																		.getSelectedItem()
																		.toString();

																atributo4
																		.setEnabled(true);
																ArrayAdapter<CharSequence> adapter4 = ArrayAdapter
																		.createFromResource(
																				AnuncioSelection.this,
																				R.array.atributo4Otros,
																				android.R.layout.simple_spinner_item);
																adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
																atributo4
																		.setAdapter(adapter4);

																atributo4
																		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

																			public void onItemSelected(
																					AdapterView<?> parent,
																					android.view.View v,
																					int position,
																					long id) {

																				a4 = atributo4
																						.getSelectedItem()
																						.toString();

																			}

																			@Override
																			public void onNothingSelected(
																					AdapterView<?> arg0) {

																			}
																		});

															}

															@Override
															public void onNothingSelected(
																	AdapterView<?> arg0) {

															}
														});
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

	public void verAnuncios(View v) {
		Intent intent = new Intent(this, VerAnuncios.class);
		
		intent.putExtra("a1", a1.toString());
		if (a2 != null){
			intent.putExtra("a2", a2.toString());
		}
		
		if (a3 != null){
			intent.putExtra("a3", a3.toString());
		}
		
		if (a4 != null){
			intent.putExtra("a4", a4.toString());
		}
		
		
		
		startActivity(intent);

	}
}
