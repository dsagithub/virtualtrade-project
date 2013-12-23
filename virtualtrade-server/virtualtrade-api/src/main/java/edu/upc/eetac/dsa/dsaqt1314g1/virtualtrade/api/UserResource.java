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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.User;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.UserCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualRootAPI;

@Path("/users")
public class UserResource {

	@Context
	private UriInfo uriInfo;
	@Context
	private SecurityContext security;
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	VirtualRootAPI root = new VirtualRootAPI();
	String rel = null;

	@GET
	@Produces(MediaType.VIRTUAL_API_USER_COLLECTION)
	public UserCollection getUsers() {
		UserCollection users = new UserCollection();

		// TODO: Retrieve all stings stored in the database, instantiate one
		// Sting for each one and store them in the StingCollection.
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
			sql = "SELECT * FROM users";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getInt("phone"));
				user.setFoto(rs.getString("foto"));
				user.setCiudad(rs.getString("ciudad"));
				user.setCalle(rs.getString("calle"));
				user.setNumero(rs.getInt("numero"));
				user.setPiso(rs.getInt("piso"));
				user.setPuerta(rs.getInt("puerta"));
				user.setBanned(rs.getBoolean("banned"));
			
				users.add(user);
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
		return users;
	}
	
	@GET
	@Path("/{email}")
	@Produces(MediaType.VIRTUAL_API_USER)
	public User getUser(@PathParam("email") String email) {
		User user = new User();

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
			sql = "SELECT * FROM users WHERE email= '" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getInt("phone"));
				user.setFoto(rs.getString("foto"));
				user.setCiudad(rs.getString("ciudad"));
				user.setCalle(rs.getString("calle"));
				user.setNumero(rs.getInt("numero"));
				user.setPiso(rs.getInt("piso"));
				user.setPuerta(rs.getInt("puerta"));
				user.setBanned(rs.getBoolean("banned"));
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
		return user;
	}
	
}