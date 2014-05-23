package cluster;

import java.util.Date;

import model.Group;
import model.User;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;


/**
 * User POJO
 */

public class UserItem extends User implements ClusterItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Group group;
	private String name;
	private String password;
	private Double lat;
	private Double lng;
	private String location;
	private Date lastUpdate;
	
	public UserItem(int id, Group group, String name, String password,
			Double lat, Double lng, String location, Date lastUpdate) {
		super();
		this.id = id;
		this.group = group;
		this.name = name;
		this.password = password;
		this.lat = lat;
		this.lng = lng;
		this.location = location;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * 
	 */

	public UserItem(User user)
	{
		this.id = user.getId();
		this.group = user.getGroup();
		this.name= user.getName();
		this.password = user.getPassword();
		this.lat= user.getLat();
		this.lng = user.getLng();
		this.location = user.getLocation();
		this.lastUpdate = user.getLastUpdate();
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LatLng getPosition() {
		LatLng  latn = new LatLng(this.lat, this.lng);
		return latn;
	}

	/*
	@Override
	public LatLng getPosition() {
		
		LatLng  latn = new LatLng(this.lat, this.lng);
		// TODO Auto-generated method stub
		return latn;
	}
	*/

}
