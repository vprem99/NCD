package com.posttrade.pages;

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
	By e_user=By.xpath("//*[@id='InputCMID']");	
	By e_pwd=By.xpath("//*[@id='InputPwd']");
	By e_login=By.cssSelector("input[value='Login']");

	
	
	
	public void doLogin(String user, String pwd) {
		ui.type(e_user, user);
		ui.type(e_pwd, pwd);

		wt.until(ExpectedConditions.elementToBeClickable(e_login)).click();
		try {
			wt.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception E) {
			System.out.println("Alert Not Present");
		}
	}
}
