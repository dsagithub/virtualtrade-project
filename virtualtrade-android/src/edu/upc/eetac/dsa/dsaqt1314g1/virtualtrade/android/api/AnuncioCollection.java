package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api;

import java.util.ArrayList;
import java.util.List;


public class AnuncioCollection {

	private List<Anuncio> anuncios = new ArrayList<Anuncio>();
	private List<Link> links = new ArrayList<Link>();
	


	public void add(Anuncio anuncio) {
		anuncios.add(anuncio);
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
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
