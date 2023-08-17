package com.PracticePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class Read_Data_from_propertiesfileTest {

	public static void main(String[] args) throws Throwable {
		
		//create object for fileinputstream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//create object for properties class
		Properties pobj = new Properties();
		
		//load the data from property file
		pobj.load(fis);
		
		//fectching the data using key 
		String url= pobj.getProperty("url");
		String browser= pobj.getProperty("browser");
		String un= pobj.getProperty("username");
		String pwd= pobj.getProperty("password");
		
		System.out.println(url+"\n"+browser+"\n"+un+"\n"+pwd);
	}

}
