package com.testng;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetrivingDataFromWebTable {

	@Test
	public void readTableDataInListOfMap() {
		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		//driver.get(fileURL + "/src/test/resources/htmlFiles/WebTable.html");
		driver.get("https://demo.guru99.com/test/web-table-element.php");
 
		// Let's get header first
		String headerLoc = "//table[@class='dataTable']/thead/tr/th";
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);
		}
 
		// Each row will be a key value pair. So we will use LinkedHashMap so that order
		// can be retained.
		// All map will be added to a list.
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
 
		// Get total rows count
		String rowLoc = "//table[@class='tg']//tr";
		List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
		// Starting from 2 as first row is header. Remember xpath index starts from 1
		for (int i = 2; i <= allRowsEle.size(); i++) {
			// Getting specific row with each iteration
			String specificRowLoc = "//table[@class='tg']//tr[" + i + "]";
			// Locating only cells of specific row.
			List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
					.findElements(By.tagName("td"));
			// Creating a map to store key-value pair data. It will be created for each
			// iteration of row
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			// Iterating each cell
			for (int j = 0; j < allColumnsEle.size(); j++) {
				// Getting cell value
				String cellValue = allColumnsEle.get(j).getText();
				// We will put in to map with header name and value with iteration
				// Get jth index value from allHeaderNames and jth cell value of row
				eachRowData.put(allHeaderNames.get(j), cellValue);
			}
			// After iterating row completely, add in to list.
			allTableData.add(eachRowData);
 
		}
 
		System.out.println(allTableData);
		driver.quit();
 
	}
 
}

