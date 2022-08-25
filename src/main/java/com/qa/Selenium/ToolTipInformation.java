package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipInformation {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// CASE 1: Using getAttribute
		// Launch the URL
		driver.get("https://jqueryui.com/tooltip/");
		//System.out.println("Tooltip web Page Displayed");

		// Maximise browser window
		driver.manage().window().maximize();

		// Get element for which we need to find tooltip
		
		 WebElement frm=driver.findElement(By.xpath("//*[@class='demo-frame']"));
		driver.switchTo().frame(frm);
		WebElement ageTextBox = driver.findElement(By.xpath("//input[@id='age']"));

		// Get title attribute value
		String tooltipText = ageTextBox.getAttribute("title");

		System.out.println("Retrieved tooltip text as :" + tooltipText);

		// Verification if tooltip text is matching expected value
		if (tooltipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")) {
			System.out.println("Pass : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}

		// Close the main window
		driver.close();
	}

}
