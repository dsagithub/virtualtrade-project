package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;

public class VirtualError {
	private int status;
	private String message;
 
	public VirtualError() {
		super();
	}
	public VirtualError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}