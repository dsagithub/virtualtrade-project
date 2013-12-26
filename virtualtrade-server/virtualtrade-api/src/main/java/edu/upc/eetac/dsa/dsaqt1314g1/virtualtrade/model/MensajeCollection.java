package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;

import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.Link;

public class MensajeCollection {
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();
	private List<Link> links = new ArrayList<Link>();

	public void add(Mensaje mensaje) {
		mensajes.add(mensaje);
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

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
