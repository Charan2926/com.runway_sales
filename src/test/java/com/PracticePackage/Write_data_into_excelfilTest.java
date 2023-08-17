package com.PracticePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write_data_into_excelfilTest {

	public static void main(String[] args) throws Throwable {
    
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("Sheet2");
		sh.createRow(0).createCell(0).setCellValue("ramcharan");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		fos.flush();
		
		wb.close();

	}

}
