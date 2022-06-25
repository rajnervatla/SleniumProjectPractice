package com.qa.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ToolTip2 {
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

		driver.get("https://demoqa.com/tool-tips");

		System.out.println("demoqa webpage Displayed");

		// Instantiate Action Class
		Actions actions = new Actions(driver);

		// Retrieve WebElement
		WebElement element = driver.findElement(By.id("tooltipDemo"));

		// Use action class to mouse hover
		actions.moveToElement(element).perform();

		WebElement toolTip = driver.findElement(By.cssSelector(".tooltiptext"));

		// To get the tool tip text and assert
		String toolTipText = toolTip.getText();
		System.out.println("toolTipText-->" + toolTipText);

		// Verification if tooltip text is matching expected value
		if (toolTipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")) {
			System.out.println("Pass* : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}

		// Close the main window
		driver.close();

	}

}
