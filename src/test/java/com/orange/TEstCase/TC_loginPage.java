package com.orange.TEstCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orange.PageObject.loginPageObject;




public class TC_loginPage extends BaseClass{
	
//,retryAnalyzer = com.orange.TEstCase.retrylistner.class
	@Test(dataProvider="login_data",priority=1,description="hit website by usig chrome")
	public void loginToChrome(String user,String passw) throws  IOException {
		String userd=user;
		String userp=passw;
		loginPageObject lp=new loginPageObject(driver);
		driver.get(baseurl);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.loginbutton();
		//Assert.assertTrue(false);
		
		
		
	}
	@DataProvider(name="login_data")
	public static Object[][] AccessData() throws IOException{
		return commanclass.readExcelSheetd(ExceltPath,sheetnumber);
		//return commanclass.readExcelSheetWithContainFind(ExceltPath,sheetnumber);
	}
	
	
	
}

