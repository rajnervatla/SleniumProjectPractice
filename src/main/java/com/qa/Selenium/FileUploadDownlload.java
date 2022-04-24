package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadDownlload {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(5000);

		WebElement choosebrowser = driver.findElement(By.xpath("//*[@type='file']"));
		// choosebrowser.click();
		choosebrowser.sendKeys("C:\\Users\\rnervatl\\Desktop\\Test Executions\\B2C\\QA3 Actual Testing");
		System.out.println("Wow successfull...");
	}
}
