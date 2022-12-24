package com.ncd.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.ncd.pages.AdminPage;
import com.ncd.pages.LoginPage;
import com.ncd.pages.Logout;
import com.ncd.utils.Base;

public class NcdAdmin extends Base {

	@Test(priority = 6)
	public void loginTestAdmin() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(prop.getProperty("admin_user"), prop.getProperty("admin_password"));
	}

	@Test(dependsOnMethods = "loginTestAdmin", priority = 7)
	public void approveTest() throws Exception {
		AdminPage mw = new AdminPage(driver);
		mw.clickApprove();
	}

	@AfterClass
	public void afterClasss() {
		new Logout(driver).doLogout(); 
	}
}
