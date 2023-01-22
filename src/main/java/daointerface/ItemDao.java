package daointerface;

import java.util.List;

import model.Item;

public interface ItemDao {

	/**  Returns a list of all item objects in the database. **/
	public List<Item>getAllItems();
	
	/** Adds an item with given information. **/
	public boolean addItem(Item i);
	
	/** Removes an item with the given id. **/
	public boolean removeItemById(int id);
}
