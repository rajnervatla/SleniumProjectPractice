package com.qa.Selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverWait {
public static void main(String[] args) {
	WebDriver driver = null;

	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(ChromeOptions.CAPABILITY, options);
	options.merge(dc);

	driver = new ChromeDriver(dc);
	// driver=new ChromeDriver();
	driver.manage().window().maximize();
	  driver.get("https://demoqa.com/automation-practice-form");

      // Click on the Button "Timing Alert"

      driver.findElement(By.name("Timing Alert")).click();

      System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");

      // Create new WebDriver wait

      WebDriverWait wait = new WebDriverWait(driver, 10);

      // Wait for Alert to be present

      Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());

      System.out.println("Either Pop Up is displayed or it is Timed Out");

      // Accept the Alert

      myAlert.accept();

      System.out.println("Alert Accepted");

      // Close the main window
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      driver.close();
}
}
