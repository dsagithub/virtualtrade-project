package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.ForbiddenException;
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

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.Link;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.VirtualAPILinkBuilder;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.AnuncioCollection;
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
		// Imagen imagen = new Imagen();

		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		String sql;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM anuncio WHERE anuncioid='" + anuncioid + "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				anuncio.setAnuncioid(rs.getInt("anuncioid"));
				anuncio.setEmail(rs.getString("email"));
				anuncio.setSubject(rs.getString("subject"));
				anuncio.setContent(rs.getString("content"));
				anuncio.setEstado(rs.getBoolean("estado"));
				anuncio.setPrecio(rs.getInt("precio"));
				anuncio.setCreation_timestamp(rs
						.getTimestamp("creation_timestamp"));
				anuncio.setAtributo1(rs.getString("atributo1"));
				anuncio.setAtributo2(rs.getString("atributo2"));
				anuncio.setAtributo3(rs.getString("atributo3"));
				anuncio.setMarca(rs.getString("marca"));
				anuncio.add(VirtualAPILinkBuilder.buildURIAnuncioId(uriInfo,
						anuncioid, rel));

				try {
					stmt1 = conn.createStatement();
					sql = "SELECT * FROM imagen WHERE anuncioid='" + anuncioid
							+ "'";

					ResultSet rs1 = stmt1.executeQuery(sql);

					while (rs1.next()) {
						Imagen imagen = new Imagen();
						imagen.setImagenid(rs1.getInt("imagenid"));
						imagen.setUrlimagen(rs1.getString("urlimagen"));
						imagen.setAnuncioid(rs1.getInt("anuncioid"));
						imagen.add(VirtualAPILinkBuilder.buildURIImagen(
								uriInfo, rs1.getString("imagenid"), anuncioid,
								rel));
						anuncio.add(imagen);
					}
				} catch (SQLException e) {
					throw new AnuncioNotFoundException();
				}

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
		// return imagen;
	}

	@GET
	@Produces(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION)
	public AnuncioCollection getAnuncios(@QueryParam("offset") String offset,
			@QueryParam("length") String length) {

		if ((offset == null) || (length == null))
			throw new BadRequestException(
					"offset and length are mandatory parameters");
		int ioffset, ilength;
		try {
			ioffset = Integer.parseInt(offset);
			if (ioffset < 0)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			throw new BadRequestException(
					"offset must be an integer greater or equal than 0.");
		}
		try {
			ilength = Integer.parseInt(length);
			if (ilength < 1)
				throw new NumberFormatException();
		} catch (NumberFormatException e) {
			throw new BadRequestException(
					"length must be an integer greater or equal than 1.");
		}

		AnuncioCollection anuncios = new AnuncioCollection();

		// TODO: Retrieve all stings stored in the database, instantiate one
		// Sting for each one and store them in the StingCollection.
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		String sql;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();

			sql = "SELECT * FROM anuncio ORDER BY creation_timestamp LIMIT "
					+ offset + "," + length + "";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Anuncio anuncio = new Anuncio();

				anuncio.setAnuncioid(rs.getInt("anuncioid"));
				anuncio.setEmail(rs.getString("email"));
				anuncio.setSubject(rs.getString("subject"));
				anuncio.setContent(rs.getString("content"));
				anuncio.setEstado(rs.getBoolean("estado"));
				anuncio.setPrecio(rs.getInt("precio"));
				anuncio.setCreation_timestamp(rs
						.getTimestamp("creation_timestamp"));
				anuncio.setAtributo1(rs.getString("atributo1"));
				anuncio.setAtributo2(rs.getString("atributo2"));
				anuncio.setAtributo3(rs.getString("atributo3"));
				anuncio.setMarca(rs.getString("marca"));
				anuncio.add(VirtualAPILinkBuilder.buildURIAnuncioId(uriInfo,
						rs.getString("anuncioid"), rel));

				List<Link> links = new ArrayList<Link>();
				links.add(VirtualAPILinkBuilder.buildURIAnuncios(uriInfo, rel));
				links.add(VirtualAPILinkBuilder.buildURIAnuncios(uriInfo,
						offset, length, rel));

				if (Integer.parseInt(offset) - Integer.parseInt(length) >= 0) {
					links.add(VirtualAPILinkBuilder.buildURIAnuncios(
							uriInfo,
							(Integer.toString(Integer.parseInt(offset)
									- Integer.parseInt(length))), length, rel));
				}

				links.add(VirtualAPILinkBuilder.buildURIAnuncios(
						uriInfo,
						(Integer.toString(Integer.parseInt(offset)
								+ Integer.parseInt(length))), length, rel));

				anuncios.setLinks(links);

				try {
					stmt1 = conn.createStatement();
					sql = "SELECT * FROM imagen WHERE anuncioid='"
							+ rs.getString("anuncioid") + "'";

					ResultSet rs1 = stmt1.executeQuery(sql);

					while (rs1.next()) {
						Imagen imagen = new Imagen();
						imagen.setImagenid(rs1.getInt("imagenid"));
						imagen.setUrlimagen(rs1.getString("urlimagen"));
						imagen.setAnuncioid(rs1.getInt("anuncioid"));
						imagen.add(VirtualAPILinkBuilder.buildURIImagen(
								uriInfo, rs1.getString("imagenid"),
								rs.getString("anuncioid"), rel));
						anuncio.add(imagen);
					}
				} catch (SQLException e) {
					throw new AnuncioNotFoundException();
				}

				anuncios.add(anuncio);
			}
		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				stmt1.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return anuncios;
	}

	@DELETE
	@Path("/{anuncioid}")
	public void deleteAnuncio(@PathParam("anuncioid") String anuncioid) {

		// if (security.isUserInRole("registered")) {
		//
		// throw new ForbiddenException("You are not allowed");
		//
		// }

		// else {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {

			stmt = conn.createStatement();
			String sql = "SELECT * FROM anuncio WHERE anuncioid='" + anuncioid
					+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == false) {
				throw new AnuncioNotFoundException();
			} else {

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
		// }

	}

	@POST
	@Consumes(MediaType.VIRTUAL_API_ANUNCIO)
	@Produces(MediaType.VIRTUAL_API_ANUNCIO)
	public Anuncio createAnuncio(Anuncio anuncio) {

		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {

			stmt = conn.createStatement();
			String update = null;
			update = "INSERT INTO anuncio (email, subject, content, estado, precio, atributo1, atributo2, atributo3, marca) VALUES ('"
					+ anuncio.getEmail()
					+ "','"
					+ anuncio.getSubject()
					+ "','"
					+ anuncio.getContent()
					+ "', "
					+ anuncio.isEstado()
					+ ", '"
					+ anuncio.getPrecio()
					+ "','"
					+ anuncio.getAtributo1()
					+ "','"
					+ anuncio.getAtributo2()
					+ "','"
					+ anuncio.getAtributo3()
					+ "', '"
					+ anuncio.getMarca()
					+ "')";
			stmt.executeUpdate(update, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();

			try {
				int anuncioid = rs.getInt(1);
				rs.close();
				String sql = "SELECT * FROM anuncio WHERE anuncioid= '"
						+ anuncioid + "'";

				rs = stmt.executeQuery(sql);
				if (rs.next()) {

					anuncio.setAnuncioid(rs.getInt("anuncioid"));
					anuncio.setEmail(rs.getString("Email"));
					anuncio.setSubject(rs.getString("subject"));
					anuncio.setContent(rs.getString("content"));
					anuncio.setEstado(rs.getBoolean("estado"));
					anuncio.setPrecio(rs.getInt("precio"));
					anuncio.setCreation_timestamp(rs
							.getTimestamp("creation_timestamp"));
					anuncio.setAtributo1(rs.getString("atributo1"));
					anuncio.setAtributo2(rs.getString("atributo2"));
					anuncio.setAtributo3(rs.getString("atributo3"));
					anuncio.setMarca(rs.getString("marca"));

				}

				else
					throw new AnuncioNotFoundException();

			} catch (SQLException e) {
				throw new InternalServerException(e.getMessage());
			}

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				stmt1.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return anuncio;

	}

	@PUT
	@Path("/{anuncioid}")
	@Consumes(MediaType.VIRTUAL_API_ANUNCIO)
	@Produces(MediaType.VIRTUAL_API_ANUNCIO)
	public Anuncio updateAnuncio(@PathParam("anuncioid") int anuncioid,
			Anuncio anuncio) {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {

			stmt = conn.createStatement();
			String update = null; // TODO: create update query

			update = "UPDATE anuncio SET anuncio.email='" + anuncio.getEmail()
					+ "', anuncio.subject='" + anuncio.getSubject()
					+ "', anuncio.content='" + anuncio.getContent()
					+ "', anuncio.estado=" + anuncio.isEstado()
					+ ", anuncio.precio='" + anuncio.getPrecio()
					+ "', anuncio.atributo1='" + anuncio.getAtributo1()
					+ "', anuncio.atributo2='" + anuncio.getAtributo2()
					+ "', anuncio.atributo3='" + anuncio.getAtributo3()
					+ "', anuncio.marca='" + anuncio.getMarca()
					+ "' WHERE anuncioid='" + anuncioid + "'";

			int rows = stmt.executeUpdate(update,
					Statement.RETURN_GENERATED_KEYS);
			if (rows != 0) {

				String sql = "SELECT * FROM anuncio WHERE anuncioid='"
						+ anuncioid + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					anuncio.setAnuncioid(rs.getInt("anuncioid"));
					anuncio.setEmail(rs.getString("Email"));
					anuncio.setSubject(rs.getString("subject"));
					anuncio.setContent(rs.getString("content"));
					anuncio.setEstado(rs.getBoolean("estado"));
					anuncio.setPrecio(rs.getInt("precio"));
					anuncio.setCreation_timestamp(rs
							.getTimestamp("creation_timestamp"));
					anuncio.setAtributo1(rs.getString("atributo1"));
					anuncio.setAtributo2(rs.getString("atributo2"));
					anuncio.setAtributo3(rs.getString("atributo3"));
					anuncio.setMarca(rs.getString("marca"));
				}
			} else
				throw new AnuncioNotFoundException();
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
		return anuncio;
	}

}
