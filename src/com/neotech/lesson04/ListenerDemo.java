package com.neotech.lesson04;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.neotech.utils.Listeners.class)

public class ListenerDemo {

	
	@Test
	public void test1() {
		System.out.println("This is test1");
		//making sure this method passes
		Assert.assertTrue(true);	
	}
	
	
	
	@Test
	public void test2() {
		System.out.println("This is test2");
		//making sure this method fails
		Assert.assertTrue(false);
		
	}
	
	
	
	
}
