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

		return root;
	}

}
