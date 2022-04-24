package com.qa.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Without_using_Sendkeys {

	
	public static void main(String[] args) {
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	public static void setAttribute(WebElement element,String attributeName,String value)
	{
		WrapsDriver wrap=(WrapsDriver)element;
		
		JavascriptExecutor js=(JavascriptExecutor)wrap.getWrappedDriver();
		//driver.execute
	}
}
