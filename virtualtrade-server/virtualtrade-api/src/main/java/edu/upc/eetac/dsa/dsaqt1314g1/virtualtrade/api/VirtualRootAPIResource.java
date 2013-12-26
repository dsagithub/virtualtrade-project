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
				uriInfo, true, true, true,"search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, true,false, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, false,false, "search"));
		
		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, true, false,true, "search"));
		
		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, false, true,false, "search"));
		
		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosBusqueda(
				uriInfo, false, true,true, "search"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, true, true, true, "orderby"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, true, true, false, "orderby"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, true, false, false, "orderby"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosOrderby(
				uriInfo, true, false, false, false, "orderby"));

		root.add(VirtualAPILinkBuilder.buildTemplatedURIAnunciosPrecio(uriInfo,
				"precio ascendente o descendente"));

		return root;
	}

}
