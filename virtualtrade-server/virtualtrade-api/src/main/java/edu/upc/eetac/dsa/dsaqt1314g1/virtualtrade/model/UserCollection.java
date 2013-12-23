package edu.upc.eetac.dsa.dsaqt1314g1.virtualtrade.model;
import java.util.ArrayList;
import java.util.List;

public class UserCollection {
	private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
