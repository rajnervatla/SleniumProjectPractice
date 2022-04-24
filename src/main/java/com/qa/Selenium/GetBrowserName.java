package com.qa.Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetBrowserName {
	public static void main(String[] args) {
		
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println(js.executeScript("return navigator.appCodeName"));
	}

}
