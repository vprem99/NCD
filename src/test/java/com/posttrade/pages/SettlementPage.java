package com.posttrade.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncd.utils.UiOperations;

public class SettlementPage {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;
	Actions ac;

	public SettlementPage(WebDriver driver) {
		this.driver = driver;
		ac = new Actions(driver);
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	By e_settlement = By.xpath("//span[text()='Settlement']");
	By e_settlement2 = By.xpath("(//span[text()='Settlement'])[2]");

	By e_normalSettlement = By.linkText("Normal Settlement");
	By obligation_No = By.xpath("//table[@id='FlexiGrid1']//tr[1]/td[9]");

	By e_search = By.xpath("//div[@title='Search']");
	By e_quickSearch = By.name("qtype");
	By e_searchField = By.name("q");
	By e_go = By.xpath("//input[@value='Go']");
	String obligationNo;
	public void goToSettlement() {
		ac.moveToElement(driver.findElement(e_settlement)).perform();
		ac.moveToElement(driver.findElement(e_settlement2)).perform();
		ac.moveToElement(driver.findElement(e_normalSettlement)).click().perform();
	}

	public void getObligationNo() {
		obligationNo=driver.findElement(obligation_No).getText();
	}

	public void searchByObligation() {
		ui.click(e_search);
		new Select(driver.findElement(e_quickSearch)).selectByValue("INTENTION_NO");
		ui.type(e_searchField,obligationNo);
		ui.click(e_go);
		wt.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='FlexiGrid1']/tbody/tr"), 1));

	}

}
