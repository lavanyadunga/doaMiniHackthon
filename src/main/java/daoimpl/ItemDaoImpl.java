package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daointerface.ConnectionDAO;
import daointerface.ItemDao;
import model.Item;

public class ItemDaoImpl implements ItemDao {

	public List<Item> getAllItems() {
		List<Item> itemList = null;
		try {
	           Connection connection = ConnectionDAO.getConnection();
	           Statement stmt = connection.createStatement();
	           ResultSet rs = stmt.executeQuery("SELECT * FROM Item");
	           itemList = new ArrayList<Item>();
	           while(rs.next())
	           {
	        	   Item b = new Item();
	               b.setId( rs.getInt("id") );
	               b.setName(rs.getString("name"));
	               b.setPrice( rs.getFloat("price") );
	               itemList.add(b);
	           }
	           

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	           System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	       return itemList;
		// TODO Auto-generated method stub
		
	}

	public boolean addItem(Item i) {
		// TODO Auto-generated method stub
		int affectedRows=0;
		try { 
			Connection con = ConnectionDAO.getConnection();
			
	              String sqlQuery = "INSERT INTO Item (name, price) VALUES (?,?)";
	              PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
	              prepStmt.setString(1,  i.getName());
	              prepStmt.setFloat(2, i.getPrice());
	              
	              affectedRows = prepStmt.executeUpdate();
	              System.out.println(affectedRows + " row(s) affected !!");
			} catch (ClassNotFoundException e)
		       {
		       } catch (SQLException throwables) {
		           throwables.printStackTrace();
		       }
		return affectedRows==0?false:true ;
		
	}

	public boolean removeItemById(int id) {
		boolean result = true;
		try { 
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM Item WHERE id=?");
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
