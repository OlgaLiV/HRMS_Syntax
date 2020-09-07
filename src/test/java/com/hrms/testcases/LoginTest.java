package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
	
	@Test(dataProvider = "getUserAddingData")
	public void addEmployee(String firstName, String lastName, String usName, String pass) throws InterruptedException {
		sendText(login.userNameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginButton);
		waitForVisability(dash.welcomeMsg);
		
		click(dash.pimLinkBtn);
		click(pim.addEmpBtn);
		
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.lastName, lastName);
		click(addEmp.createLoginDetailsCheckbox);
		sendText(addEmp.userName, usName);
		sendText(addEmp.userPassword, pass);
		sendText(addEmp.confirmPassword, pass);
		click(addEmp.saveButton);
		waitForVisability(personalPage.profilePictureText);
		Assert.assertEquals(personalPage.profilePictureText.getText(), firstName + " " + lastName);
		
	}
	
	@DataProvider
	public Object[][] getUserAddingData(){
		Object[][] object = {
				{"Nazaret", "Sarkisyan", "NazaretQ8", "G'<r$6%#Nv"},		
    			{"Nerses", "Vartanian", "NersesX6", "fJ?8V\\!p\\#"},
    			{"Hakob", "Davidyan", "HakobB8", "hPF@$S3,7`"},
    			{"Taline", "Kevorkian", "TalineX10", "\";*_8gdB*g"},
    			{"Lucine", "Mooshian", "Lucine223", "&'njM4^gW2"}
	};
		return object;
	}

}
