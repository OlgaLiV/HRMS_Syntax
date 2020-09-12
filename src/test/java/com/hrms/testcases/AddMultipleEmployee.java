package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddMultipleEmployee extends CommonMethods {

	//@Test(groups = "regression")
	public void addMultipleEmp() {

		sendText(login.userNameTextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.loginButton);
		
		jsClick(dash.pimLinkBtn);
		
		List<Map<String, String>> empList = ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH, "Sheet1");
		SoftAssert soft = new SoftAssert();
		for (Map<String, String> map : empList) {
			jsClick(pim.addEmpBtn);
			String firstName = map.get("FirstName");
			String middleName = map.get("MiddleName");
			String lastName = map.get("LastName");
			
			
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleNameField, middleName);
			sendText(addEmp.lastNameField, lastName);
			click(addEmp.saveButton);

			AssertJUnit.assertEquals(personalPage.profilePictureText.getText(), firstName + " " + middleName + " " + lastName);
			

		}
		soft.assertAll();

	}

}
