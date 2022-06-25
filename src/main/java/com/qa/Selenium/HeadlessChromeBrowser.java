package com.qa.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeBrowser {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://demoqa.com/");

		// Print the Title of the Page
		System.out.println("Title of the page is -> " + driver.getTitle());

		// Close the driver
		driver.close();
	}
}
