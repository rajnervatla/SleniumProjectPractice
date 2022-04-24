package com.qa.Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	
	public static void main(String[] args) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		String mainwindow=driver.getWindowHandle();
		System.out.println(mainwindow);
		
		Set<String> strwindows=driver.getWindowHandles();
		System.out.println(strwindows);
		
		Iterator itr=strwindows.iterator();
		while(itr.hasNext())
		{
			String childwindow=(String) itr.next();
			if(!mainwindow.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				System.out.println(driver.switchTo().window(childwindow).getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(mainwindow);
	}
}
