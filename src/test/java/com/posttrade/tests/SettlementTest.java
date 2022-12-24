package com.posttrade.tests;

import org.testng.annotations.Test;

import com.ncd.utils.Base;
import com.posttrade.pages.LoginPage;
import com.posttrade.pages.SettlementPage;
import com.posttrade.pages.TradeMappingPage;

public class SettlementTest extends Base {

	@Test(priority = 1)
	public void loginTestSeller() {
		driver.get(prop.getProperty("posttrade_url"));
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(prop.getProperty("posttrade_user"), prop.getProperty("posttrade_password"));
	}
	
	@Test(priority = 2)
	public void tradeMappingTest() {
		SettlementPage sp = new SettlementPage(driver);
		sp.goToSettlement();
		sp.getObligationNo();
		sp.searchByObligation();
	}

	
}
