package rest;

import model.User;



/**
 * Interface to contact Server to put and get Baskets
 *
 */
public interface IUserService {
	/**
	 * Saves a Basket on the Server
	 * @param basket
	 */
	public void createUser(User user);
	/**
	 * Gets all User from the Server
	 * @return
	 */
	public UserList getallUsers();


}
