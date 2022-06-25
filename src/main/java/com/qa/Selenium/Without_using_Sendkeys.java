package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Without_using_Sendkeys {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebElement txtbox=driver.findElement(By.name("q"));
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		JavascriptExecutor JS=JavascriptExecutor(driver);
		//JS.executeScript("document.getElementByname('q').value='Software Tester'"
		JS.executeScript("arguments[0].value='RAJ'",txtbox);
		Thread.sleep(1000);
		
	}

	private static JavascriptExecutor JavascriptExecutor(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
