package com.automation.gurubank.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseScript {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	
	  public WebDriver init_driver(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS\\Desktop\\Drivers\\chromedriver.exe");						
		if (prop.getProperty("headless").equals("yes")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");		
		driver = new ChromeDriver(options);
		}
		else {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		}
				
		
	  }
		return driver;
	}
	
	public  Properties Properties_Readers() {
		 prop = new Properties();
		 try {
			fis = new FileInputStream("H:\\\\Workspace\\\\Guru_Bank_KeywordDriven\\\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	

}
