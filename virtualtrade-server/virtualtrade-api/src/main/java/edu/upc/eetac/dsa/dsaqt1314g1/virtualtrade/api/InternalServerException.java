package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualError;

public class InternalServerException extends WebApplicationException {
	public InternalServerException(String message) {
		super(Response
				.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(new VirtualError(Response.Status.INTERNAL_SERVER_ERROR
						.getStatusCode(), message))
				.type(MediaType.VIRTUAL_API_ERROR).build());
	}
}
