package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links;

import java.net.URI;

import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.AnuncioResource;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.MediaType;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.MensajeResource;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.UserResource;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.VirtualRootAPIResource;

public class VirtualAPILinkBuilder {

	public final static Link buildURIRootAPI(UriInfo uriInfo) {

		URI uriRoot = uriInfo.getBaseUriBuilder()
				.path(VirtualRootAPIResource.class).build();
		Link link = new Link();
		link.setUri(uriRoot.toString());
		link.setRel("self bookmark");
		link.setTitle("Virtualtrade API");
		link.setType(MediaType.VIRTUAL_API_LINK_COLLECTION);

		return link;
	}

	public final static Link buildURIAnuncioId(UriInfo uriInfo,
			String anuncioid, String rel) {
		URI anuncioURI = uriInfo.getBaseUriBuilder()
				.path(AnuncioResource.class)
				.path(AnuncioResource.class, "getAnuncio").build(anuncioid);
		Link link = new Link();
		link.setUri(anuncioURI.toString());
		link.setRel("self");
		link.setTitle("Anuncio " + anuncioid);
		link.setType(MediaType.VIRTUAL_API_ANUNCIO);

		return link;
	}

	public final static Link buildURIImagen(UriInfo uriInfo, String imagenid,
			String anuncioid, String rel) {
		URI resenaURI = uriInfo.getBaseUriBuilder().path(AnuncioResource.class)
				.path("/" + anuncioid).path("/imagenes").path("/" + imagenid)
				.build();
		Link link = new Link();
		link.setUri(resenaURI.toString());
		link.setRel("self");
		link.setTitle("Imagenid " + imagenid);
		link.setType(MediaType.VIRTUAL_API_IMAGEN);

		return link;
	}

	public static final Link buildURIAnuncios(UriInfo uriInfo, String rel) {
		URI uriAnuncios;
		uriAnuncios = uriInfo.getBaseUriBuilder().path(AnuncioResource.class)
				.build();
		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("self");
		self.setTitle("Anuncios collection");
		self.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return self;
	}

