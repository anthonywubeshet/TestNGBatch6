package com.class03;

import org.testng.annotations.*;

public class GroupsDemo {
	
	//alwaysRun attribute will make sure that this method will always execute
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("afterClass");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(groups = "smoke")
	public void test2() {
		System.out.println("test2");
	}
	
	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("test3");
	}
	
	@Test(groups = {"smoke", "regression" })
	public void test4() {
		System.out.println("test4");
	}
}
