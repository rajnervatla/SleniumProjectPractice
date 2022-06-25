package com.qa.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {
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

		driver.get("http://demo.guru99.com/test/");

		// Find the date time picker control
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));

		// Fill date as mm/dd/yyyy as 09/25/2013

		dateBox.sendKeys("0922013");

		// Press tab to shift focus to time field

		dateBox.sendKeys(Keys.TAB);

		// Fill time as 02:45 PM

		dateBox.sendKeys("02:45PM");
		submit.click();

		WebElement text = driver.findElement(By.xpath("//div[@style='font-size:15px;margin-left:50px;']"));
		
		System.out.println(text.getText());
		String expected="Your Birth Date is 2013-02-09\r\n"
				+ "Your Birth Time is 02:45";
		Thread.sleep(100);
		if (text.getText().equalsIgnoreCase(expected)) {
			System.out.println("Test Pass..");
		} else {
			System.out.println("Test Fail...");
		}

	}
}
