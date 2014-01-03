package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.auth;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	DataSource ds = null;

	@Override
	public void init() throws ServletException {
		super.init();
		ds = DataSourceSPA.getInstance().getDataSource();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Declaro e inicio las variables
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String userpass = request.getParameter("userpass");
		
		
		String phone = request.getParameter("phone");
		String ciudad = request.getParameter("ciudad");
		String calle = request.getParameter("calle");
		String numero = request.getParameter("numero");
		String piso = request.getParameter("piso");
		String puerta = request.getParameter("puerta");
		String foto = request.getParameter("foto");

		

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {

			stmt = conn.createStatement();
			String update = null;
			update = "INSERT INTO users (name,email,userpass) VALUES ('"
					
					+ name
					+ "','"
					+ email
					+ "' , MD5('"
					+ userpass + "'))";
			int rows = stmt.executeUpdate(update,
					Statement.RETURN_GENERATED_KEYS);

			update = "INSERT INTO user_roles (email,rolename) VALUES ('"
					+ email + "','registered')";
			rows = stmt.executeUpdate(update, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(targetHost.getHostName(),
		targetHost.getPort()), new UsernamePasswordCredentials("admin","admin"));

		// Create AuthCache instance
		AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		// Add AuthCache to the execution context
		HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);

		HttpPost httpPost = new HttpPost(
				"http://localhost:8080/virtualtrade-api/users");
		httpPost.addHeader("Content-Type",
				"application/vnd.virtual.api.user+json");
		httpPost.addHeader("Accept", "application/vnd.virtual.api.user+json");
	
		
		String user =  "{\"email\": \"" + email + "\", \"name\": \""
				+ name + "\", \"phone\": \"" + phone + "\", \"ciudad\": \""
				+ ciudad + "\", \"calle\": \""
				+ calle + "\", \"numero\": \""
				+ numero + "\", \"piso\": \""
				+ piso + "\", \"puerta\": \""
				+ puerta + "\", \"foto\": \""
				+ foto + "\"	}";
		
		
		
		
		/*
		
		String user = "{\"username\": \"" + username + "\", \"name\": \""
				+ name + "\", \"email\": \"" + email + "\"	}";
		
		*/
		
		
		httpPost.setEntity(new StringEntity(user));
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

		CloseableHttpResponse httpResponse = closeableHttpClient.execute(
				targetHost, httpPost, context);
		HttpEntity entity = httpResponse.getEntity();
		httpResponse.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				entity.getContent()));
		String line = null;
		while ((line = reader.readLine()) != null)
			System.out.println(line);
			
		
		
		
	} 
}
