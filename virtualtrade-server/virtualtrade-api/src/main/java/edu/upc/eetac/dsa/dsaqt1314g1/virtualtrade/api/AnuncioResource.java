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
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.Link;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.VirtualAPILinkBuilder;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Anuncio;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.AnuncioCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Imagen;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.ImagenCollection;
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
	public Anuncio getAnuncio(@PathParam("anuncioid") String anuncioid,
			@Context Request req) {

		Anuncio anuncio = new Anuncio();

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
			stmt1 = conn.createStatement();
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

	}

	@GET
	@Produces(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION)
	public AnuncioCollection getAnuncios(@QueryParam("offset") String offset,
			@QueryParam("length") String length, @Context Request req) {

		AnuncioCollection anuncios = new AnuncioCollection();

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
			stmt1 = conn.createStatement();

			sql = "SELECT * FROM anuncio ORDER BY creation_timestamp LIMIT "
					+ offset + "," + length + "";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				rs.previous();
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
					anuncio.add(VirtualAPILinkBuilder.buildURIAnuncioId(
							uriInfo, rs.getString("anuncioid"), rel));

					List<Link> links = new ArrayList<Link>();

					links.add(VirtualAPILinkBuilder.buildURIAnuncios(
							uriInfo,
							(Integer.toString(Integer.parseInt(offset)
									+ Integer.parseInt(length))), length, rel));

					if (Integer.parseInt(offset) - Integer.parseInt(length) >= 0) {
						links.add(VirtualAPILinkBuilder.buildURIAnuncios(
								uriInfo,
								(Integer.toString(Integer.parseInt(offset)
										- Integer.parseInt(length))), length,
								rel));
					}

					links.add(VirtualAPILinkBuilder.buildURIAnuncios(uriInfo,
							offset, length, rel));

					anuncios.setLinks(links);

					try {
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
			} else {

				throw new AnuncioNotFoundException();
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

		String email;
		Connection conn = null;
		Statement stmt = null;
		String sql;
		ResultSet rs;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM anuncio WHERE anuncioid='" + anuncioid + "'";
			rs = stmt.executeQuery(sql);
			rs.next();
			email = rs.getString("email");

			if ((security.getUserPrincipal().getName().equals(email))
					|| (security.isUserInRole("admin"))) {

				try {

					stmt = conn.createStatement();
					sql = "DELETE FROM imagen WHERE anuncioid='" + anuncioid
							+ "'";
					stmt.executeUpdate(sql);
					sql = "DELETE FROM mensaje WHERE anuncioid='" + anuncioid
							+ "'";
					stmt.executeUpdate(sql);
					sql = "DELETE FROM anuncio WHERE anuncioid='" + anuncioid
							+ "'";
					stmt.executeUpdate(sql);

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
			}

			else {
				throw new NotAllowedException();
			}

		} catch (SQLException e) {
			throw new AnuncioNotFoundException();
		}

	}

	@POST
	@Consumes(MediaType.VIRTUAL_API_ANUNCIO)
	@Produces(MediaType.VIRTUAL_API_ANUNCIO)
	public Anuncio createAnuncio(Anuncio anuncio) {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}
		try {

			String email = security.getUserPrincipal().getName();
			stmt = conn.createStatement();
			String update = null;
			update = "INSERT INTO anuncio (email, subject, content, estado, precio, atributo1, atributo2, atributo3, marca) VALUES ('"
					+ email
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

			if (rs.next()) {
				int anuncioid = rs.getInt(1);
				rs.close();
				String sql = "SELECT * FROM anuncio WHERE anuncioid= '"
						+ anuncioid + "'";

				rs = stmt.executeQuery(sql);
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
					String anuncioid2 = Integer.toString(anuncioid);
					anuncio.add(VirtualAPILinkBuilder.buildURIAnuncioId(
							uriInfo, anuncioid2, rel));

				}

				else
					throw new AnuncioNotFoundException();

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

		return anuncio;

	}

	@PUT
	@Path("/{anuncioid}")
	@Consumes(MediaType.VIRTUAL_API_ANUNCIO)
	@Produces(MediaType.VIRTUAL_API_ANUNCIO)
	public Anuncio updateAnuncio(@PathParam("anuncioid") String anuncioid,
			Anuncio anuncio) {

		String email;
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		String sql;
		ResultSet rs;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			sql = "SELECT * FROM anuncio WHERE anuncioid='" + anuncioid + "'";
			rs = stmt.executeQuery(sql);
			rs.next();
			email = rs.getString("email");

			if ((security.getUserPrincipal().getName().equals(email))
					|| (security.isUserInRole("admin"))) {

				try {

					String update = null;

					update = "UPDATE anuncio SET anuncio.subject='"
							+ anuncio.getSubject() + "', anuncio.content='"
							+ anuncio.getContent() + "', anuncio.estado="
							+ anuncio.isEstado() + ", anuncio.precio='"
							+ anuncio.getPrecio() + "', anuncio.atributo1='"
							+ anuncio.getAtributo1() + "', anuncio.atributo2='"
							+ anuncio.getAtributo2() + "', anuncio.atributo3='"
							+ anuncio.getAtributo3() + "', anuncio.marca='"
							+ anuncio.getMarca() + "' WHERE anuncioid='"
							+ anuncioid + "'";

					int rows = stmt.executeUpdate(update,
							Statement.RETURN_GENERATED_KEYS);
					if (rows != 0) {

						sql = "SELECT * FROM anuncio WHERE anuncioid='"
								+ anuncioid + "'";
						rs = stmt.executeQuery(sql);
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
							anuncio.add(VirtualAPILinkBuilder
									.buildURIAnuncioId(uriInfo, anuncioid, rel));

							try {
								sql = "SELECT * FROM imagen WHERE anuncioid='"
										+ anuncioid + "'";

								ResultSet rs1 = stmt1.executeQuery(sql);

								while (rs1.next()) {
									Imagen imagen = new Imagen();
									imagen.setImagenid(rs1.getInt("imagenid"));
									imagen.setUrlimagen(rs1
											.getString("urlimagen"));
									imagen.setAnuncioid(rs1.getInt("anuncioid"));
									imagen.add(VirtualAPILinkBuilder
											.buildURIImagen(uriInfo,
													rs1.getString("imagenid"),
													anuncioid, rel));
									anuncio.add(imagen);
								}
							} catch (SQLException e) {
								throw new AnuncioNotFoundException();
							}

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

			}

			else {
				throw new NotAllowedException();

			}
		} catch (SQLException e) {
			throw new AnuncioNotFoundException();
		}

		return anuncio;
	}

	@GET
	@Path("/search")
	@Produces(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION)
	public AnuncioCollection getAnunciosBusqueda(
			@QueryParam("offset") String offset,
			@QueryParam("length") String length,
			@QueryParam("subject") String subject,
			@QueryParam("content") String content,
			@QueryParam("email") String email) {

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
		String sql = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {

			stmt = conn.createStatement();
			stmt1 = conn.createStatement();

			if (subject != null && content != null && email != null) {

				sql = "SELECT * FROM anuncio WHERE subject LIKE'%" + subject
						+ "%' AND content LIKE'%" + content
						+ "%' AND email = '" + email + "' LIMIT " + offset
						+ "," + length + "";
			}

			else if (subject != null && content != null && email == null) {

				sql = "SELECT * FROM anuncio WHERE subject LIKE'%" + subject
						+ "%' AND content LIKE'%" + content + "%' LIMIT "
						+ offset + "," + length + "";
			}

			else if (content != null && subject == null && email == null) {

				sql = "SELECT * FROM anuncio WHERE content LIKE'%" + content
						+ "%' LIMIT " + offset + "," + length + "";
			}

			else if (content != null && subject == null && email != null) {

				sql = "SELECT * FROM anuncio WHERE content LIKE'%" + content
						+ "%' AND email='" + email + "' LIMIT " + offset + ","
						+ length + "";
			}

			else if (subject != null && content == null && email == null) {

				sql = "SELECT * FROM anuncio WHERE subject LIKE'%" + subject
						+ "%' LIMIT " + offset + "," + length + "";
			}

			else if (subject != null && content == null && email != null) {

				sql = "SELECT * FROM anuncio WHERE subject LIKE'%" + subject
						+ "%' AND email ='" + email + "'LIMIT " + offset + ","
						+ length + "";
			}

			else if (content == null && subject == null && email != null) {
				sql = "SELECT * FROM anuncio WHERE email ='" + email
						+ "' ORDER BY creation_timestamp LIMIT " + offset + ","
						+ length + "";

			}

			else if (content == null && subject == null && email == null) {
				sql = "SELECT * FROM anuncio ORDER BY creation_timestamp LIMIT "
						+ offset + "," + length + "";

			}

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

				try {
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

			List<Link> links = new ArrayList<Link>();
			links.add(VirtualAPILinkBuilder.buildURIAnunciosBusqueda(
					uriInfo,
					(Integer.toString(Integer.parseInt(offset)
							+ Integer.parseInt(length))), length, subject,
					content, email, rel));
			if (Integer.parseInt(offset) - Integer.parseInt(length) >= 0) {
				links.add(VirtualAPILinkBuilder.buildURIAnunciosBusqueda(
						uriInfo,
						(Integer.toString(Integer.parseInt(offset)
								- Integer.parseInt(length))), length, subject,
						content, email, rel));
			}

			links.add(VirtualAPILinkBuilder.buildURIAnunciosBusqueda(uriInfo,
					offset, length, subject, content, email, rel));

			anuncios.setLinks(links);

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

	@GET
	@Path("/atributos")
	@Produces(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION)
	public AnuncioCollection getAnunciosAtributos(
			@QueryParam("offset") String offset,
			@QueryParam("length") String length,
			@QueryParam("atributo1") String atributo1,
			@QueryParam("atributo2") String atributo2,
			@QueryParam("atributo3") String atributo3,
			@QueryParam("marca") String marca, @Context Request req) {

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
		String sql = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {

			stmt = conn.createStatement();
			stmt1 = conn.createStatement();

			if (atributo1 != null && atributo2 != null && atributo3 != null
					&& marca != null) {

				sql = "SELECT * FROM anuncio WHERE atributo1 ='" + atributo1
						+ "' AND atributo2= '" + atributo2
						+ "' AND atributo3= '" + atributo3 + "' AND marca= '"
						+ marca + "' ORDER BY creation_timestamp LIMIT "
						+ offset + "," + length + "";
			}

			else if (atributo1 != null && atributo2 != null
					&& atributo3 != null && marca == null) {

				sql = "SELECT * FROM anuncio WHERE atributo1 ='" + atributo1
						+ "' AND atributo2= '" + atributo2
						+ "' AND atributo3= '" + atributo3
						+ "' ORDER BY creation_timestamp LIMIT " + offset + ","
						+ length + "";

			} else if (atributo1 != null && atributo2 != null
					&& atributo3 == null && marca == null) {

				sql = "SELECT * FROM anuncio WHERE atributo1 ='" + atributo1
						+ "' AND atributo2= '" + atributo2
						+ "' ORDER BY creation_timestamp LIMIT " + offset + ","
						+ length + "";

			}

			else if (atributo1 != null && atributo2 == null
					&& atributo3 == null && marca == null) {

				sql = "SELECT * FROM anuncio WHERE atributo1 ='" + atributo1
						+ "' ORDER BY creation_timestamp LIMIT " + offset + ","
						+ length + "";

			}

			else if (atributo1 == null && atributo2 == null
					&& atributo3 == null && marca == null) {
				sql = "SELECT * FROM anuncio ORDER BY creation_timestamp LIMIT "
						+ offset + "," + length + "";

			}

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				rs.previous();
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

					anuncio.add(VirtualAPILinkBuilder.buildURIAnuncioId(
							uriInfo, rs.getString("anuncioid"), rel));

					try {

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

				List<Link> links = new ArrayList<Link>();

				links.add(VirtualAPILinkBuilder.buildURIAnunciosOrderby(
						uriInfo,
						(Integer.toString(Integer.parseInt(offset)
								+ Integer.parseInt(length))), length,
						atributo1, atributo2, atributo3, marca, rel));

				if (Integer.parseInt(offset) - Integer.parseInt(length) >= 0) {
					links.add(VirtualAPILinkBuilder.buildURIAnunciosOrderby(
							uriInfo,
							(Integer.toString(Integer.parseInt(offset)
									- Integer.parseInt(length))), length,
							atributo1, atributo2, atributo3, marca, rel));
				}

				links.add(VirtualAPILinkBuilder.buildURIAnunciosOrderby(
						uriInfo, offset, length, atributo1, atributo2,
						atributo3, marca, rel));

				anuncios.setLinks(links);
			} else {
				throw new AnuncioNotFoundException();
			}
		}

		catch (SQLException e) {
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

	@GET
	@Path("/orderby")
	@Produces(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION)
	// precio sera ASC o DESC no es ningún valor numérico es como ordenar
	public AnuncioCollection getAnunciosPrecio(
			@QueryParam("offset") String offset,
			@QueryParam("length") String length,
			@QueryParam("precio") String precio, @Context Request req) {

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
			stmt1 = conn.createStatement();

			sql = "SELECT * FROM anuncio ORDER BY precio " + precio + " LIMIT "
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

				try {
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

				List<Link> links = new ArrayList<Link>();
				links.add(VirtualAPILinkBuilder.buildURIAnunciosPrecio(
						uriInfo,
						(Integer.toString(Integer.parseInt(offset)
								+ Integer.parseInt(length))), length, precio,
						rel));
				if (Integer.parseInt(offset) - Integer.parseInt(length) >= 0) {
					links.add(VirtualAPILinkBuilder.buildURIAnunciosPrecio(
							uriInfo,
							(Integer.toString(Integer.parseInt(offset)
									- Integer.parseInt(length))), length,
							precio, rel));
				}

				links.add(VirtualAPILinkBuilder.buildURIAnunciosPrecio(uriInfo,
						offset, length, precio, rel));

				anuncios.setLinks(links);
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

	@GET
	@Path("/between")
	@Produces(MediaType.VIRTUAL_API_ANUNCIO_COLLECTION)
	public AnuncioCollection getAnunciosEntre(
			@QueryParam("offset") String offset,
			@QueryParam("length") String length,
			@QueryParam("precio1") String precio1,
			@QueryParam("precio2") String precio2, @Context Request req) {

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
			stmt1 = conn.createStatement();

			sql = "SELECT * FROM anuncio WHERE precio > " + precio1
					+ " AND precio < " + precio2 + " LIMIT " + offset + ","
					+ length + "";

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

				try {
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

			List<Link> links = new ArrayList<Link>();

			links.add(VirtualAPILinkBuilder.buildURIAnunciosPrecios(
					uriInfo,
					(Integer.toString(Integer.parseInt(offset)
							+ Integer.parseInt(length))), length, precio1,
					precio2, rel));

			if (Integer.parseInt(offset) - Integer.parseInt(length) >= 0) {
				links.add(VirtualAPILinkBuilder.buildURIAnunciosPrecios(
						uriInfo,
						(Integer.toString(Integer.parseInt(offset)
								- Integer.parseInt(length))), length, precio1,
						precio2, rel));
			}

			links.add(VirtualAPILinkBuilder.buildURIAnunciosPrecios(uriInfo,
					offset, length, precio1, precio2, rel));

			anuncios.setLinks(links);
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
}
