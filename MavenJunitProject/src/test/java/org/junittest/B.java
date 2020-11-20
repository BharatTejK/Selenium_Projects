package org.junittest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class B 
{
	@Test
	public void test24()
	{
		Assert.assertTrue("This is Failed test24",true);
		System.out.println("test24");
	}
	
	@Test
	public void test21()
	{
		Assert.assertTrue("This is Failed test21",false);
		System.out.println("test21");
	}
	
	// ignore Annotation  will ignore the method
	//@Ignore
	@Test
	public void test23()
	{
		Assert.assertTrue("This is Failed test23",false);
		System.out.println("test23");
	}
	
	@Test
	public void test22()
	{
		Assert.assertTrue("This is NOT Failed test22",true);
		System.out.println("test22");
	}
}

// Even if we give different order of method names, the methods will execute in alphabetical order.