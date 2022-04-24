package com.qa.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	public static void main(String[] args) {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String u = "https://sqengineer.com/practice-sites/practice-tables-selenium/";
		driver.get(u);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// identify table
		WebElement t = driver.findElement(By.xpath("//*[@id='table1']/tbody"));
		// count rows with size() method
		List<WebElement> rws = t.findElements(By.tagName("tr"));
		int rws_cnt = rws.size();
		// iterate rows of table
		for (int i = 0; i < rws_cnt; i++) {
			// count columns with size() method
			List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
			int cols_cnt = cols.size();
			// iterate cols of table
			for (int j = 0; j < cols_cnt; j++) {
				// get cell text with getText()
				String c = cols.get(j).getText();
				System.out.println("The cell value is: " + c);
			}
		}
		driver.quit();
	}

}
