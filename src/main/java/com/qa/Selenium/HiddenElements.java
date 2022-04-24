package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenElements {

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
		
		driver.get("https://courses.letskodeit.com/practice");
		WebElement hidden=driver.findElement(By.xpath("//*[@id='hide-textbox']"));
		hidden.click();
		
		
		JavascriptExecutor jse= JavascriptExecutor(driver);
		jse.executeScript("document.getElementById('displayed-text').value='Rajkumar ';");
		
		/*
		 * WebElement txtbox=driver.findElement(By.xpath("//*[@id='displayed-text']"));
		 * txtbox.sendKeys("Verifying the hidden text box");
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * driver.get("http://www.google.com"); List<WebElement> li =
		 * driver.findElements(By.id("male")); System.out.println(li.size()); for
		 * (WebElement el : li) { Integer x = el.getLocation().getX();
		 * System.out.println("The Location Of x is : -" + x); // Integer
		 * y=river.findElement(By.id("male")) .getLocation().getY(); if (x == 0) {
		 * System.out.println("Element Is Not Visible Or Hidden"); } else el.click(); }
		 * Thread.sleep(5000); driver.close();
		 */
	}

	private static JavascriptExecutor JavascriptExecutor(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
