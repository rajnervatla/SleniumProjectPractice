package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessHTMLUNitDriverTesting {

	public static void main(String[] args) {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("http://www.google.com");
		System.out.println("Title of page " + driver.getTitle());
		Boolean status = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(status);
	}

}
