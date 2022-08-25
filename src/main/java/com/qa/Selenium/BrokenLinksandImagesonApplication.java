package com.qa.Selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksandImagesonApplication {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://www.google.com");
		
		driver.get("https://www.theworldsworstwebsiteever.com/");
		Thread.sleep(3000);
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total No Of Images :- " + images.size());
		for (int i = 0; i < images.size(); i++) {
			WebElement el = images.get(i);
			String image_src = el.getAttribute("src");
			verifylink(image_src);
			driver.quit();
		}
	}

	public static void verifylink(String linkurl) {
		try {
			URL url = new URL(linkurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				System.out.println(linkurl + " - " + connection.getResponseCode()+""+connection.getResponseMessage());
			}
			if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkurl + "-" + connection.getResponseCode()+connection.getResponseMessage());
				System.out.println("These are No broken images...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