	public static final Link buildURIAnuncios(UriInfo uriInfo, String offset,
			String length, String rel) {

		URI uriAnuncios;
		if (offset == null && length == null)
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).build();
		else {

			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length).build();
		}

		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("Anuncios");
		self.setTitle("Anuncios collection");
		self.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return self;
	}

	public static final Link buildURIAnunciosBusqueda(UriInfo uriInfo,
			String offset, String length, String subject, String content,
			String email, String rel) {

		URI uriAnuncios = null;

		if (subject == null && content == null && email != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("email", email).build();
		}

		else if (subject == null && content != null && email == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("content", content).build();
		}

		else if (subject == null && content != null && email != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("content", content).queryParam("email", email)
					.build();
		}

		else if (subject != null && content == null && email == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("subject", subject).build();
		}

		else if (subject != null && content == null && email != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("subject", subject).queryParam("email", email)
					.build();
		}

		else if (subject != null && content != null && email == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("subject", subject)
					.queryParam("content", content).build();
		}

		else if (subject != null && content != null && email != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("subject", subject)
					.queryParam("content", content).queryParam("email", email)
					.build();
		}

		else if (subject == null && content == null && email == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/search")
					.queryParam("offset", offset).queryParam("length", length)
					.build();
		}

		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("Anuncios");
		self.setTitle("Anuncios collection");
		self.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return self;
	}

	public static final Link buildURIMensajesConversacion(UriInfo uriInfo,
			String offset, String length, String anuncioid, String rel) {

		URI uriMensajes = null;

		if (anuncioid == null) {
			uriMensajes = uriInfo.getBaseUriBuilder()
					.path(MensajeResource.class, "getMensajesConversacion")
					.queryParam("offset", offset).queryParam("length", length)
					.build();

		}

		else {
			uriMensajes = uriInfo.getBaseUriBuilder()
					.path(MensajeResource.class, "getMensajesConversacion")
					.queryParam("anuncioid", anuncioid)
					.queryParam("offset", offset).queryParam("length", length)
					.build();

		}

		Link self = new Link();
		self.setUri(uriMensajes.toString());
		self.setRel("Mensajes");
		self.setTitle("Mensajes collection");
		self.setType(MediaType.VIRTUAL_API_MENSAJE_COLLECTION);

		return self;
	}

	public static final Link buildURIMensajesEnviados(UriInfo uriInfo,
			String offset, String length, String rel) {

		URI uriMensajes = null;

		uriMensajes = uriInfo.getBaseUriBuilder()
				.path(MensajeResource.class, "getMensajesEnviados")
				.queryParam("offset", offset).queryParam("length", length)
				.build();

		Link self = new Link();
		self.setUri(uriMensajes.toString());
		self.setRel("Mensajes");
		self.setTitle("Mensajes collection");
		self.setType(MediaType.VIRTUAL_API_MENSAJE_COLLECTION);

		return self;
	}

	public static final Link buildURIMensajesRecibidos(UriInfo uriInfo,
			String offset, String length, String rel) {

		URI uriMensajes = null;

		uriMensajes = uriInfo.getBaseUriBuilder()
				.path(MensajeResource.class, "getMensajesRecibidos")
				.queryParam("offset", offset).queryParam("length", length)
				.build();

		Link self = new Link();
		self.setUri(uriMensajes.toString());
		self.setRel("Mensajes");
		self.setTitle("Mensajes collection");
		self.setType(MediaType.VIRTUAL_API_MENSAJE_COLLECTION);

		return self;
	}

	public static final Link buildURIAnunciosPrecios(UriInfo uriInfo,
			String offset, String length, String precio1, String precio2,
			String rel) {

		URI uriAnuncios = null;

		uriAnuncios = uriInfo.getBaseUriBuilder().path(AnuncioResource.class)
				.path("/between").queryParam("offset", offset)
				.queryParam("length", length).queryParam("precio1", precio1)
				.queryParam("precio2", precio2).build();

		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("Anuncios por precios");
		self.setTitle("Anuncios collection");
		self.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return self;
	}

	public static final Link buildURIAnunciosOrderby(UriInfo uriInfo,
			String offset, String length, String atributo1, String atributo2,
			String atributo3, String marca, String rel) {

		URI uriAnuncios = null;
		if (atributo1 != null && atributo2 != null && atributo3 != null
				&& marca != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/atributos")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("atributo1", atributo1)
					.queryParam("atributo2", atributo2)
					.queryParam("atributo3", atributo3)
					.queryParam("marca", marca).build();
		}

		else if (atributo1 != null && atributo2 != null && atributo3 != null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/atributos")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("atributo1", atributo1)
					.queryParam("atributo2", atributo2)
					.queryParam("atributo3", atributo3).build();
		}

		else if (atributo1 != null && atributo2 != null && atributo3 == null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/atributos")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("atributo1", atributo1)
					.queryParam("atributo2", atributo2).build();
		}

		if (atributo1 != null && atributo2 == null && atributo3 == null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/atributos")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("atributo1", atributo1).build();
		}

		if (atributo1 == null && atributo2 == null && atributo3 == null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/atributos")
					.queryParam("offset", offset).queryParam("length", length)
					.build();
		}
		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("Anuncios");
		self.setTitle("Anuncios collection");
		self.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return self;
	}

	public static final Link buildURIAnunciosPrecio(UriInfo uriInfo,
			String offset, String length, String precio, String rel) {

		URI uriAnuncios;
		if (offset == null && length == null)
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).build();
		else {

			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).path("/orderby")
					.queryParam("offset", offset).queryParam("length", length)
					.queryParam("precio", precio).build();
		}

		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("Anuncios");
		self.setTitle("Anuncios collection");
		self.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return self;
	}

	public static final Link buildTemplatedURIAnuncios(UriInfo uriInfo,
			String rel)
	// no toman un valor en concreto sino que es una plantilla
	{
		URI uriAnuncios;
		uriAnuncios = uriInfo.getBaseUriBuilder().path(AnuncioResource.class)
				.queryParam("offset", "{offset}")
				.queryParam("length", "{length}").build();

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriAnuncios));
		link.setRel(rel);

		link.setTitle("Anuncios collection resource");
		link.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return link;
	}

	public static final Link buildTemplatedURIAnunciosBusqueda(UriInfo uriInfo,
			boolean subject, boolean content, boolean email, String rel)

	{
		URI uriAnuncios = null;

		if (subject == true && content == false && email == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosBusqueda")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("subject", "{subject}").build();
		}

		else if (subject == true && content == false && email == true) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosBusqueda")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("subject", "{subject}")
					.queryParam("email", "{email}").build();
		}

		else if (subject == false && content == true && email == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosBusqueda")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("content", "{content}").build();

		}

		else if (subject == false && content == true && email == true) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosBusqueda")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("content", "{content}")
					.queryParam("email", "{email}").build();

		}

		else if (subject == true && content == true && email == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosBusqueda")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("subject", "{subject}")
					.queryParam("content", "{content}").build();

		}

		else if (subject == true && content == true && email == true) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosBusqueda")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("subject", "{subject}")
					.queryParam("content", "{content}")
					.queryParam("email", "{email}").build();

		}

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriAnuncios));
		link.setRel(rel);

		link.setTitle("Anuncios collection resource");
		link.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return link;
	}

	public static final Link buildTemplatedURIAnunciosPrecios(UriInfo uriInfo,
			String rel)

	{
		URI uriAnuncios = null;

		uriAnuncios = uriInfo.getBaseUriBuilder()
				.path(AnuncioResource.class, "getAnunciosEntre")
				.queryParam("offset", "{offset}")
				.queryParam("length", "{length}")
				.queryParam("precio1", "{precio1}")
				.queryParam("precio2", "{precio2}").build();

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriAnuncios));
		link.setRel(rel);

		link.setTitle("Anuncios collection resource");
		link.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return link;
	}

	public static final Link buildTemplatedURIAnunciosOrderby(UriInfo uriInfo,
			boolean atributo1, boolean atributo2, boolean atributo3,
			boolean marca, String rel)

	{
		URI uriAnuncios = null;

		if (atributo1 == true && atributo2 == true && atributo3 == true
				&& marca == true) {

			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosAtributos")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("atributo1", "{atributo1}")
					.queryParam("atributo2", "{atributo2}")
					.queryParam("atributo3", "{atributo3}")
					.queryParam("marca", "{marca}").build();
		}

		else if (atributo1 == true && atributo2 == true && atributo3 == true
				&& marca == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosAtributos")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("atributo1", "{atributo1}")
					.queryParam("atributo2", "{atributo2}")
					.queryParam("atributo3", "{atributo3}").build();
		}

		else if (atributo1 == true && atributo2 == true && atributo3 == false
				&& marca == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosAtributos")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("atributo1", "{atributo1}")
					.queryParam("atributo2", "{atributo2}").build();
		}

		else if (atributo1 == true && atributo2 == false && atributo3 == false
				&& marca == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class, "getAnunciosAtributos")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("atributo1", "{atributo1}").build();
		}

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriAnuncios));
		link.setRel(rel);

		link.setTitle("Anuncios collection resource");
		link.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return link;
	}

	public static final Link buildTemplatedURIAnunciosPrecio(UriInfo uriInfo,
			String rel)
	// no toman un valor en concreto sino que es una plantilla
	{
		URI uriAnuncios;
		uriAnuncios = uriInfo.getBaseUriBuilder()
				.path(AnuncioResource.class, "getAnunciosPrecio")
				.queryParam("offset", "{offset}")
				.queryParam("length", "{length}")
				.queryParam("precio", "{precio}").build();

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriAnuncios));
		link.setRel(rel);

		link.setTitle("Anuncios collection resource");
		link.setType(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION);

		return link;
	}

	public static final Link buildURIUsers(UriInfo uriInfo, String rel) {
		URI uriUsers;

		uriUsers = uriInfo.getBaseUriBuilder().path(UserResource.class).build();

		Link self = new Link();
		self.setUri(uriUsers.toString());
		self.setRel(rel);
		self.setTitle("Users collection");
		self.setType(MediaType.VIRTUAL_API_USER_COLLECTION);

		return self;
	}

	public final static Link buildURIUserEmail(UriInfo uriInfo, String email,
			String rel) {
		URI userURI = uriInfo.getBaseUriBuilder().path(UserResource.class)
				.path(UserResource.class, "getUser").build(email);
		Link link = new Link();
		link.setUri(userURI.toString());
		link.setRel("self");
		link.setTitle("User Email " + email);
		link.setType(MediaType.VIRTUAL_API_USER);
		return link;
	}

	public final static Link buildTemplatedURIUserEmail(UriInfo uriInfo,
			String rel) {

		URI uriUser;
		uriUser = uriInfo.getBaseUriBuilder()
				.path(UserResource.class, "getUserBusqueda")
				.queryParam("email", "{email}").build();
		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriUser));
		link.setRel(rel);

		link.setTitle("User by email");
		link.setType(MediaType.VIRTUAL_API_USER_COLLECTION);

		return link;

	}

	public static final Link buildURIMensajes(UriInfo uriInfo, String rel) {
		URI uriMensajes;

		uriMensajes = uriInfo.getBaseUriBuilder().path(MensajeResource.class)
				.build();

		Link self = new Link();
		self.setUri(uriMensajes.toString());
		self.setRel(rel);
		self.setTitle("Users collection");
		self.setType(MediaType.VIRTUAL_API_USER_COLLECTION);

		return self;
	}

	public final static Link buildURIMensajeId(UriInfo uriInfo,
			String mensajeid, String rel) {
		URI libroURI = uriInfo.getBaseUriBuilder().path(MensajeResource.class)
				.path(MensajeResource.class, "getMensaje").build(mensajeid);
		Link link = new Link();
		link.setUri(libroURI.toString());
		link.setRel("self");
		link.setTitle("Mensaje " + mensajeid);
		link.setType(MediaType.VIRTUAL_API_MENSAJE);

		return link;
	}

	public static final Link buildTemplatedURIMensajesConversacion(
			UriInfo uriInfo, String rel, boolean anuncioid)

	{
		URI uriMensajes = null;

		if (anuncioid == false) {
			uriMensajes = uriInfo.getBaseUriBuilder()
					.path(MensajeResource.class, "getMensajesConversacion")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}").build();

		}

		else if (anuncioid == true) {

			uriMensajes = uriInfo.getBaseUriBuilder()
					.path(MensajeResource.class, "getMensajesConversacion")
					.queryParam("anuncioid", "{anuncioid}")
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}").build();
		}

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriMensajes));
		link.setRel(rel);

		link.setTitle("Mensajes conversacion");
		link.setType(MediaType.VIRTUAL_API_MENSAJE_COLLECTION);

		return link;
	}

	public static final Link buildTemplatedURIMensajesEnviados(UriInfo uriInfo,
			String rel)

	{
		URI uriMensajes = null;

		uriMensajes = uriInfo.getBaseUriBuilder()
				.path(MensajeResource.class, "getMensajesEnviados")
				.queryParam("offset", "{offset}")
				.queryParam("length", "{length}").build();

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriMensajes));
		link.setRel(rel);

		link.setTitle("Mensajes enviados");
		link.setType(MediaType.VIRTUAL_API_MENSAJE_COLLECTION);

		return link;
	}

	public static final Link buildTemplatedURIMensajesRecibidos(
			UriInfo uriInfo, String rel)

	{
		URI uriMensajes = null;

		uriMensajes = uriInfo.getBaseUriBuilder()
				.path(MensajeResource.class, "getMensajesRecibidos")
				.queryParam("offset", "{offset}")
				.queryParam("length", "{length}").build();

		Link link = new Link();
		link.setUri(URITemplateBuilder.buildTemplatedURI(uriMensajes));
		link.setRel(rel);

		link.setTitle("Mensajes recibidos");
		link.setType(MediaType.VIRTUAL_API_MENSAJE_COLLECTION);

		return link;
	}
}
