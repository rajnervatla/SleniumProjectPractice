package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitWeDriver {
public static void main(String[] args) {
	WebDriver driver = null;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	String eTitle = "Demo Guru99 Page";
	String aTitle = "" ;
	driver.get("http://demo.guru99.com/test/guru99home/" );
	//Maximizes the browser window
	driver.manage().window().maximize() ;
	//get the actual value of the title
	  aTitle = driver.getTitle();
	//compare the actual title with the expected title
	  WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink;
		guru99seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
		guru99seleniumlink.click();
	if (aTitle.contentEquals(eTitle))
	{
	System.out.println( "Test Passed") ;
	}
	else {
	System.out.println( "Test Failed" );
	}
	
	}
	
}

