package com.class02;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.Constants;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.PriorityBlockingQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class NewTest extends CommonMethods {
  
  @BeforeMethod
  public void openBrowserAndNavigate() {
	  setUp();
  }

  @AfterMethod
  public void closeBrowser() {
	  tearDown();
  }
  
  //depending on multiple methods
  // @Test(priority = 2, dependsOnMethods = {"invalidLogin","method1, method2"})
  @Test(priority = 2, dependsOnMethods = "invalidLogin")
  public void validLogin() {
	 // WebElement username=driver.findElement(By.id("txtUsername"));
	  
	  //1st way
	 // username.sendKeys(ConfigsReader.getProperty("username"));
	  
	  //2nd way
	 // sendText(username, ConfigsReader.getProperty("username"));
	  
	  //3rd way, using Page Object Model and PageFactory
	  LoginPageElements login= new LoginPageElements();
	  sendText(login.username, ConfigsReader.getProperty("username"));
	  sendText(login.password, ConfigsReader.getProperty("password"));
	  
	  //1st way
	 // WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	 // wait.until(ExpectedConditions.elementToBeClickable(login.loginBtn));
	  //login.loginBtn.click();
	  
	  //2nd way
	 // waitForClickability(login.loginBtn);
	 // login.loginBtn.click();
	  
	  //3rd way
	  click(login.loginBtn);
	  
	  DashBoardPageElements dashboard= new DashBoardPageElements();
	  
	  boolean displayed= dashboard.logo.isDisplayed();
	  if(displayed) {
		  System.out.println("logo is displayed");
	  }else {
		  System.out.println("logo NOT displayed");
	  }
	  wait(1);
	}

  //@Test means Test Case= Scenario = One Test Method
  //Case 1: if this test method is commented, it will not run 
  //Depending method will throw an exception 
  //Case 2: if this test method is disabled
  //Case 3: if this test method fails, it will run but fail
  //case 4: if this test method passes 
  @Test(priority = 3, enabled= true)
  public void invalidLogin() throws Exception {
	  LoginPageElements login= new LoginPageElements();
	  sendText(login.username, ConfigsReader.getProperty("username"));
	  click(login.loginBtn);
	  
	  String expectedText= "Password cannot by empty";
	  String actualText= login.errorMsg.getText();
	  boolean errorDisplayed= login.errorMsg.isDisplayed();
	  if(errorDisplayed) {
		  System.out.println("Error is displayed");
		  if(expectedText.equals(actualText)) {
			  System.out.println("Error msg is correct");
		  }else {
			  System.out.println("Error msg is not correct");
		  }
		  
	  }else {
		  System.out.println("Error msg is not displayed");
	  }
	  wait(1);
	  
	  //When an Exception is thrown, the test Fails
	  throw new Exception();
  }
}
