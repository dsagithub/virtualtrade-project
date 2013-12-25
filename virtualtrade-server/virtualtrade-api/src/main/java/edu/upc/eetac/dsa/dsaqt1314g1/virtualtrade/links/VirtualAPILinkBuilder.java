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

}
