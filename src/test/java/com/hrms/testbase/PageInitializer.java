package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeListPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetalesPage;
import com.hrms.pages.PimPage;

public class PageInitializer extends BaseClass {
	protected static LoginPageElements login;
	protected static DashboardPageElements dash;
	protected static AddEmployeePageElements addEmp;
	protected static PimPage pim;
	protected static PersonalDetalesPage personalPage;
	protected static EmployeeListPage empList;

	public static void initializePageObjects() {

		login = new LoginPageElements();
		dash = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		pim = new PimPage();
		personalPage = new PersonalDetalesPage();
		empList = new EmployeeListPage();
	}

}
