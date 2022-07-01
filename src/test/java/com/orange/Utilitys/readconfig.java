package com.orange.Utilitys;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
	
	
	
	Properties pro;
	public readconfig() {
		File src= new File("./Configraction\\config.properties");

	try
	{
		FileInputStream fil=new FileInputStream(src);
		pro=new Properties();
		pro.load(fil);
	}
	catch (Exception e)
	{
		System.out.println("Exception is"+e.getMessage());
	}
	}
	
	
	
	
	
	
	
	
	
	public String getAppliationURL()
	{
		String  url=pro.getProperty("baseurl");
		return url;
	}
	
	
	
	
	public String getAppliationUsername()
	{
		String  username=pro.getProperty("username");
		return username;
	}
	
	
	
	public String getAppliationPassword()
	{
		String  password=pro.getProperty("password");
		return password;
	}
	
	
	
	
	
	public String getBrowserURL() {
		
		if(pro.getProperty("browsertype").equalsIgnoreCase("chrome"))
		{
		String chromeurl=pro.getProperty("chromepath");
		return chromeurl;
		}
		else
		{
			String edge=pro.getProperty("edge");
			return edge;
			
		}
	}
	
	
	
	
	public String browserType()
	{
		String browsertype=pro.getProperty("browsertype");
		return browsertype;
	}
	
	
	
	public  int failretrytest()
	{
		String failretrytest=pro.getProperty("failretrytest");
		int retry=Integer.parseInt(failretrytest);
		return retry;
	}
	
	
	
	public String ExcelPath() {
		String Excelpath=pro.getProperty("ExcelPath");
		return Excelpath;
	}
	
	
	
	public int sheetNumber() {
		String sheetnumber=pro.getProperty("sheetnumber");
		int number=Integer.parseInt(sheetnumber);
		return number;
	}

}
