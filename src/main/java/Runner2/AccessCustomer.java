package Runner2;

import java.sql.SQLException;
import java.util.ArrayList;

import daoimpl.CustomerDaoImpl;
import daointerface.ConnectionDAO;
import daointerface.CustomerDAO;
import model.Customer;

public class AccessCustomer {
	public static void main(String[] args) {

	       // creating object
		CustomerDAO customerDao = new CustomerDaoImpl();
	      System.out.println("--------- inserting Customer records ----------");
	    try {
	       Customer c1 = new Customer();
	       c1.setEmail("lavanya.dunga@gmail.com");
	       c1.setFname("lavanya");
	       c1.setLname("dunga");
	      boolean result =  customerDao.addCustomer(c1);
	      
	      System.out.println("added records = "+result);

	       Customer c2 = new Customer();
	       c2.setEmail("vivaan.challa@gmail.com");
	       c2.setFname("vivaan");
	       c2.setLname("challa");
	       result = customerDao.addCustomer(c2);
	       System.out.println("added records = "+result);
	       
	       boolean deleteFlag = customerDao.removeCustomerById(303);
	       System.out.println("delted record = "+deleteFlag);
	       
	       Customer cust = customerDao.getCustomerById(304);
	      System.out.println("Customer : "+ cust); 
	    } 
	       catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	   
	    }

	       
	   }
	


