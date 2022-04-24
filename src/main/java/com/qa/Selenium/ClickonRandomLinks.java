package com.qa.Selenium;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickonRandomLinks {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bbc.com/");
	      Thread.sleep(5000);
	      WebElement Boxarea = driver.findElement(By.xpath(".//*[@id='page']/section[6]/div/div/div[2]"));
	      List<WebElement> l1 = Boxarea.findElements(By.tagName("a"));
	      System.out.println("The Number Of Anchor Text" + l1.size());
	      for (int i=0; i<l1.size(); i++)
	      {
	         Random r=new Random();
	         l1.get(r.nextInt(5)).click();
	         String ptitle=driver.getTitle();
	         System.out.println("The Page Title is :" + ptitle);
	         Thread.sleep(5000);
	         driver.get("http://www.bbc.com/");
	         Thread.sleep(5000);
	         Boxarea = driver.findElement(By.xpath(".//*[@id='page']/section[6]/div/div/div[2]"));
	         l1 = Boxarea.findElements(By.tagName("a"));   
	      }
	   }
	}


