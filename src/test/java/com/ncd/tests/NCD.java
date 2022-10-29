package com.ncd.tests;

import org.testng.annotations.Test;

import com.ncd.pages.LoginPage;
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
	public void loginTest() {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(prop.getProperty("user"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void autionMarket() throws Exception {
		OrderEntryPage order = new OrderEntryPage(driver);
		order.placeOrder();
	}

}
