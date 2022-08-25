package com.qa.Selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSorting {
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

	driver.get("https://demo.automationtesting.in/Register.html");
	WebElement firstdropdown=driver.findElement(By.xpath("//*[@id='Skills']"));
	Thread.sleep(5000);
	
	Select select=new Select(firstdropdown);
	
	List<WebElement> lisop=select.getOptions();
	
	for(WebElement e:lisop)
	{
		System.out.println(e.getText());
	}
}
}
