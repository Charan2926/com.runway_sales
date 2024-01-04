package com.crmGenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con =null;
	
	/**
	 * This method is used to connect to the Database
	 * @author Nani
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathconstants.dbURL,IPathconstants.dbUsername,IPathconstants.dbPassword);
		
	}
	/**
	 * This method is used to Execute and fetch the data from Databse
	 * @author Nani
	 * @param query
	 * @param columnNo
	 * @param ExpData
	 * @return
	 * @throws SQLException
	 */
	public String ExecuteQueryAndGetData(String query,int columnNo,String ExpData) throws SQLException {
		
		ResultSet result =con.createStatement().executeQuery(query);
		
		boolean flag=false;
		while(result.next()) 
		{
			String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(ExpData)) 
			{
				flag=true;
				break;
			}
		}
		if(flag==true) 
		{
			System.out.println("---Data is vadlidated successfully");
			return ExpData;
		}
		else
		{
			System.out.println("---Data is vadlidation failed");
			return "";
		}
	}
	
	/**
	 * This method is used to close the Database Connection
	 * @author Nani
	 * @throws SQLException
	 */
	public void CloseDb() throws SQLException {
		con.close();
	}
}
