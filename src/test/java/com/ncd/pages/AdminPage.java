package com.ncd.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import com.ncd.utils.UiOperations;

public class AdminPage {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	By e_autionMarket = By.xpath("//*[@id='sidebar']/div/ul/li[6]/a/span");
	By e_winnerList = By.xpath("//*[@id='sidebar']/div/ul/li[6]//a[text()='Auction Winner List']");

	By e_marketCode = By.xpath("//input[@title='Market Code']");
	By e_contractCode= By.xpath("//input[@title='Contract Code']");

	By e_Approve = By.xpath("//button[text()='Approve ']");

	
	public void clickApprove() throws Exception {
		
		new WebDriverWait(driver, Duration.ofMinutes(12))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"marketData\"]/div[1]//strong[text()=' Traded Price | ']")));

		ui.click(e_autionMarket);
		ui.click(e_winnerList);
		ui.type(e_marketCode, "NCAM");
		ui.click("//li[contains(text(),'NCAM')]");

		ui.type(e_contractCode, "REV92");
		ui.click("//li[contains(text(),'REV92')]");
		ui.click("//button[contains(text(),'Search')]");

		ui.click(By.xpath("//*[text()='market code']"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		scrollBarClick();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(e_Approve));

		wt.until(ExpectedConditions.alertIsPresent()).accept();
	}
	

	//Using Sikuli we did scrolling
	public void scrollBarClick() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(1));

		Screen s = new Screen();
		s.hover("C:\\Users\\Bhajan\\Desktop\\arrow.PNG");

		for (int i = 0; i <= 40; i++) {
			try {
				s.click("C:\\Users\\Bhajan\\Desktop\\arrow.PNG");
				wt.until(ExpectedConditions.visibilityOfElementLocated(e_Approve));
				break;
			} catch (Exception E) {
				System.out.println("Approve not displayed");
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
