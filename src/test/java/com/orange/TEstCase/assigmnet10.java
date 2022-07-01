package com.orange.TEstCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import com.orange.PageObject.loginPageObject;

public class assigmnet10 extends BaseClass {

	
	@Test(priority=2,description="login vailidation write excel file")
	@Parameters({"user","passw"})
	public void assignment3b(String user,String passw) throws InterruptedException, IOException {
		loginPageObject lp=new loginPageObject(driver);
		
		driver.navigate().to(baseurl);
		
		String title=driver.getTitle();
		Assert.assertEquals("OrangeHRM",title);
		System.out.println("Title Match now you ready to go");
		lp.setUsername(user);
		lp.setPassword(passw);
		lp.loginbutton();
		Thread.sleep(5000);
}
	
}
