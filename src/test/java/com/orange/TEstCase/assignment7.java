package com.orange.TEstCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.PageObject.loginPageObject;

public class assignment7 extends BaseClass{
	@Test(priority=2,description="login vailidation write excel file")
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
