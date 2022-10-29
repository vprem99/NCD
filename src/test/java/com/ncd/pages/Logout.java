package com.ncd.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ncd.utils.UiOperations;

public class Logout {
	WebDriver driver;
	UiOperations ui;
	WebDriverWait wt;

	public Logout(WebDriver driver) {
		this.driver = driver;
		ui = new UiOperations(driver);
		wt = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	By e_user = By.xpath("(//span[@class='ng-binding'])[1]");
	By e_logout = By.xpath("//a[text()=' Log Out ']");

	public void doLogout() {
		ui.click(e_user);
		ui.click(e_logout);
	}
}
