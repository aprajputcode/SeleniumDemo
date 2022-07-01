package com.orange.TEstCase;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class assignment2{
	WebDriver driver;
	@BeforeClass
	public void loginToDriver() {
		System.setProperty("webdriver.chrome.driver","./Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		}
	
	@Test(priority=1,description="hit website by usig driver and tack scree shot")
	public void assignent2() throws IOException, InterruptedException 
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/"); 
		String screenshtname="assignment2";
		Thread.sleep(5000);
		commanclass.screenshot(screenshtname);
		Assert.assertTrue(true);
}
	
	
	@AfterClass
	public void closeDriver() {
		
		driver.quit();
		
	}
	
	
	
}
