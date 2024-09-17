package com.ebanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		
		File src = new File ("./Configuration/config.properties");
		
		try {
			//to read data open file to read mode
			FileInputStream fis= new FileInputStream(src);
			//Initial the properties
			pro = new Properties();
			pro.load(fis);
			
			
			
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	
	public String getApplicationURL() {
		String url =pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getUsername() {
		String username =pro.getProperty("userName");
		return username;
		
	}
	
	public String getPassword() {
		String pwd =pro.getProperty("password");
		return pwd;
		
	}
	
	public String getChrome() {
		String chrome =pro.getProperty("chrompath");
		return chrome;
		
	}
	
	public String getMse() {
		String mse =pro.getProperty("msepath");
		return mse;
		
	}
	public String getFirefox() {
		String ff =pro.getProperty("firefoxpath");
		return ff;
		
	}
	
	

}
