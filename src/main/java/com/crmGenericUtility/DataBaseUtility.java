package com.crmGenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
    Driver driverRef;
	Connection con;
	
	/**
	 * This method is used to connect to the database
	 * @throws Throwable
	 */
	public void connectToDb() throws Throwable  {
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con =DriverManager.getConnection(IPathconstants.dbURL ,IPathconstants.dbUsername, IPathconstants.dbPassword);			
	}	
	
	
	/**
	 * This Method is used to dis-connect from the Database
	 * @throws SQLException
	 */
	public void disConnectFromDb() throws SQLException {
		con.close();
	}
	
	/**
	 * This method is used to validate the data that is created in the database
	 * @param query
	 * @param index
	 * @param expdata
	 * @return
	 * @throws SQLException
	 */
	public String readDataFromDbVAlidate(String query,int index ,String expdata) throws SQLException {
		
		ResultSet result = con.createStatement().executeQuery(query);
		
		Boolean flag = false;
		while(result.next()) 
		{
			if(result.getString(index).equalsIgnoreCase(expdata)) 
			{
				flag=true;
				break;
			}
		}
		if(flag) 
		{
			System.out.println("Data is verified");
			return expdata;
		}
		else 
		{
			System.out.println("Data is not present");	
		}
		return "";
	}
	
	/**
	 * This method is used to fetch the data from database
	 * @param query
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public ResultSet fetchDataFromDataBase(String query) throws Throwable {
		ResultSet result =con.createStatement().executeQuery(query);
		return result;	
   }
}
