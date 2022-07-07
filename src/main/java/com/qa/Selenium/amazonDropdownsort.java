package com.qa.Selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonDropdownsort {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		// driver.get("http://www.google.com");

		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		System.out.println("elcik");
		Select se = new Select(element);
		
		List<String> originalList = new ArrayList<String>();
		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
			System.out.println(e.getText());
		}
		// ----logic block starts
		List<String> tempList = originalList;
		Collections.sort(tempList);
		System.out.println("Sorted Array.."+tempList);
		Assert.assertEquals(tempList, originalList);
		System.out.println("PAssed ");
		if(!tempList.equals(originalList))
		{
			System.out.println("PAss ");
		}
		else
		{
			System.out.println("Fail...");
		}
		driver.quit();
	}
	
}
