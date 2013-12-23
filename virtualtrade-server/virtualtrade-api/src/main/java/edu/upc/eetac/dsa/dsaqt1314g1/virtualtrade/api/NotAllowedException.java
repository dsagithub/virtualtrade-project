package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualError;

public class NotAllowedException extends WebApplicationException {
	private final static String MESSAGE = "No se te permite realizar ésta acción";

	public NotAllowedException() {
		super(Response
				.status(Response.Status.FORBIDDEN)
				.entity(new VirtualError(Response.Status.FORBIDDEN
						.getStatusCode(), MESSAGE))
				.type(MediaType.VIRTUAL_API_ERROR).build());
	}
}