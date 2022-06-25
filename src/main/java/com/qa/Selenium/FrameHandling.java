package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {
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
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame(1);
		System.out.println("Successfully switched to frame 1");

		String WeText = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(WeText);
		driver.switchTo().defaultContent();
		Thread.sleep(300);
		WebElement frm2 = driver.findElement(By.xpath("//*[@id='frame2']"));
		driver.switchTo().frame(frm2);
		// String
		// WeText1=driver.findElement(By.xpath("//div[@id='frame2Wrapper']/following::iframe[2]")).getText();
		// System.out.println(WeText1);
		System.out.println("Switched to frame..");
		driver.switchTo().defaultContent();
		WebElement textlink = driver.findElement(By.xpath("//*[text()='Browser Windows']"));
		String s = textlink.getText();
		System.out.println(s);
		textlink.click();

		driver.quit();
	}
}
