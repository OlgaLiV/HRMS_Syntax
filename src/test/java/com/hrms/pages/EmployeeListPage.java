package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPage extends BaseClass{
	
	@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td")
	public List<WebElement> table;
	
	@FindBy(linkText = "Next")
	public WebElement nextBtn;
	
	public EmployeeListPage() {
		PageFactory.initElements(driver, this);
	}

}
