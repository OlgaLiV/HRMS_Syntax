package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeWithDataProvider extends CommonMethods{
	
	//@Test(dataProvider = "getUserAddingData", groups = "regression")
	public void addEmployee(String firstName, String lastName, String usName, String pass) throws InterruptedException {
		sendText(login.userNameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginButton);
		waitForVisability(dash.welcomeMsg);
		
		click(dash.pimLinkBtn);
		click(pim.addEmpBtn);
		
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.lastNameField, lastName);
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
				{"Nazaret", "Sarkisyan", "Nazareterr4z11", "G'<r$6%#Nv"},		
    			{"Nerses", "Vartanian", "Nersesw1ghde2", "fJ?8V\\!p\\#"},
    			{"Hakob", "Davidyan", "Hakobx1trffu3", "hPF@$S3&7*"},
    			{"Taline", "Kevorkian", "Talined1dss674", "@#;*_8gdB*g"},
    			{"Lucine", "Mooshian", "LucineE25Rtff415", "&'njM4^gW2"}
	};
		return object;
	}
	


}
