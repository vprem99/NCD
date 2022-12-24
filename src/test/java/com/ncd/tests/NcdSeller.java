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

import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NcdSeller extends Base {

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
		System.out.println(text + "Notification Bid");
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
		try {
			wt.until(ExpectedConditions.urlContains("tradeBook"));
		} catch (Exception E) {
			Assert.fail("Trade Book Failed");
		}
		// Assert.assertTrue(driver.getCurrentUrl().contains("tradeBook"));
	}

	@Test(priority = 11)
	public void checkMarginBlock() {
		MarketWatchPage mw = new MarketWatchPage(driver);
		mw.marginBlockReleaseBookScreenClick();
		try {
			wt.until(ExpectedConditions.urlContains("marginBlockReleaseReport"));
		} catch (Exception E) {
			Assert.fail("Trade Book Failed");
		} finally {
			new Logout(driver).doLogout();
		}
		// Assert.assertTrue(driver.getCurrentUrl().contains(""));
	}

}
