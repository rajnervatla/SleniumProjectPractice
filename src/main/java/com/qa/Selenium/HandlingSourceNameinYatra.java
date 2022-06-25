package com.qa.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSourceNameinYatra {
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
		driver.get("https://www.yatra.com/");
		WebElement departName = driver.findElement(By.xpath("//*[@id='BE_flight_origin_city']"));
		Thread.sleep(2000);
		departName.sendKeys("New Delhi");
		System.out.println("Entered the text...");
		Thread.sleep(2000);
		List<WebElement> auto_suggestion = driver.findElements(By.xpath("//p[@class='ac_cityname']"));;
		for (WebElement wEle : auto_suggestion) {
			System.out.println(wEle.getText());

			if (wEle.getText().contains("DEL"))

			{
				wEle.click();
				System.out.println("Successfully clicked Delhi");
				
				System.out.println(" HI this is the value of the string   :"+departName.getAttribute("value"));
				

			}

		}

		 driver.quit();
	}

}
