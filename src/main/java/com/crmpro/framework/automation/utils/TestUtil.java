package com.crmpro.framework.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crmpro.framework.automation.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOADTIME_OUT=20;
	
	public static long IMPLICIT_WAIT=15;
	
	static XSSFWorkbook wb;
	
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getCRMData(String sheetName)
	
	{
		File f= new File(".//ExcelData//TestData.xlsx");
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(f);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object[][] data= new Object[wb.getSheet(sheetName).getLastRowNum()][wb.getSheet(sheetName).getRow(0).getLastCellNum()];
		for(int i=0;i<wb.getSheet(sheetName).getLastRowNum();i++)
		{
			for(int j=0;j<wb.getSheet(sheetName).getRow(0).getLastCellNum();j++)
			{
				data[i][j] = wb.getSheet(sheetName).getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
		
	}}

//	public Object[][] getCRMDealsData(String sheetName)
//	{
//
//		File f= new File(".//ExcelData//TestData.xlsx");
//		FileInputStream fis;
//		
//		try {
//			fis = new FileInputStream(f);
//			wb= new XSSFWorkbook(fis);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	
//	}
//		
//		Object[][] data= new Object[wb.getSheet(sheetName).getLastRowNum()][wb.getSheet(sheetName).getRow(0).getLastCellNum()];
//	
//		for(int i=0;i<wb.getSheet(sheetName).getLastRowNum();i++)
//		{
//			for(int j=0;j<wb.getSheet(sheetName).getRow(0).getLastCellNum();j++)
//			{
//				data[i][j]= wb.getSheet(sheetName).getRow(i+1).getCell(j).toString();
//
//			}
//
//		}return data;
//	}}