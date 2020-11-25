package com.automation.gurubank.Supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertiesReaders {
	String filepath;
	private static FileInputStream fis;
	private static Properties properties;
	private static String value;
	
	
	public PropertiesReaders(String filepath) throws IOException {
		
		this.filepath = filepath;
		try {
			 fis = new FileInputStream("H:\\Workspace\\Guru_Bank_KeywordDriven\\config.properties");
			properties = new Properties();
			Optional<Properties> optional = Optional.ofNullable(properties);
			if (optional.isPresent()) {
				properties.load(fis);				
				
			}
			else {
				System.out.println("Properties Are Pointing to null");
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	
		
	}
	
	public String getValueForKey(String key) {
		value = properties.getProperty(key);
		return value;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
