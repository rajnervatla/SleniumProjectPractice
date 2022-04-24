package com.qa.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosugesstionsInselenium {

	public static void main(String[] args) throws InterruptedException {
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*	*//**
				 * /*** Approach 1 by using actions class
				 ***//*
						 * driver.get("http://www.leafground.com/pages/autoComplete.html"); WebElement
						 * textbox = driver.findElement(By.id("tags")); Thread.sleep(5000);
						 * 
						 * textbox.sendKeys("a"); Actions action = new Actions(driver);
						 * action.sendKeys(textbox,
						 * Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
						 * 
						 * System.out.println("Wow Performed Auto suggestion automation ...");
						 * 
						 * /
						 */

		driver.get("https://www.google.com/");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("amazon");
		List<WebElement> stringAuto = driver.findElements(By.xpath("//*[@class='pcTkSc']"));
		System.out.println(stringAuto.size());
		

		for (WebElement suggestions : stringAuto) {
			System.out.println(suggestions.getText());

			Thread.sleep(5000);
			if (suggestions.getText().contains("Amazon")) {
				
				
				Thread.sleep(5000);
				suggestions.click();
				System.out.println("Successully clicked on Auto suggestions ...");
			}
		}
		driver.quit();
	}

}
