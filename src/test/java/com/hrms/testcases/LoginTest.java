package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	@Test(groups = "smoke")
	public void validAdminLogin() {		
		sendText(login.userNameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginButton);
		
		
		Assert.assertTrue(dash.welcomeMsg.isDisplayed());
		

	}
	
	@Test(dataProvider = "getData",groups = "regression")
	public void invalidLogin(String username, String password, String errorMsg) {		
		sendText(login.userNameTextBox, username);
		sendText(login.passwordTextBox, password);
		click(login.loginButton);
		
		Assert.assertEquals(login.spanMsg.getText(), errorMsg);
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = {
				{"","Hum@nhrm123","Username cannot be empty"},
				{"Admin","", "Password cannot be empty"},
				{"Admin", "wertyui12", "Invalid credentials"}
				};
		return data;
		
	}
	
	
	
	
}
