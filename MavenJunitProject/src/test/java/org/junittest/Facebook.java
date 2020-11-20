package org.junittest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class Facebook 
{
	@Test
	public void test4()
	{
		Assert.assertTrue(true);
		System.out.println("test4");
	}
	
	@Test
	public void test1()
	{
		Assert.assertTrue(false);
		System.out.println("test1");
	}
	
	// ignore Annotation  will ignore the method
	//@Ignore
	@Test
	public void test3()
	{
		Assert.assertTrue(false);
		System.out.println("test3");
	}
	
	@Test
	public void test2()
	{
		Assert.assertTrue(true);
		System.out.println("test2");
	}
}

// Even if we give different order of method names, the methods will execute in alphabetical order.