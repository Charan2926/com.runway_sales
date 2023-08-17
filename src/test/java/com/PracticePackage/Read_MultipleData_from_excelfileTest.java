package com.PracticePackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_MultipleData_from_excelfileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		
		int lastrow=sh.getLastRowNum();
		int lastcel=sh.getRow(lastrow).getLastCellNum();
		System.out.println("------------------------");
		   
		   for(int i=0;i<=lastrow;i++) {
				int lastcell = sh.getRow(i).getLastCellNum(); 
				for(int j = 0;j<lastcell;j++) {
					String value = sh.getRow(i).getCell(j).getStringCellValue();
					System.out.print(value+" ");
					
				}
				System.out.println();
			}
		//get the last row and last cell num 
		System.out.println(lastrow);
		System.out.println(lastcel);
		//get particular data in the excel 
		   Row ro=sh.getRow(3);
		   Cell cel=ro.getCell(0);
		   String part =cel.getStringCellValue();
		   System.out.println(part);
		   
		   
				
			
		
		}
	
		
	}


