package com.qa.Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseTheSecondWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("http://www.google.com");

		driver.get("https://www.amazon.in/");
		driver.get("http://demoqa.com/frames-and-windows/");
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();

		driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		int count = 0;
		for (String h : handles) {
			count++;
			System.out.println(count);
			if (count == 1) {
				driver.switchTo().window(h);
				driver.close();
			} else {
				continue;
			}
		}
		// driver.switchTo().window(parent);
		// driver.close();

	}

}
