package com.qa.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
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
		driver.get("https://jqueryui.com/tooltip/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");

		WebElement element = driver.findElement(By.id("age"));
		Actions actions = new Actions(driver);

		// Using the action class to mimic mouse hover
		actions.moveToElement(element).perform();
		//WebElement toolTip = driver.findElement(By.xpath("//*[@id='age']"));

		// To get the tool tip text and assert
		String toolTipText = element.getText();
		System.out.println("toolTipText-->" + toolTipText);

		// Verification if tooltip text is matching expected value
		if (toolTipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		// Close the main window
		driver.close();
		/*
		 * String expectedTooltip =
		 * "We ask for your age only for statistical purposes.";
		 * 
		 * // Find the age field //WebElement ele = driver.findElement(By.id("age"));;
		 * WebElement ele=new WebDriverWait(driver,
		 * Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(
		 * By.id("age")));
		 * 
		 * //get the value of the "title" attribute String actualTooltip =
		 * ele.getAttribute("title");
		 * 
		 * //Comparing tooltip’s value with expected value
		 * System.out.println("Actual Title of Tool Tip"+actualTooltip);
		 * if(actualTooltip.equals(expectedTooltip)) {
		 * System.out.println("Test Case Passed"); } driver.close();
		 */
	}

}
