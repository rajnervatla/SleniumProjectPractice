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
		 driver.get("https://accounts.google.com/");
		    driver.manage().window().maximize();
		    Thread.sleep(1000);
		    //Next button element
		    WebElement nextBtn = driver.findElement(By.id("identifierNext"));
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    //code to enter value in the email textbox
		    js.executeScript("document.getElementById('identifierId').value='testemail'");
		    //code to click on next button
		    js.executeScript("arguments[0].click();", nextBtn);
}
}