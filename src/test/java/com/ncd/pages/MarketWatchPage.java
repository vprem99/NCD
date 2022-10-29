package com.ncd.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncd.utils.UiOperations;

public class MarketWatchPage {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;

	public MarketWatchPage(WebDriver driver) {
		this.driver = driver;
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	By e_autionMarket = By.xpath("//*[@id='sidebar']/div/ul/li[5]/a/span");
	By e_marketWatch = By.xpath("//*[@id='sidebar']/div/ul/li[5]//a[text()='Market Watch']");

	public void doBookmark() {
		ui.click(e_autionMarket);
		ui.click(e_marketWatch);
		ui.click("(//button[@ng-model='data.bookmark'])[1]");
		ui.click("//strong[text()='Actions']");
		ui.click("//strong[text()='Auction Floor']");
		ui.type("//input[@name='price']", "1000");
		ui.type("//input[@placeholder='Bid Qty']", "200");
		ui.click("//button[text()='Submit']");
		ui.click("//button[text()=' Confirm ']");

	}

}
