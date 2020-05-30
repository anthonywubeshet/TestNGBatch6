package com.class02;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class SoftAssertionDemo extends CommonMethods {
	
	 @BeforeMethod
	  public void openBrowserAndNavigate() {
		  setUp();
	  }

	  @AfterMethod
	  public void closeBrowser() {
		  tearDown();
	  }
	  
	  @Test
	  public void logoAndWelcomeValidation() {
		  LoginPageElements login=new LoginPageElements();
		  boolean logo=login.logo.isDisplayed();
		  logo=false;
		 // Assert.assertTrue(logo);
		  //if i do a hard Assert, the code will not continue executing
		  SoftAssert soft= new SoftAssert();
		  soft.assertTrue(logo, "Logo is not displayed");
		  
		  System.out.println("After first assertion");
		  
		  sendText(login.username, ConfigsReader.getProperty("username"));
		  sendText(login.password, ConfigsReader.getProperty("password"));
		  click(login.loginBtn);
		  
		  DashBoardPageElements dash= new DashBoardPageElements();
			 boolean msgDisplayed= dash.welcome.isDisplayed();
			 // Assert.assertEquals("Welcome Admin", dash.welcome.getText());
			 soft.assertTrue(msgDisplayed, "Welcome msg not displayed");
			 
			 //this will collect all soft assertions and then decide if TC passed or failed
			 soft.assertAll();
			 
			 //Execution stops after assertAll
			 //this statement will not be excuted
			 System.out.println("After AssertAll");
	  }
	  

}
