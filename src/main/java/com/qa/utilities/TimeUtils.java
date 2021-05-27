package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.Base;

public class TimeUtils extends Base{
	
	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICIT_WAIT = 40;
	public static String expectedTitle_LANDING_PAGE = "#1 Free CRM customer relationship management software cloud";
	public  static String expectedTitile_PAGE="Cogmento CRM";
	public static String name = "Rahul Singh";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream("D:\\Selenium\\FrameworkPractice\\"
					+ "POMHybridFramework\\testData\\testData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i < sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	public static void takeScreenshotAtEndOfTest() {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}

}
