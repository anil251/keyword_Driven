package com.automation.gurubank.KeywordEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.gurubank.BaseClass.BaseScript;

public class KeywordEngine  {

	public WebDriver driver;
	public Properties prop;
	public  Workbook workbook;
	public  Sheet sheet;
	public BaseScript base;
	
	
	public final String sheet_path ="H:\\Workspace\\Guru_Bank_KeywordDriven\\"
			+ "src\\main\\java\\com\\automation\\gurubank\\DataFiles\\KeyWord_Driven.xlsx";
	
	
	public void startExecution(String sheetName) {
		String locatorvalue = null;
		String locatorName= null;
		
		
		FileInputStream fis =null;
		try {
			fis = new FileInputStream(sheet_path);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			workbook= WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		sheet = workbook.getSheet(sheetName);
		int k=0;
		for (int i = 0; i<=sheet.getLastRowNum(); i++) {
			try {
			String locatorcolumvalue = sheet.getRow(i+1).getCell(k+1).toString().trim();//id=username
			if (!locatorcolumvalue.equalsIgnoreCase("NA")) {
				
				locatorName=locatorcolumvalue.split("=")[0].trim();//id
				locatorvalue = locatorcolumvalue.split("=")[1].trim();//username
			}
			String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
			String value =sheet.getRow(i+1).getCell(k+3).toString().trim();
			
			switch (action) {
			case "open browser":
				base= new BaseScript();
				prop= base.Properties_Readers();
				if (value.isEmpty() || value.equals("NA")) {
					driver =base.init_driver(prop.getProperty("browser"));
				}
				else {
					driver =base.init_driver(value);
				}
				break;
			case "enter url":
			if (value.isEmpty() || value.equals("NA")) {
				driver.get(prop.getProperty("guru_url"));
				}
			else {
				driver.get(value);
			}
			break;
			case "quit": 
				  driver.quit();
				 break;			 
			default:
				break;
			}
			//try {
			switch (locatorName) {
			case "name":
				WebElement element = driver.findElement(By.name(locatorvalue));
				if (action.equalsIgnoreCase("sendkeys")) {
					element.clear();
					element.sendKeys(value);					
				}
					else if (action.equalsIgnoreCase("click")) {
						element.click();				
					
				}
				locatorName=null;
				break;
			
			default:
				break;
			}
			
			/*}
			
			catch (Exception e) {
				
			}*/
			
			
		
		}
		
			catch (Exception e) {
				
			}
		}	
	}
}
