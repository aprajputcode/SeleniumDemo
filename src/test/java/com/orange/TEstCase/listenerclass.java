package com.orange.TEstCase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerclass extends commanclass implements ITestListener {

	 	

	    @Override		
	    public void onStart(ITestContext result) {					
	    	System.out.println("*********Test Suite start. Details are "+result.getName()+"********************");					
	        		
	    }
	    
	    @Override		
	    public void onTestStart(ITestResult result) {					
	    	System.out.println("*********Test Start. Details are "+result.getName()+"********************");			
	        		
	    }	
	    
	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	    	System.out.println("*********Test passed. Details are "+result.getName()+"********************");				
	        
	    		
	    }
		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	    	System.out.println("*********Test Failed. Details are "+result.getName()+"********************");					
	    	try {
				screenshot(result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	    	System.out.println("*********Test Skipped. Details are "+result.getName()+"********************");			
	        		
	    }	
	    

	  	 @Override		
	    public void onFinish(ITestContext result) {					
		  System.out.println("*********Test Suite Finished. Details are "+result.getName()+"********************");	
		  System.out.println();
	        		
	    }	
	    

}
