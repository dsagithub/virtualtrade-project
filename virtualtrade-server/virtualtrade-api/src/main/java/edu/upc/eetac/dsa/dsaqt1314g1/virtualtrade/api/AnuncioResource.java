package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.DELETE;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Imagen;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualRootAPI;

@Path("/anuncios")

public class AnuncioResource {

	@Context
	private UriInfo uriInfo;
	@Context
	private SecurityContext security;
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	VirtualRootAPI root = new VirtualRootAPI();
	String rel = null;

	@GET
	@Path("/{anuncioid}")
	@Produces(MediaType.VIRTUAL_API_ANUNCIO)
	public Anuncio getAnuncio(@PathParam("anuncioid") String anuncioid) {
		
		Anuncio anuncio = new Anuncio();
//		Imagen imagen = new Imagen();

		Connection conn = null;
		Statement stmt = null;
		String sql;
//		String sql2;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM anuncio WHERE anuncioid= '" + anuncioid + "'";
//			sql2 = "SELECT * FROM imagen WHERE anuncioid= '" + anuncioid + "'";
			ResultSet rs = stmt.executeQuery(sql);
//			ResultSet rs2 = stmt.executeQuery(sql2);
			if (rs.next()) {
				
				anuncio.setAnuncioid(rs.getInt("anuncioid"));
				anuncio.setEmail(rs.getString("Email"));
				anuncio.setSubject(rs.getString("subject"));
				anuncio.setContent(rs.getString("content"));
				anuncio.setEstado(rs.getBoolean("estado"));
				anuncio.setPrecio(rs.getInt("precio"));
				anuncio.setCreation_timestamp(rs.getTimestamp("creation_timestamp"));
				anuncio.setAtributo1(rs.getString("atributo1"));
				anuncio.setAtributo2(rs.getString("atributo2"));
				anuncio.setAtributo3(rs.getString("atributo3"));
				anuncio.setMarca(rs.getString("marca"));
				
//				imagen.setImagenid(rs.getInt("imagenid"));
//				imagen.setAnuncioid(rs.getInt("anuncioid"));
//				imagen.setUrlimagen(rs.getString("urlimagen"));
				
				
			}
		} catch (SQLException e) {
			throw new AnuncioNotFoundException();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return anuncio;
//		return imagen;
	}

	
	@DELETE
	@Path("/{anuncioid}")
	public void deleteAnuncio(@PathParam("anuncioid") String anuncioid) {
		
//		if (security.isUserInRole("registered")) {
//
//			throw new ForbiddenException("You are not allowed");
//
//		}

//		else {

			Connection conn = null;
			Statement stmt = null;
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				throw new ServiceUnavailableException(e.getMessage());
			}

			try {
				
				stmt = conn.createStatement();
				String sql ="SELECT * FROM anuncio WHERE anuncioid='" + anuncioid + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next() == false) {
					throw new AnuncioNotFoundException();
				}
				else{
				

				sql = "DELETE FROM imagen WHERE anuncioid='" + anuncioid + "'";
				stmt.executeUpdate(sql);
				sql = "DELETE FROM mensaje WHERE anuncioid='" + anuncioid + "'";
				stmt.executeUpdate(sql);
				sql = "DELETE FROM anuncio WHERE anuncioid='" + anuncioid + "'";
				stmt.executeUpdate(sql);
				
				}
				

			} catch (SQLException e) {
				throw new InternalServerException(e.getMessage());
			}

			finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
//		}
		

	}
	
	
	
	
	
	
	
	
}
