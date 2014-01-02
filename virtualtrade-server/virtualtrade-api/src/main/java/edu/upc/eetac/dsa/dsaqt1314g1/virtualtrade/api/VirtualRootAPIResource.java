package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.VirtualAPILinkBuilder;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualRootAPI;

@Path("/")
public class VirtualRootAPIResource {

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces(MediaType.VIRTUAL_API_LINK_COLLECTION)
	public VirtualRootAPI getLinks() {
		VirtualRootAPI root = new VirtualRootAPI();

		root.add(VirtualAPILinkBuilder.buildURIRootAPI(uriInfo));
		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnuncios(uriInfo,
				"anuncios"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, true, true, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, true, false, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, false, false, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, false, true, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, false, true, false, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, false, true, true, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, true, true, true, "atributos"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, true, true, false, "atributos"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, true, false, false, "atributos"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, false, false, false, "atributos"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosPrecio(uriInfo,
				"precio ascendente o descendente"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosPrecios(
				uriInfo, "anuncios entre 2 precios"));

		root.add(VirtualAPILinkBuilder.buildURIMensajes(uriInfo,
				"Mensaje collection"));

		root.add(VirtualAPILinkBuilder
				.buildURIUsers(uriInfo, "User collection"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIUserEmail(uriInfo,
				"get user by email"));

		return root;
	}
}
