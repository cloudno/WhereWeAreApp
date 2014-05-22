package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Group POJO
 */

public class Group implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1136865455880159424L;

	private int id;
	private String name;
	

	private List<User> users =new ArrayList<User>();
	private String color;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
