package com.qa.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTestingonFireFox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://demoqa.com/");

		// Print the Title of the Page
		System.out.println("Title of the page is -> " + driver.getTitle());

		// Close the driver
		driver.close();

	}

}
