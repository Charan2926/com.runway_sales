package testng_Practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmGenericUtility.IPathconstants;

public class DataProvider_FetchData_ExcelTest {
	
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable {
		FileInputStream fi = new FileInputStream(IPathconstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DataProvider");
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
	
	@Test(dataProvider ="getDataFromExcel" )
	public void fetchDataFromExcel(String subject,String topics,String faculty,String daysTaken) {
		System.out.println("Subject----:"+subject+"   Topics-----:"+topics+"  faculty-------:"+faculty+"  Days---:"+daysTaken);
		
	}
}
