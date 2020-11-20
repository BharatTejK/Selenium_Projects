package org.junittest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class A 
{
	@Test
	public void test14()
	{
		Assert.assertTrue("This is NOT Failed test14",true);
		System.out.println("test14");
	}
	
	@Test
	public void test11()
	{
		Assert.assertTrue("This is Failed test11",false);
		System.out.println("test11");
	}
	
	// ignore Annotation  will ignore the method
	//@Ignore
	@Test
	public void test13()
	{
		Assert.assertTrue("This is Failed test13",false);
		System.out.println("test13");
	}
	
	@Test
	public void test12()
	{
		Assert.assertTrue("This is NOT Failed test12",true);
		System.out.println("test12");
	}
}

// Even if we give different order of method names, the methods will execute in alphabetical order.