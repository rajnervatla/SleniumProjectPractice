package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadomExample {
	public static void main(String[] args) {
		WebDriver driver = null;

		System.out.println("Hello World!");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://shop.polymer-project.org/");
		WebElement root=driver.findElement(By.tagName("shop-app"));// root node or shadow host
		WebElement shadowdom1=getshadowdom(root, driver);
	}

	static WebElement getshadowdom(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowdom1 = (WebElement) js.executeScript("return.arguments[0].shadowRoot", element);

		return shadowdom1;

	}
}