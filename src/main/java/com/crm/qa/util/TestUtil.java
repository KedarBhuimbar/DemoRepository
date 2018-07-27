package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=30;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
	public TestUtil(String excelPath)
	{
		try
		{
			File file=new File(excelPath);
			FileInputStream fis=new FileInputStream(file);
			 wb=new XSSFWorkbook(fis);
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();	
		}
		catch(IOException e)
		{
		e.printStackTrace();	
		}
	}
	public TestUtil()
	{
		
	}
	public int GetRowCount(String sheet)
	{
		int number=wb.getSheet(sheet).getLastRowNum();
		number=number+1;
		return number;
	}
	public String GetData(String sheet,int rownum,int cellnum)
	{
		sheet1=wb.getSheet(sheet);
		String data=sheet1.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
}
