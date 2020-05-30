package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {
	
	
	@Test
	public void addEmployeePage() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
	    jsClick(dashboard.pim);
	    jsClick(dashboard.addEmpBtn);
	    
		sendText(addEmp.firstName, "bob");
		sendText(addEmp.lastName, "steve");
	    wait(3);
		//click(addEmp.saveBtn);
		
		//Assert.assertTrue(pdetails.pmTitle.isDisplayed());
		
		
		
	}
	
}
