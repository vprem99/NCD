package com.ncd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public WebDriver driver;
	public WebDriverWait wt;
	public Properties prop;
	@BeforeTest // pre-condition i.e Browser starting
	public void beforeTest() throws  Exception {
		 prop=new Properties();
		prop.load(new FileInputStream("src/test/resources/config.properties"));
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Will wait whenever required
		wt = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterTest // post-condtion i.e browser closing at the End
	public void afterTest() throws Exception {
		Thread.sleep(7000);
		driver.quit();
	}

}
