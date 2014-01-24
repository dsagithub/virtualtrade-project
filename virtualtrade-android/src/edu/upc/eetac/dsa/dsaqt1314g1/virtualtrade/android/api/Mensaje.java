package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.android.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mensaje {

	private String mensajeid;
	private String emailorigen;
	private String emaildestino;
	private Date creation_timestamp;
	private String anuncioid;
	private String subject;
	private String content;

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

	public String getAnuncioid() {
		return anuncioid;
	}

	public String getContent() {
		return content;
	}

	public Date getCreation_timestamp() {
		return creation_timestamp;
	}

	public String getEmaildestino() {
		return emaildestino;
	}

	public String getEmailorigen() {
		return emailorigen;
	}

	public String getMensajeid() {
		return mensajeid;
	}

	public String getSubject() {
		return subject;
	}

	public void setAnuncioid(String anuncioid) {
		this.anuncioid = anuncioid;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreation_timestamp(Date creation_timestamp) {
		this.creation_timestamp = creation_timestamp;
	}

	public void setEmaildestino(String emaildestino) {
		this.emaildestino = emaildestino;
	}

	public void setEmailorigen(String emailorigen) {
		this.emailorigen = emailorigen;
	}

	public void setMensajeid(String mensajeid) {
		this.mensajeid = mensajeid;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
