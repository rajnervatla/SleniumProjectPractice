package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeighLightTheWebElement {

	public static void main(String[] args) {
		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(dc);

		driver = new ChromeDriver(dc);
		// driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		WebElement openwindow_btn = driver.findElement(By.xpath("//*[@id='openwindow']"));
		HeighLightTheWebElement.highlightElement(driver, openwindow_btn);

	}

	public static void highlightElement(WebDriver driver, WebElement element) {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	      try 
	      {
	         Thread.sleep(1000);
	      } 
	      catch (InterruptedException e) 
	      { 
	         System.out.println(e.getMessage());
	      }
	      js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	   }
	}
