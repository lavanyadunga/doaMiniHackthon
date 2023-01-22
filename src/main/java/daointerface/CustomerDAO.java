package daointerface;

import model.Customer;

public interface CustomerDAO {
	/**- Returns the customer object for the given id
	 * @throws ClassNotFoundException **/
	public Customer getCustomerById(int id) throws ClassNotFoundException ;
	/**  Adds a customer with given information. 
	 * @throws ClassNotFoundException **/
	public boolean addCustomer(Customer c) throws ClassNotFoundException;
	
	/**  Removes a customer with the given id. 
	 * @throws ClassNotFoundException **/
	public boolean removeCustomerById(int id) throws ClassNotFoundException;

}
