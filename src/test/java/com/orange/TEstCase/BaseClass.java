package com.orange.TEstCase;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orange.Utilitys.readconfig;

public class BaseClass {
	
	
	
	public static WebDriver driver;
	static readconfig readconfig=new readconfig();
	
	
	public static String baseurl=readconfig.getAppliationURL();
	public static String username=readconfig.getAppliationUsername();
	public static String password=readconfig.getAppliationPassword();
	public static int sheetnumber=readconfig.sheetNumber();
	public static String ExceltPath=readconfig.ExcelPath();
	
	

	
	
	@BeforeClass
	public void loginToDriver() {
		System.setProperty("webdriver."+readconfig.browserType()+".driver",readconfig.getBrowserURL());
		
		driver=commanclass.driverset(readconfig.browserType());
		
		}
	
	
	
	
	@AfterClass
	public void closeDriver() {
		
		driver.quit();
		
	}
	
	

}
