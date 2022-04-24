package com.qa.Selenium;

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

	driver.get("http://www.leafground.com/pages/Dropdown.html");
	WebElement firstdropdown=driver.findElement(By.xpath("//select[@id='dropdown1']"));
	
	Select select=new Select(firstdropdown);
	
	List<WebElement> options1 =driver.findElements(By.tagName("option"));
	
	
	for(WebElement opts:options1)
	{
		System.out.println(opts.getText());
	}
}
}
