package com.ncd.tests;

import org.testng.annotations.Test;

import com.ncd.pages.LoginPage;
import com.ncd.pages.Logout;
import com.ncd.pages.MarketWatchPage;
import com.ncd.pages.OrderEntryPage;
import com.ncd.utils.Base;
import com.ncd.utils.TimeCalculator;
import com.ncd.utils.UiOperations;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NCD extends Base {

	@Test(priority = 1)
	public void loginTitleTest() {
		driver.get(prop.getProperty("url"));
		Assert.assertEquals(driver.getTitle().contains("NeML | User Login"), true);
	}

	@Test(priority = 2)
	public void loginTestBuyer() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(prop.getProperty("buyer_user"), prop.getProperty("buyer_password"));
	}

	@Test(priority = 3)
	public void autionMarket() throws Exception {
		OrderEntryPage order = new OrderEntryPage(driver);
		order.placeOrder();
		// new Logout(driver).doLogout();
	}

	@Test(priority = 4)
	public void checkStatusBuyer() throws Exception {
		OrderEntryPage order = new OrderEntryPage(driver);
		String status = order.checkOrder();
		Assert.assertEquals(status, "OPEN-OPEN");
	}

	@Test(priority = 5)
	public void checkNotificationBuyer() throws Exception {
		OrderEntryPage order = new OrderEntryPage(driver);
		String color = order.checkNotification();
		Assert.assertEquals(color, "color: green;");
		new Logout(driver).doLogout();
	}

	@Test(priority = 6)
	public void loginTestSeller() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(prop.getProperty("seller_user"), prop.getProperty("seller_password"));
	}

	@Test(priority = 7)
	public void doBookmark() {
		MarketWatchPage mw = new MarketWatchPage(driver);
		mw.doBookmark();
	}

	@Test(priority = 8)
	public void checkNotificationSeller() {
		MarketWatchPage mw = new MarketWatchPage(driver);
		String color = mw.checkNotification();
		Assert.assertEquals(color, "color: green;");
		String text = mw.checkConfirmation();
		Assert.assertTrue(text.contains("NEW BID CONFIRMATION"));
	}

	@Test(priority = 9)
	public void checkStatusSeller() {
		MarketWatchPage mw = new MarketWatchPage(driver);
		String status = mw.checkOrder();
		Assert.assertEquals(status, "OPEN-OPEN");
	}

	@Test(priority = 10)
	public void checkTradeBook() {
		MarketWatchPage mw = new MarketWatchPage(driver);
		mw.tradeBookClick();
		Assert.assertTrue(driver.getCurrentUrl().contains("tradeBook"));
	}

	@Test(priority = 11)
	public void checkMarginBlock() {
		MarketWatchPage mw = new MarketWatchPage(driver);
		mw.marginBlockReleaseBookScreenClick();
		Assert.assertTrue(driver.getCurrentUrl().contains("marginBlockReleaseReport"));
		new Logout(driver).doLogout();
	}

}
