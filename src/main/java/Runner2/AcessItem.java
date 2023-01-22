package Runner2;

import java.util.List;

import daoimpl.CustomerDaoImpl;
import daoimpl.ItemDaoImpl;
import daointerface.CustomerDAO;
import daointerface.ItemDao;
import model.Customer;
import model.Item;

public class AcessItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemDao itemDao = new ItemDaoImpl();
	      System.out.println("--------- inserting Item records ----------");
	    
	       Item i1 = new Item();
	       i1.setName("fire trucks");
	       i1.setPrice(24.445f);
	      boolean result = itemDao .addItem(i1);
	      
	      System.out.println("added records = "+result);

	      Item i2 = new Item();
	      i2.setName("race cars");
	       i2.setPrice(35.445f);
	      boolean result2 = itemDao .addItem(i2);
	       System.out.println("added records = "+result2);
	       
	      boolean deleteFlag = itemDao.removeItemById(5);
	       System.out.println("deleted record = "+deleteFlag);
	       
	       List<Item> it = itemDao.getAllItems();
	      System.out.println("Item : "+ it);
	    
	}

}
