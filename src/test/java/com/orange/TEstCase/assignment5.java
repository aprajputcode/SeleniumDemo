package com.orange.TEstCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.PageObject.loginPageObject;

public class assignment5 extends BaseClass{

	@Test(retryAnalyzer = com.orange.TEstCase.retrylistner.class,priority=1,description="login vailidation Use configuration file and listner use in testng .xml"+
	" file and use listner notation and give it file name to use listner fo indivial class,  use retry listner")
	public void assignment() throws InterruptedException, IOException {
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

}
