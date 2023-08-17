package com.crmGenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * This method is used to read data from excel 
	 * @author Nani
	 * @param SheetName
	 * @param Rowno
	 * @param Cellno
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName,int Rowno,int Cellno) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(SheetName).getRow(Rowno).getCell(Cellno).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to write data into excel
	 * @author Nani
	 * @param SheetName
	 * @param data
	 * @throws Throwable
	 */
	public void writedatatoexcel(String SheetName,String data) throws Throwable {
		//Create excel sheet
		FileInputStream fi = new FileInputStream(IPathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh =wb.createSheet(SheetName);
		//write data into excelsheet 
		sh.createRow(0).createCell(0).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IPathconstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}

	/**
	 * This method is used to get lastrow of excel
	 * @author Nani
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getlastrowno(String SheetName) throws Throwable {
		
		FileInputStream fi = new FileInputStream(IPathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh =wb.createSheet(SheetName);
		int count =sh.getLastRowNum();
		return count;
	}
	
	/**
	 * This method is used to fetch mutliple Data from excel 
	 * @author Nani
	 * @param SheetName
	 * @param keycell
	 * @param valuecell
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> getMutlipledatafromexcel(String SheetName,int keycell,int valuecell) throws Throwable {
		
		//fetching data from excel
		FileInputStream fi = new FileInputStream(IPathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh =wb.createSheet(SheetName);
		int count =sh.getLastRowNum();
		
		//creating an empty Hashmap 
		HashMap <String,String> map = new HashMap <String,String>();
		
		//storing each excel values into hashmap
		for(int i= 0;i<=count;i++) {
			String key = sh.getRow(i).getCell(keycell).getStringCellValue();
			String value= sh.getRow(i).getCell(valuecell).getStringCellValue();
			map.put(key, value);
		}
		return map;
 	}
	
	public Object[][] DPMultipleDataFromExcel(String SheetName) throws Throwable {
		
		//Fetching multipledata from excel through data providers
		FileInputStream fi = new FileInputStream(IPathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int lastrow = sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow+1][lastcell];
		for (int i = 0; i<=lastrow; i++) {
			for (int j = 0; j<lastcell; j++) {
				
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;	
	}
	
	

}