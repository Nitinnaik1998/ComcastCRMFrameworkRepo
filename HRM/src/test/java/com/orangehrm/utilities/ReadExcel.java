package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel 
{
	@DataProvider(name="UserData")
	public String[][] ReadExcelData() throws IOException
	{
		//FileInputStream fis =new FileInputStream("/Users/nakusha/eclipse-workspace/HRM/src/test/resources/ExcelData/EmpDetails.xlsx");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ExcelData/EmpDetails.xlsx");

		XSSFWorkbook book   =new XSSFWorkbook(fis);
		XSSFSheet sheet     = book.getSheet("Sheet1");
		int lastRow         =sheet.getLastRowNum();
		String[][]data=new String[lastRow][sheet.getRow(0).getLastCellNum()];
		for(int r=1;r<=lastRow;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++)
			{
				XSSFCell cel=row.getCell(c);
				String value=cel.getStringCellValue();
				data[r-1][c]=value;
				
			}
		}
		fis.close();
		book.close();
		return data;
		
		
	}
}


//EmployeeCreationData.xlsx