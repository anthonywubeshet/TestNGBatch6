package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLogoAndValidation extends CommonMethods {

	
	@Test
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation passed");
		}else {
			System.out.println("titleValidation failed");
		}
	}
	
	@Test
	public void logoValidation() {
		String logoPath="//div[@id='divLogo']/img";
		WebElement logo=driver.findElement(By.xpath(logoPath));
		boolean isDisplayed=logo.isDisplayed();
		if(isDisplayed) {
			System.out.println("logoValidation passed");
		}else {
			System.out.println("logoValidation failed");
		}
		
	}
	
	@Test
	public void validLogin() {
		WebElement username= driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.id("btnLogin")));
		
		//validate that Welcome Admin is Displayed
		
	}
}
