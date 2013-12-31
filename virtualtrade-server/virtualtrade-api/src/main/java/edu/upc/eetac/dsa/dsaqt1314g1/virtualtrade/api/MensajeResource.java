package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.VirtualAPILinkBuilder;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Mensaje;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.MensajeCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualRootAPI;

@Path("/mensajes")
public class MensajeResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private SecurityContext security;

	VirtualRootAPI root = new VirtualRootAPI();
	String rel = null;
	
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	
	@GET//Obtener los mensajes enviados y recibidos por un usuario 
	@Path("/user_message")
	@Produces(MediaType.VIRTUAL_API_MENSAJE_COLLECTION)
	public MensajeCollection getMensajesConversacion(@QueryParam("email") String email,@QueryParam("offset") String offset,
			@QueryParam("length") String length) {
		MensajeCollection mensajes = new MensajeCollection();

		Connection conn = null;
		Statement stmt = null;
		String sql;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			sql = "SELECT * from mensaje where emailorigen ='"+email+"' or emaildestino='"+email+"' ORDER by creation_timestamp LIMIT "
					+ offset + "," + length + "";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next() == false) {
				throw new MensajeNotFoundException();
			}

			else {

				while (rs.next()) {
					Mensaje mensaje = new Mensaje();
					mensaje.setMensajeid(rs.getInt("mensajeid"));
					mensaje.setEmailorigen(rs.getString("emailorigen"));
					mensaje.setEmaildestino(rs.getString("emaildestino"));
					mensaje.setCreation_timestamp(rs.getDate("creation_timestamp"));
					mensaje.setAnuncioid(rs.getInt("anuncioid"));
					mensaje.setSubject(rs.getString("subject"));
					mensaje.setContent(rs.getString("content"));
				
					mensajes.add(mensaje);
				}
			}
		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				conn.close();
			}

			catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return mensajes;

	}

}
