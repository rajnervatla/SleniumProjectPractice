package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiveElement {
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

		driver.get("http://www.google.com");
		driver.switchTo().activeElement().sendKeys("softwaretestingblog");
		driver.findElement(By.name("btnK")).click();
		System.out.println("Congrates ......");
		Thread.sleep(3000);
		driver.close();

	}

}
