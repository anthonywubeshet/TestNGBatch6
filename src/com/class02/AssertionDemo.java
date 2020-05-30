package com.class02;

import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.LoginPageElements;
import com.utils.CommonMethods;

public class AssertionDemo extends CommonMethods {
	//This is also called Hard Assert
	 @BeforeMethod
	  public void openBrowserAndNavigate() {
		  setUp();
	  }

	  @AfterMethod
	  public void closeBrowser() {
		  tearDown();
	  }
	  
	  //AssertionError is handled within TestNG
	  //Even if one Test Case fails, the others will execute
	  @Test
	  public void titleValidation() {
		  String expectedTitle= "Human Management System";
		  String actualTitle= driver.getTitle();
		 //1st way
		  //Assert.assertEquals(actualTitle, expectedTitle);
		  //2nd way, you are giving a msg
		  Assert.assertEquals(actualTitle, expectedTitle,"Titles does not match");
		 //if the assertion fails, this statement will not be executed.
		  System.out.println("Text after assertion");
	  }
	  
	  @Test(priority = 2)
	  public void logoValidation() {
		  LoginPageElements login =new LoginPageElements();
		  boolean logoDisplayed=login.logo.isDisplayed();
		  
		  //1st way
		  //Assert.assertEquals(logoDisplayed, true, "Logo is not displayed");
		  
		  //2nd way
		  Assert.assertTrue(logoDisplayed, "Logo is not displayed");
	  }
}
