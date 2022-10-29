package com.ncd.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncd.utils.TimeCalculator;
import com.ncd.utils.UiOperations;

public class OrderEntryPage {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;

	public OrderEntryPage(WebDriver driver) {
		this.driver = driver;
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	By e_autionMarket = By.xpath("//*[@id='sidebar']/div/ul/li[5]/a/span");
	By e_autionOrderEntry = By.xpath("//a[text()='Auction Order Entry']");
	By e_side = By.xpath("//input[@title='Side']");

	By e_Market = By.xpath("//input[@title='Market Code']");
	By e_comm = By.xpath("//*[@title='Commodity Code']");

	public void placeOrder() {
		ui = new UiOperations(driver);
		ui.click(e_autionMarket);
		ui.click(e_autionOrderEntry);
		ui.type(e_side, "BUY");
		ui.click("//*[text()='BUY']");
		ui.type(e_Market, "NCAM");
		ui.click("//li[contains(text(),'NCAM')]");
		ui.type(e_comm, "PULSES");
		ui.click("//li[contains(text(),'PULSES')]");
		ui.type("//input[@title=' Contract Code']", "REV92");
		ui.click("//ul[@id='typeahead-dropdown']/li[contains(text(),'REV92')]");

		ui.click("//input[@title='Auction Type']");
		ui.type("//input[@title='Auction Type']", "_3");
		ui.click("//ul[@id='typeahead-dropdown']/li[contains(text(),'_3')]");
		ui.type("//input[@name='auctionShortCode']", "XYZ");

		ui.type("//input[@name='moq']", "500");
		ui.type("//input[@name='price']", "1000");
		ui.type("//input[@placeholder='Minimum Match Qty']", "100");
		ui.type("//input[@placeholder='Quantity']", "20");
		ui.click("(//i[@class='fa fa-calendar'])[1]");
		ui.click("//button[text()='Today']");
		ui.click("(//i[@class='fa fa-calendar'])[2]");

		ui.click("//button[text()='Today']");
		ui.type("//textarea[@id='remarksArea']", "XYZ");
		ui.click("(//i[@class='fa fa-calendar'])[3]");
		ui.click("//button[text()='Today']");
		ui.type("//input[@placeholder='PRICE PATTERN']", "PRP");
		ui.click("//ul[@id='typeahead-dropdown']/li[text()='PRP']");

		ui.type("//input[@placeholder='Manufacturing Plants']", "COIMBATORE");
		ui.click("//ul[@id='typeahead-dropdown']/li[text()='COIMBATORE']");

		ui.click("(//i[@class='fa fa-calendar'])[4]");
		ui.click("//button[text()='Today']");
		ui.type("//input[@placeholder='GRADE']", "A");
		ui.click("//ul[@id='typeahead-dropdown']/li[text()='A']");
		ui.type("//*[@name='BUYER NAME']", "PREM");
		ui.type("//*[@name='ACTUAL GRADE']", "PREM");

		ui.click("//button[@value='Submit']");

		ui.type("(//input[@name='hour'])[3]", TimeCalculator.getTime(7)[0]);
		ui.type("(//input[@name='minute'])[3]", TimeCalculator.getTime(7)[1]);
		if (Integer.parseInt(TimeCalculator.getTime(7)[0]) < 12) {
			ui.click("(//input[@name='mode'])[3]");
			ui.type("(//input[@name='mode'])[3]", "A");
		}

		ui.type("(//input[@name='hour'])[4]", TimeCalculator.getTime(10)[0]);
		ui.type("(//input[@name='minute'])[4]", TimeCalculator.getTime(10)[1]);
		if (Integer.parseInt(TimeCalculator.getTime(7)[0]) < 12) {
			ui.click("(//input[@name='mode'])[4]");
			ui.type("(//input[@name='mode'])[4]", "A");
		}
		ui.type("(//input[@name='hour'])[5]", TimeCalculator.getTime(10)[0]);
		ui.type("(//input[@name='minute'])[5]", TimeCalculator.getTime(10)[1]);
		if (Integer.parseInt(TimeCalculator.getTime(7)[0]) < 12) {
			ui.click("(//input[@name='mode'])[5]");
			ui.type("(//input[@name='mode'])[5]", "A");
		}
		ui.type("(//input[@name='hour'])[6]", TimeCalculator.getTime(12)[0]);
		ui.type("(//input[@name='minute'])[6]", TimeCalculator.getTime(12)[1]);
		if (Integer.parseInt(TimeCalculator.getTime(7)[0]) < 12) {
			ui.click("(//input[@name='mode'])[6]");
			ui.type("(//input[@name='mode'])[6]", "A");
		}
		ui.type("(//input[@name='hour'])[7]", TimeCalculator.getTime(12)[0]);
		ui.type("(//input[@name='minute'])[7]", TimeCalculator.getTime(12)[1]);
		if (Integer.parseInt(TimeCalculator.getTime(7)[0]) < 12) {
			ui.click("(//input[@name='mode'])[7]");
			ui.type("(//input[@name='mode'])[7]", "A");
		}
		ui.type("(//input[@name='hour'])[8]", TimeCalculator.getTime(14)[0]);
		ui.type("(//input[@name='minute'])[8]", TimeCalculator.getTime(14)[1]);
		if (Integer.parseInt(TimeCalculator.getTime(7)[0]) < 12) {
			ui.click("(//input[@name='mode'])[8]");

			ui.type("(//input[@name='mode'])[8]", "A");
		}
		ui.click("//button[text()='Confirm ']");
		ui.click("//button[text()='confirm']");
	}

}
