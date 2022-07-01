package com.orange.TEstCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orange.PageObject.loginPageObject;

public class assignmentc3 {
	WebDriver driver;
	@BeforeClass
	public void loginToDriver() {
		System.setProperty("webdriver.chrome.driver","./Driver\\chromedriver.exe");
		driver=new ChromeDriver();
			}
	@Test(priority=1,description="login vailidation")
	public void assignment3() throws InterruptedException, IOException {
		loginPageObject lp=new loginPageObject(driver);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		String title=driver.getTitle();
		String screenshtname="assignment3";
		commanclass.screenshot(screenshtname);
		Assert.assertEquals("OrangeHRM",title);
		System.out.println("Title Match now you ready to go");
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.loginbutton();
		Thread.sleep(5000);
		commanclass.checkingUsernameAndPassword();
	}
	
	
	@AfterClass
	public void closeDriver() {
		
		driver.quit();
		
	}
}
