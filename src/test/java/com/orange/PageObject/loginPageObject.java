package com.orange.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class loginPageObject  {
	
	WebDriver ldriver;
	
	
	public loginPageObject(WebDriver rdriver){
		this.ldriver=rdriver;
		
		
		
	}

	
	
	
	public void setUsername(String uname) {
		ldriver.findElement(By.id("txtUsername")).sendKeys(uname);
		
	}
	public void setPassword(String password) {
		ldriver.findElement(By.xpath("//*[contains(@id,'txtPassword')]")).sendKeys(password);
		
	}
	public void loginbutton() {
		ldriver.findElement(By.xpath("//*[contains(@name,'Submit')]")).click();
	
	}
	
	
	
}
  