package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.ServiceUnavailableException;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.VirtualAPILinkBuilder;
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
			try {
				throw new ServiceUnavailableException(e.getMessage());
			} catch (ServiceUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
				
				user.add(VirtualAPILinkBuilder.buildURIUserEmail(uriInfo,
						rs.getString("email"), rel));

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
			try {
				throw new ServiceUnavailableException(e.getMessage());
			} catch (ServiceUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

				user.add(VirtualAPILinkBuilder.buildURIUserEmail(uriInfo,
						rs.getString("email"), rel));
			}
		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		} finally {
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

	@DELETE
	@Path("/{email}")
	public void deleteUser(@PathParam("email") String email) {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			try {
				throw new ServiceUnavailableException(e.getMessage());
			} catch (ServiceUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM users WHERE email='" + email + "'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	@GET
	@Path("?search")
	@Produces(MediaType.VIRTUAL_API_USER_COLLECTION)
	public UserCollection getUserbusqueda(
			@QueryParam("name") String name) {

		UserCollection users = new UserCollection();
		Connection conn = null;
		Statement stmt = null;
		String sql;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			try {
				throw new ServiceUnavailableException(e.getMessage());
			} catch (ServiceUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM users WHERE name LIKE '%" + name + "%'";
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


				user.add(VirtualAPILinkBuilder.buildURIUserEmail(uriInfo,
						rs.getString("email"), rel));
				users.add(user);
				
				
/*
				Pelicula pelicula = new Pelicula();
				pelicula.setCast(rs.getString("cast"));
				pelicula.setDirector(rs.getString("director"));
				pelicula.setMovieid(rs.getInt("movieid"));
				pelicula.setScript(rs.getString("script"));
				pelicula.setTitle(rs.getString("title"));
				pelicula.setUsername(rs.getString("username"));
				pelicula.setYear(rs.getInt("year"));
				pelicula.setLast_modified(rs.getTimestamp("last_modified"));

				peliculas.add(pelicula);
				*/
			}

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		} finally {
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
	
	
	
	
	

	@POST
	@Consumes(MediaType.VIRTUAL_API_USER)
	@Produces(MediaType.VIRTUAL_API_USER)
	public User createUser(User user) {
		// TODO: get connection from database
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			try {
				throw new ServiceUnavailableException(e.getMessage());
			} catch (ServiceUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			stmt = conn.createStatement();
			String update = null; // TODO: create update query
			update = "INSERT INTO users (email,name,phone,ciudad,calle,numero,piso,puerta,banned,foto) VALUES ('"
					+ user.getEmail() + "','" + user.getName() + "','"
					 + user.getPhone() + "','"
					 + user.getCiudad() + "','"
					 + user.getCalle() + "','"
					 + user.getNumero() + "','"
					 + user.getPiso() + "','"
					 + user.getPuerta() + "','"
					 + false + "','"
					+ user.getFoto() + "')";
			int rows = stmt.executeUpdate(update,
					Statement.RETURN_GENERATED_KEYS);
			if (rows != 0) {
				String sql = "SELECT * FROM users WHERE name='"
						+ user.getName() + "'";
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				
				user.add(VirtualAPILinkBuilder.buildURIUserEmail(uriInfo,
						rs.getString("email"), rel));
				/*
				user.add(LibrosAPILinkBuilder.buildURIUserName(uriInfo,
						rs.getString("username"), rel)); */
				// TODO: Retrieve the created sting from the database to get all
				// the remaining fields
			} else
				throw new UserNotFoundException();
		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		} finally {
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
	
	

	@PUT
	@Path("/{email}")
	@Consumes(MediaType.VIRTUAL_API_USER)
	@Produces(MediaType.VIRTUAL_API_USER)
	public User updateUser(@PathParam("email") String email, User user) {

		// TODO: get connection from database
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			try {
				throw new ServiceUnavailableException(e.getMessage());
			} catch (ServiceUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {

			stmt = conn.createStatement();
			String update = null; // TODO: create update query

			if (user.getName() != null && user.getEmail() != null) {
				update = "UPDATE users SET users.name='" + user.getName()
						+ "' , users.email= '" + user.getEmail()
						+ "' WHERE email='" + email + "'";
			}

			else if (user.getName() != null && user.getEmail() == null) {
				update = "UPDATE users SET users.name='" + user.getName()
						+ "' WHERE email='" + email + "'";

			}
			else if (user.getName() == null && user.getEmail() != null) {
				update = "UPDATE users SET users.email='" + user.getEmail()
						+ "' WHERE email='" + email + "'";
			}
			else if (user.getPhone() != 0){
			
			}
			
			else {
				throw new BadRequestException(
						"Error");
			}
			int rows = stmt.executeUpdate(update,
					Statement.RETURN_GENERATED_KEYS);
			if (rows != 0) {
				String sql = "SELECT * FROM users WHERE email='" + email
						+ "'";
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				
				/*
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				*/
				
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
			else
				throw new UserNotFoundException();
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