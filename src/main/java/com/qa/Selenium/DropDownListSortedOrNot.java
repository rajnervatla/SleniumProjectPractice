package com.qa.Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownListSortedOrNot {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.ebay.in/");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("gh-cat"));
		element.click();
		List<WebElement> dropDownvalues = element.findElements(By.tagName("option"));
		ArrayList<String> listValues = new ArrayList<String>();
		for (WebElement value : dropDownvalues) {
			System.out.println("values are" + value.getText());
			listValues.add(value.getText());
		}
		boolean sortedOrNot;
		try {
			sortedOrNot = sortedOrNot(listValues);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// assertEquals(true, sortedOrNot);
		driver.close();
	}

	public static boolean sortedOrNot(ArrayList<String> dropDownValues) {
		System.out.println("number of values " + dropDownValues.size());
		for (int i = 0; i < dropDownValues.size(); i++) {
			int temp = dropDownValues.get(i).compareTo(dropDownValues.get(i + 1));
			if (temp > 1) {
				System.out.println("i value" + i);
				return false;
			}
		}
		return true;
	}
}
