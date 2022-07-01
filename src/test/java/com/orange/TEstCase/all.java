package com.orange.TEstCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.PageObject.loginPageObject;

public class all extends BaseClass {
	@Test(priority=1,description="hit website by usig driver")
	public void assignent2() throws IOException, InterruptedException
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/"); 
		String screenshtname="driver";
		Thread.sleep(5000);
		commanclass.screenshot(screenshtname);
		Assert.assertTrue(true);
}
	
	
	@Test(priority=2,description="login vailidation")
	public void assignment3() throws InterruptedException, IOException {
		loginPageObject lp=new loginPageObject(driver);
		driver.navigate().to(baseurl);
		String title=driver.getTitle();
		Assert.assertEquals("OrangeHRM",title);
		System.out.println("Title Match now you ready to go");
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.loginbutton();
		Thread.sleep(5000);
		commanclass.checkingUsernameAndPassword();
	}
	
	
	
	@Test(dataProvider="login_data",priority=1,description="hit website by usig chrome")
	public void loginToChrome(String user,String passw) throws  IOException {
		String userd=user;
		String userp=passw;
		loginPageObject lp=new loginPageObject(driver);
		driver.get(baseurl);
		lp.setUsername(userd);
		lp.setPassword(userp);
		lp.loginbutton();
//		Assert.assertTrue(false);
		
		
		
	}
	
	@Test(priority=1,description="login vailidation")
	public void assignment3a() throws InterruptedException, IOException {
		loginPageObject lp=new loginPageObject(driver);
		
		driver.navigate().to(baseurl);
		
		String title=driver.getTitle();
		
		
		
		Assert.assertEquals("OrangeHRM",title);
		System.out.println("Title Match now you ready to go");
		lp.setUsername(username);
		lp.setPassword(password);
		lp.loginbutton();
		Thread.sleep(5000);
		commanclass.checkingUsernameAndPassword();
		commanclass.writeExcel(ExceltPath,sheetnumber,0,1);
		
		
	}
	
	@Test(priority=2,description="login vailidation")
	public void assignment3b() throws InterruptedException, IOException {
		loginPageObject lp=new loginPageObject(driver);
		
		driver.navigate().to(baseurl);
		
		String title=driver.getTitle();
		Assert.assertEquals("OrangeHRM",title);
		System.out.println("Title Match now you ready to go");
		lp.setUsername(username);
		lp.setPassword(password);
		lp.loginbutton();
		Thread.sleep(5000);
		commanclass.writeExcel(ExceltPath,sheetnumber,0,1);
		
		
	}
}
