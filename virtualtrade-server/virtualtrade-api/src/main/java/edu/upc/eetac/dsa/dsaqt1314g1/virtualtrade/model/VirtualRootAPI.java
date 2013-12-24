package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;


import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.links.*;

public class VirtualRootAPI {
	
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
