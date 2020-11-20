package org.junittest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class C 
{
	@Test
	public void test34()
	{
		Assert.assertTrue(true);
		System.out.println("test34");
	}
	
	@Test
	public void test31()
	{
		Assert.assertTrue("This is Failed test31",false);
		System.out.println("test31");
	}
	
	// ignore Annotation  will ignore the method
	@Ignore
	@Test
	public void test33()
	{
		Assert.assertTrue("This method is ignored cos of ignore annotation",false);
		System.out.println("test33");
	}
	
	@Test
	public void test32()
	{
		Assert.assertTrue(true);
		System.out.println("test32");
	}
}

// Even if we give different order of method names, the methods will execute in alphabetical order.