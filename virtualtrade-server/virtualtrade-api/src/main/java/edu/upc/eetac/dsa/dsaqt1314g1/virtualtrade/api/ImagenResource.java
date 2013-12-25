package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.VirtualAPILinkBuilder;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.Imagen;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.ImagenCollection;
import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model.VirtualRootAPI;

@Path("/anuncios/{anuncioid}/imagenes")
public class ImagenResource {

	@Context
	private UriInfo uriInfo;

	VirtualRootAPI root = new VirtualRootAPI();
	String rel = null;

	private DataSource ds = DataSourceSPA.getInstance().getDataSource();

	@GET
	@Produces(MediaType.VIRTUAL_API_IMAGEN_COLLECTION)
	public ImagenCollection getImagenes(@PathParam("anuncioid") String anuncioid) {
		ImagenCollection imagenes = new ImagenCollection();

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
			sql = "SELECT * FROM imagen WHERE anuncioid='" + anuncioid + "' ";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next() == false) {
				throw new ImagenNotFoundException();
			}

			else {

				while (rs.next()) {
					Imagen imagen = new Imagen();
					imagen.setImagenid(rs.getInt("imagenid"));
					imagen.setUrlimagen(rs.getString("urlimagen"));
					imagen.setAnuncioid(rs.getInt("anuncioid"));
					imagen.add(VirtualAPILinkBuilder.buildURIImagen(uriInfo,
							rs.getString("imagenid"), anuncioid, rel));
					imagenes.add(imagen);
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

		return imagenes;

	}

	@GET
	@Path("/{imagenid}")
	@Produces(MediaType.VIRTUAL_API_IMAGEN)
	public Imagen getImagen(@PathParam("anuncioid") String anuncioid,
			@PathParam("imagenid") String imagenid) {

		Imagen imagen = new Imagen();

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
			sql = "SELECT * FROM imagen WHERE anuncioid='" + anuncioid + "' ";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next() == false) {
				throw new AnuncioNotFoundException();
			}

			else {
				sql = "SELECT * FROM imagen WHERE anuncioid='" + anuncioid
						+ "' and imagenid='" + imagenid + "' ";

				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					imagen.setImagenid(rs.getInt("imagenid"));
					imagen.setUrlimagen(rs.getString("urlimagen"));
					imagen.setAnuncioid(rs.getInt("anuncioid"));
					imagen.add(VirtualAPILinkBuilder.buildURIImagen(uriInfo,
							rs.getString("imagenid"), anuncioid, rel));

				}

				else {
					throw new ImagenNotFoundException();
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

		return imagen;

	}

	@DELETE
	@Path("/{imagenid}")
	public String deleteImagen(@PathParam("imagenid") String imagenid) {

		Connection conn = null;
		Statement stmt = null;
		String sql;
		ResultSet rs;
		String estado = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServiceUnavailableException(e.getMessage());
		}

		try {
			stmt = conn.createStatement();
			sql = "SELECT * FROM imagen WHERE imagenid='" + imagenid + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next() == false) {
				throw new ImagenNotFoundException();

			} else {

				try {
					stmt = conn.createStatement();
					sql = "DELETE FROM imagen WHERE imagenid='" + imagenid
							+ "'";
					stmt.executeUpdate(sql);

					estado = "Imagen borrada correctamente";
				} catch (SQLException e) {
					throw new InternalServerException(e.getMessage());
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		} catch (SQLException e) {
			throw new InternalServerException(e.getMessage());

		}
		return estado;
	}

	@POST
	@Consumes(MediaType.VIRTUAL_API_IMAGEN)
	@Produces(MediaType.VIRTUAL_API_IMAGEN)
	public Imagen createImagen(@PathParam("anuncioid") String anuncioid,
			Imagen imagen) {
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
			if (rs.first() == false) {
				throw new AnuncioNotFoundException();
			}

			else {

				try {
					stmt = conn.createStatement();
					String update = null;
					update = "INSERT INTO imagen (anuncioid,urlimagen) VALUES ('"
							+ anuncioid + "','" + imagen.getUrlimagen() + "')";
					stmt.executeUpdate(update, Statement.RETURN_GENERATED_KEYS);
					rs = stmt.getGeneratedKeys();

					if (rs.next()) {

						int imagenid = rs.getInt(1);
						rs.close();

						sql = "SELECT * FROM imagen WHERE imagenid='"
								+ imagenid + "'";
						rs = stmt.executeQuery(sql);
						if (rs.next()) {
							imagen.setImagenid(rs.getInt("imagenid"));
							imagen.setUrlimagen(rs.getString("urlimagen"));
							imagen.setAnuncioid(rs.getInt("anuncioid"));
							imagen.add(VirtualAPILinkBuilder.buildURIImagen(
									uriInfo, rs.getString("imagenid"),
									anuncioid, rel));

						}
					} else
						throw new ImagenNotFoundException();
				} catch (SQLException e) {
					throw new InternalServerException(e.getMessage());
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}

		catch (SQLException e) {
			throw new InternalServerException(e.getMessage());
		}

		return imagen;
	}

	@PUT
	@Path("/{imagenid}")
	@Consumes(MediaType.VIRTUAL_API_IMAGEN)
	@Produces(MediaType.VIRTUAL_API_IMAGEN)
	public Imagen updateImagen(@PathParam("imagenid") String imagenid,
			Imagen imagen) {

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
			sql = "SELECT * FROM imagen WHERE imagenid='" + imagenid + "'";
			rs = stmt.executeQuery(sql);
			rs.next();

			try {
				stmt = conn.createStatement();
				String update = null;
				update = "UPDATE imagen SET imagen.urlimagen ='"
						+ imagen.getUrlimagen() + "'";
				int rows = stmt.executeUpdate(update,
						Statement.RETURN_GENERATED_KEYS);
				if (rows != 0) {

					sql = "SELECT * FROM imagen WHERE imagenid='" + imagenid
							+ "' ";
					rs = stmt.executeQuery(sql);
					if (rs.next()) {

						imagen.setImagenid(rs.getInt("imagenid"));
						imagen.setUrlimagen(rs.getString("urlimagen"));
						imagen.setAnuncioid(rs.getInt("anuncioid"));
						imagen.add(VirtualAPILinkBuilder.buildURIImagen(
								uriInfo, rs.getString("imagenid"),
								rs.getString("anuncioid"), rel));

					}
				}

				else
					throw new ImagenNotFoundException();
			} catch (SQLException e) {
				throw new InternalServerException(e.getMessage());
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			throw new ImagenNotFoundException();
		}

		return imagen;

	}

}
