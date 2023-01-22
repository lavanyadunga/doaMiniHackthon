package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daointerface.ConnectionDAO;
import daointerface.CustomerDAO;
import model.Customer;

public class CustomerDaoImpl implements CustomerDAO {
	
	public Customer getCustomerById(int id)  {
		Customer cust = null;
		try { 
		Connection con = ConnectionDAO.getConnection();
		String sqlQuery = "select * from customer where id = ?";
		PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
        prepStmt.setInt(1, id);
        ResultSet affectedRows = prepStmt.executeQuery();
        
       if(affectedRows.next()) {
    	   cust = new Customer();
    	   cust.setId(affectedRows.getInt("id"));
    	   cust.setFname(affectedRows.getString("fname"));
    	   cust.setLname(affectedRows.getString("lname"));
    	   cust.setEmail(affectedRows.getString("email"));
       }
		} catch (ClassNotFoundException e)
	       {
	       } catch (SQLException throwables) {
	           throwables.printStackTrace();
	       }
		return cust;
	}

	public boolean addCustomer(Customer c) {
		int affectedRows=0;
		try { 
			Connection con = ConnectionDAO.getConnection();
			
	              String sqlQuery = "INSERT INTO Customer (email,fname,lname) VALUES (?,?,?)";
	              PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
	              prepStmt.setString(1, c.getEmail());
	              prepStmt.setString(2, c.getFname());
	              prepStmt.setString(3, c.getLname());
	              affectedRows = prepStmt.executeUpdate();
	              System.out.println(affectedRows + " row(s) affected !!");
			} catch (ClassNotFoundException e)
		       {
		       } catch (SQLException throwables) {
		           throwables.printStackTrace();
		       }
		return affectedRows==0?false:true ;
	}

	public boolean removeCustomerById(int id) {
		boolean result = false;
		try { 
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE id=?");
	           ps.setInt(1, id);
	            result = ps.execute();
	           
			} catch (ClassNotFoundException e)
		       {
		       } catch (SQLException throwables) {
		           throwables.printStackTrace();
		       }
		return result;
	}

}
