package com.posttrade.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncd.utils.UiOperations;

public class TradeMappingPage {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;
	Actions ac;

	public TradeMappingPage(WebDriver driver) {
		this.driver = driver;
		ac = new Actions(driver);
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	By e_admin = By.linkText("Administration");
	By e_tradeOption = By.linkText("Trade Option");
	By e_mapping = By.linkText("Trade Mapping");
	By e_groupCode = By.id("ctl00_ContentBody_DropDownGroupCode");
	By e_deliveryMode = By.id("ctl00_ContentBody_DDLDeliveryMode");
	By e_search = By.xpath("//img[@title='Search']");
	By e_tradeMap = By.xpath("//a[contains(text(),'Trade Mapping')]");

	public void goToTradeMapping() {
		ac.moveToElement(driver.findElement(e_admin)).perform();
		ac.moveToElement(driver.findElement(e_tradeOption)).perform();
		ac.moveToElement(driver.findElement(e_mapping)).click().perform();
	}

	public void searchTrade() {

		new Select(driver.findElement(e_groupCode)).selectByVisibleText("KMF1");
		new Select(driver.findElement(e_deliveryMode)).selectByVisibleText("DNL");
		ui.click(e_search);

		wt.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='FlexiGrid1']/tbody/tr"), 1));
	}

	public void tradeMapClick() {
		ui.click(e_tradeMap);
		ui.click("//button[text()='Yes']");
		wt.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Trade mapping done successfully']")));
	}

}
