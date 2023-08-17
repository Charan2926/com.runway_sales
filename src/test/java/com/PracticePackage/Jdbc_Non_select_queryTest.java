package com.PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc_Non_select_queryTest {
	
	public static void main(String[]args) throws SQLException {
		int result =0;
		Connection con =null;
		try 
		{
			//Register the  database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Get connection for database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmg", "root", "root");
			
			//Create the statements
			Statement state = con.createStatement();
			String query = "insert into myteam values('#004','Veeresh','TE','RunWay_Sales','');";
			
			//update the query
		      result = state.executeUpdate(query);
		}
		catch(Exception e) 
		{
			
		}
		
	     finally {
	    	 if(result>0) {
		    	 System.out.println("Data is created sucessfully");
		     }
		     else {
		    	 System.err.println("Data creation is failed");
		     }
	 
			//close the database connection
		     con.close();
		     
	     }
	     
	}

}
