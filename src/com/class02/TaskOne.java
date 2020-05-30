package com.class02;

import org.testng.annotations.Test;

public class TaskOne {

	@Test(priority = 4)
	public void firstMethod() {
		System.out.println("firstMethod");
	}
	
	@Test(enabled = false)
	public void firstMethod1() {
		System.out.println("firstMethod1");
	}
	
	@Test(priority = 3)
	public void secondMethod() {
		System.out.println("secondMethod");
	}
	
	@Test(priority = 2)
	public void thirdMethod() {
		System.out.println("thirdMethod");
	}
	
	@Test(priority = 1)
	public void fourthMethod() {
		System.out.println("fourthMethod");
	}
}
