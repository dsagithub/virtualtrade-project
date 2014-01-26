package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class VirtualtradeAPI {

	private final static String TAG = VirtualtradeAPI.class.toString();
	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public AnuncioCollection getAnuncios(URL url) {
		AnuncioCollection anuncios = new AnuncioCollection();

		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();

			urlConnection.setRequestProperty("Accept",
					MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			JSONObject jsonObject = new JSONObject(sb.toString());
			JSONArray jsonLinks = jsonObject.getJSONArray("links");
			parseLinks(jsonLinks, anuncios.getLinks());
			JSONArray jsonStings = jsonObject.getJSONArray("anuncios");

			for (int i = 0; i < jsonStings.length(); i++) {
				JSONObject jsonAnuncio = jsonStings.getJSONObject(i);
				Anuncio anuncio = parseAnuncio(jsonAnuncio);

				anuncios.add(anuncio);
			}
		} catch (IOException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (ParseException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return anuncios;
	}

	private void parseLinks(JSONArray source, List<Link> links)
			throws JSONException {
		for (int i = 0; i < source.length(); i++) {
			JSONObject jsonLink = source.getJSONObject(i);
			Link link = new Link();
			link.setRel(jsonLink.getString("rel"));
			link.setTitle(jsonLink.getString("title"));
			link.setType(jsonLink.getString("type"));
			link.setUri(jsonLink.getString("uri"));
			links.add(link);
		}
	}

	private void parseImagenes(JSONArray source, List<Imagen> imagenes)
			throws JSONException {
		for (int i = 0; i < source.length(); i++) {
			JSONObject jsonImagen = source.getJSONObject(i);
			Imagen imagen = new Imagen();
			imagen.setAnuncioid(jsonImagen.getInt("anuncioid"));
			imagen.setImagenid(jsonImagen.getInt("imagenid"));
			imagen.setUrlimagen(jsonImagen.getString("urlimagen"));
			imagenes.add(imagen);
		}
	}

	private Anuncio parseAnuncio(JSONObject source) throws JSONException,
			ParseException {
		Anuncio anuncio = new Anuncio();

		anuncio.setAnuncioid(source.getString("anuncioid"));
		anuncio.setEmail(source.getString("email"));
		anuncio.setSubject(source.getString("subject"));
		anuncio.setContent(source.getString("content"));
		anuncio.setEstado(source.getBoolean("estado"));
		anuncio.setPrecio(source.getString("precio"));
		anuncio.setAtributo1(source.getString("atributo1"));
		anuncio.setAtributo2(source.getString("atributo2"));
		anuncio.setAtributo3(source.getString("atributo3"));
		anuncio.setMarca(source.getString("marca"));

		String creation_timestamp = source.getString("creation_timestamp")
				.replace("T", " ");
		anuncio.setCreation_timestamp(sdf.parse(creation_timestamp));

		JSONArray jsonAnuncioLinks = source.getJSONArray("links");
		parseLinks(jsonAnuncioLinks, anuncio.getLinks());

		JSONArray jsonImagen = source.getJSONArray("imagenes");
		parseImagenes(jsonImagen, anuncio.getImagenes());

		return anuncio;
	}

	public Anuncio getAnuncio(URL url) {
		Anuncio anuncio = new Anuncio();

		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Accept",
					MediaType.VIRTUAL_API_ANUNCIO);
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			JSONObject jsonAnuncio = new JSONObject(sb.toString());
			anuncio = parseAnuncio(jsonAnuncio);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (ParseException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		Log.d(TAG, "anuncio a" + anuncio);

		return anuncio;
	}

	private Mensaje parseMensaje(JSONObject source) throws JSONException,
			ParseException {

		Mensaje mensaje = new Mensaje();

		mensaje.setMensajeid(source.getString("mensajeid"));
		mensaje.setAnuncioid(source.getString("anuncioid"));
		mensaje.setSubject(source.getString("subject"));
		mensaje.setContent(source.getString("content"));
		String creation_timestamp = source.getString("creation_timestamp")
				.replace("T", " ");
		mensaje.setCreation_timestamp(sdf.parse(creation_timestamp));
		mensaje.setEmaildestino(source.getString("emaildestino"));
		mensaje.setEmailorigen(source.getString("emailorigen"));

		JSONArray jsonAnuncioLinks = source.getJSONArray("links");
		parseLinks(jsonAnuncioLinks, mensaje.getLinks());

		return mensaje;
	}

	private User parseUser(JSONObject source) throws JSONException,
			ParseException {

		User user = new User();

		user.setName(source.getString("name"));
		user.setEmail(source.getString("email"));
		user.setPhone(source.getInt("phone"));
		user.setFoto(source.getString("foto"));
		user.setCiudad(source.getString("ciudad"));
		user.setCalle(source.getString("calle"));
		user.setNumero(source.getInt("numero"));
		user.setPiso(source.getInt("piso"));
		user.setPuerta(source.getInt("puerta"));

		return user;
	}

	public Mensaje getMensaje(URL url)

	{

		Mensaje mensaje = new Mensaje();

		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Accept",
					MediaType.VIRTUAL_API_MENSAJE);
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			JSONObject jsonAnuncio = new JSONObject(sb.toString());
			mensaje = parseMensaje(jsonAnuncio);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (ParseException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		Log.d(TAG, "anuncio a" + mensaje);

		return mensaje;
	}

	public MensajeCollection getMensajes(URL url) {
		MensajeCollection mensajes = new MensajeCollection();

		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();

			urlConnection.setRequestProperty("Accept",
					MediaType.VIRTUAL_API_MENSAJE_COLLECTION);
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			JSONObject jsonObject = new JSONObject(sb.toString());
			JSONArray jsonLinks = jsonObject.getJSONArray("links");
			parseLinks(jsonLinks, mensajes.getLinks());
			JSONArray jsonStings = jsonObject.getJSONArray("mensajes");

			for (int i = 0; i < jsonStings.length(); i++) {
				JSONObject jsonMensaje = jsonStings.getJSONObject(i);
				Mensaje mensaje = parseMensaje(jsonMensaje);
				;

				mensajes.add(mensaje);
			}
		} catch (IOException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (ParseException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		return mensajes;
	}

	public User getUser(URL url)

	{

		User user = new User();

		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Accept",
					MediaType.VIRTUAL_API_USER);
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			JSONObject jsonAnuncio = new JSONObject(sb.toString());
			mensaje = parseMensaje(jsonAnuncio);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} catch (ParseException e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}

		Log.d(TAG, "anuncio a" + mensaje);

		return user;
	}

}
