package com.orange.TEstCase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.orange.Utilitys.readconfig;

public class retrylistner implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int counter=0;
		readconfig ft=new readconfig();
		int retryLimit=ft.failretrytest();
		if(counter >= retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
