package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links;

import java.net.URI;

import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.AnuncioResource;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.MediaType;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api.VirtualRootAPIResource;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Anuncio;

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
		URI libroURI = uriInfo.getBaseUriBuilder().path(AnuncioResource.class)
				.path(AnuncioResource.class, "getAnuncio").build(anuncioid);
		Link link = new Link();
		link.setUri(libroURI.toString());
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
		link.setTitle("Idresena " + imagenid);
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
			String rel) {

		URI uriAnuncios = null;
		if (subject != null && content == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("subject", subject).build();
		}

		else if (subject == null && content != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("content", content).build();
		}

		else if (subject != null && content != null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("subject", subject)
					.queryParam("content", content).build();
		}

		Link self = new Link();
		self.setUri(uriAnuncios.toString());
		self.setRel("Anuncios");
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
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("atributo1", atributo1)
					.queryParam("atributo2", atributo2)
					.queryParam("atributo3", atributo3)
					.queryParam("marca", marca).build();
		}

		else if (atributo1 != null && atributo2 != null && atributo3 != null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("atributo1", atributo1)
					.queryParam("atributo2", atributo2)
					.queryParam("atributo3", atributo3).build();
		}

		else if (atributo1 != null && atributo2 != null && atributo3 == null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("atributo1", atributo1)
					.queryParam("atributo2", atributo2).build();
		}

		if (atributo1 != null && atributo2 == null && atributo3 == null
				&& marca == null) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length)
					.queryParam("atributo1", atributo1).build();
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
					.path(AnuncioResource.class).queryParam("offset", offset)
					.queryParam("length", length).queryParam("precio", precio)
					.build();
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
			boolean subject, boolean content, String rel)

	{
		URI uriAnuncios = null;

		if (subject == true && content == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class)
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("subject", "{subject}").build();
		}

		else if (subject == false && content == true) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class)
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("content", "{content}").build();

		}

		else if (subject == true && content == true) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class)
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("subject", "{subject}")
					.queryParam("content", "{content}").build();

		}

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
					.path(AnuncioResource.class)
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
					.path(AnuncioResource.class)
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("atributo1", "{atributo1}")
					.queryParam("atributo2", "{atributo2}")
					.queryParam("atributo3", "{atributo3}").build();
		}

		else if (atributo1 == true && atributo2 == true && atributo3 == false
				&& marca == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class)
					.queryParam("offset", "{offset}")
					.queryParam("length", "{length}")
					.queryParam("atributo1", "{atributo1}")
					.queryParam("atributo2", "{atributo2}").build();
		}

		else if (atributo1 == true && atributo2 == false && atributo3 == false
				&& marca == false) {
			uriAnuncios = uriInfo.getBaseUriBuilder()
					.path(AnuncioResource.class)
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
		uriAnuncios = uriInfo.getBaseUriBuilder().path(AnuncioResource.class)
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

}
