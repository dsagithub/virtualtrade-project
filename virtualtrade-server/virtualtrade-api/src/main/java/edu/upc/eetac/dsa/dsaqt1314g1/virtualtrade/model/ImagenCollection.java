package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;

import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.Link;

public class ImagenCollection {

	private List<Imagen> imagenes = new ArrayList<Imagen>();
	private List<Link> links = new ArrayList<Link>();
	
	

	public void add(Imagen imagen) {
		imagenes.add(imagen);
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
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
