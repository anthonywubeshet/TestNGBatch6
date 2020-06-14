package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	//@BeforeMethod
	//public void openBrowser() {
	//	setUp();
	//	initialize();
	//}
	
	//@AfterMethod
	//public void closeBroswer() {
	//	tearDown();
	//}
	
	@Test
	public void validAdminLogin() {
		//LoginPageElements login =new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		wait(2);
		
		//DashBoardPageElements dash=new DashBoardPageElements();
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT logged in");
		//Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	
	@Test
	public void invalidPasswordLogin() {
		//LoginPageElements login =new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "adsada");
		click(login.loginBtn);
		String expected="Invalid credentials";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
	@Test(enabled = false)
	public void emptyUsernameLogin() {
		//LoginPageElements login =new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		String expected="Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected);
	}
}
