package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;

import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.Link;

public class Imagen {

	private int imagenid;
	private int anuncioid;
	private String urlimagen;
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

	public int getImagenid() {
		return imagenid;
	}

	public void setImagenid(int imagenid) {
		this.imagenid = imagenid;
	}

	public int getAnuncioid() {
		return anuncioid;
	}

	public void setAnuncioid(int anuncioid) {
		this.anuncioid = anuncioid;
	}

	public String getUrlimagen() {
		return urlimagen;
	}

	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}

}
