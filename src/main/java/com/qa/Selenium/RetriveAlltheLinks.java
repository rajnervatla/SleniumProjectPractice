package com.qa.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetriveAlltheLinks {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Thread.sleep(3000);
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println(li.size());
		for (int i = 1; i < li.size(); i++) {
			String t1 = li.get(i).getText();
			String t2 = li.get(i).getAttribute("href");
			System.out.println(t1 + " --- >> " + t2);
		}
		driver.close();
	}

}
