package com.ncd.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		new WebDriverWait(driver, Duration.ofSeconds(50))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='price']")));
		ui.type("//input[@name='price']", "1000");
		ui.type("//input[@placeholder='Bid Qty']", "200");
		ui.click("//button[text()='Submit']");
		ui.click("//button[text()=' Confirm ']");

	}

	public String checkOrder() {
		String txt = null;
		//ui.click("//a[@data-click='sidebar-minify']/i");
		ui.click(By.linkText("Order Book"));
		txt = driver.findElement(By.xpath("//div[@class='ui-grid-canvas']/div[1]/div/div[9]")).getText();

		return txt;

	}

	public String checkNotification() {
		ui.click("//i[@class='fa fa-bell-o']");
		String style = driver.findElement(By.xpath("//div[@id='messageInfo']/ul[@class='ng-scope']/div[1]/li/span"))
				.getAttribute("style");
		return style;
	}

	public String checkConfirmation() {
		String text = driver.findElement(By.xpath("//div[@id='messageInfo']/ul[@class='ng-scope']/div[1]/li/span"))
				.getText();
		return text;
	}

	public void tradeBookClick() {
		ui.click("//a[@data-click='sidebar-minify']/i");
		driver.findElement(By.xpath("(//a[text()='Trade Book'])[4]")).click();

	}

	public void marginBlockReleaseBookScreenClick() {
		ui.click("//a[@data-click='sidebar-minify']/i");
		driver.findElement(By.xpath("(//a[text()='Margin Block Release Report'])[4]")).click();

	}

}
