package Pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataSupllier {
	
	//@DataProvider(name="loginData")
	public static  Object[][] getData(String Filepath,String SheetName ) throws Exception {
		//File excelFile = new File("C://Users//USER//eclipse-workspace//TestNG//DataSheet//TestData.xlsx");
		String [][] data=null;
		FileInputStream fis = new FileInputStream(Filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(SheetName);
		int noOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(noOfRows);
		
		int noOfColumns = sheet.getRow(0).getLastCellNum();
	System.out.println(noOfColumns);
		data = new String[noOfRows-1][noOfColumns-1];
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j <noOfColumns-1; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j+1));
				
				//System.out.println(data[0][2]);
				
			}
			
		}
		
		workbook.close();
		fis.close();
		
 		for (Object[] dataArr : data) {
 			System.out.println(Arrays.toString(dataArr));
 			
 			
 		}
		return data;
	}

	

	
}

