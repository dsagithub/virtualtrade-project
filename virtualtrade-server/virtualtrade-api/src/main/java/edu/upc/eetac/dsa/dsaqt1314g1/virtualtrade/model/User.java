package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;

public class User {
	
	private String email;
	private String name;
	private String photo;
	private String provincia;
	private String ciudad;
	private String calle;
	private int numero;
	private int piso;
	private int puerta;
	private boolean banned;
	private String userpass;
	private java.util.Date lastModified;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getPuerta() {
		return puerta;
	}
	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public java.util.Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(java.util.Date lastModified) {
		this.lastModified = lastModified;
	}
	
	
}
