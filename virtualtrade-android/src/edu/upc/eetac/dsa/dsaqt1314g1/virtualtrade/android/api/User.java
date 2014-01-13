package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String email;
	private String name;
	private int phone;
	private String foto;
	private String ciudad;
	private String calle;
	private int numero;
	private int piso;
	private int puerta;
	private boolean banned;

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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	private List<Link> links = new ArrayList<Link>();

	public void add(Link link) {
		links.add(link);
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
