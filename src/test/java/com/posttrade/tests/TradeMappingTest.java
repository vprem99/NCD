package com.posttrade.tests;

import org.testng.annotations.Test;

import com.ncd.utils.Base;
import com.posttrade.pages.LoginPage;
import com.posttrade.pages.TradeMappingPage;

public class TradeMappingTest extends Base {

	@Test(priority = 1)
	public void loginTestSeller() {
		driver.get(prop.getProperty("posttrade_url"));
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(prop.getProperty("posttrade_user"), prop.getProperty("posttrade_password"));
	}
	
	@Test(priority = 2)
	public void tradeMappingTest() {
		TradeMappingPage tmp = new TradeMappingPage(driver);
		tmp.goToTradeMapping();
	}
	@Test(priority = 3)
	public void tradeSearchTest() {
		TradeMappingPage tmp = new TradeMappingPage(driver);
		tmp.searchTrade();
		tmp.tradeMapClick();
	}
	
}
