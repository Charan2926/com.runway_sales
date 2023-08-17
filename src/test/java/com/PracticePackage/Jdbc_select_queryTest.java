package com.PracticePackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class Jdbc_select_queryTest {

	public static void main(String[] args) throws SQLException {
		
		//Register the  database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Get connection for database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rmg", "root", "root");
		
		//create a statement 
		Statement state =con.createStatement();
		String query="select *from myteam;";
		
		//execute the query
		ResultSet result =state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" : "+result.getString(2)+" : "+result.getString(3)+" : "+result.getString(4));
		}
		
	    //close the database connection
			con.close();
	}

}

