package com.crmGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String ReadDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis =new FileInputStream(IPathconstants.FilePath);
		Properties Pobj= new Properties();
		Pobj.load(fis);
		String url=Pobj.getProperty(key);
		return url;
	}
}
