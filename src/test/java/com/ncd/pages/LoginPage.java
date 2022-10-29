package com.ncd.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncd.utils.UiOperations;

public class LoginPage {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	By e_user=By.xpath("//*[@name='userId-entry']");	
	By e_pwd=By.xpath("//*[@name='password-entry']");
	By e_login=By.cssSelector("button[value='Login']");

	
	
	
	public void doLogin(String user, String pwd) {
		ui.type("", user);
		ui.type("", pwd);

		wt.until(ExpectedConditions.elementToBeClickable(e_login)).click();
		try {
			wt.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception E) {
			System.out.println("Alert Not Present");
		}
	}
}
