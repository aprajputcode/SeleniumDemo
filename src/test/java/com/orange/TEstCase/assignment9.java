package com.orange.TEstCase;

import org.testng.annotations.Test;

public class assignment9 extends BaseClass {
	
	@Test(groups= {"include","exclude"},description="using groups method")
	public void first()
	{
		System.out.println("include and exclude");
	}
	@Test(groups= {"parallel testcase","method execution"})
	public void second()
	{
		System.out.println("parallel testcase and method execution");
		
	} @Test(groups= {"method execution","exclude"})
	public void thired()
	{
		System.out.println(" method execution and exclude");
	}
}
