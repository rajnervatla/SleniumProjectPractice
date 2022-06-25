package com.qa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickonTheElementsUsingActions {
	public static void main(String[] args) throws InterruptedException {
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
		 driver.get("https://demoqa.com/buttons");
	/*	Actions action = new Actions(driver);

		// Perform right click
		// WebElement rightclick =
		// driver.findElement(By.xpath("//*[@id='rightClickBtn']"));

		// Right click on the button
		// action.contextClick(rightclick).build().perform();

		// mouse hover
		// driver.navigate().to("https://courses.letskodeit.com/practice");
		
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,250)");
		 

		/
		  WebElement helpmousehover = driver.findElement(By.id("mousehover"));
		 action.moveToElement(helpmousehover).perform();
		 * System.out.println("Hovered on the button...");
		 * 
		 * WebElement doubleclick_on_op = driver.findElement(By.id("openwindow"));
		 * action.contextClick(doubleclick_on_op).build().perform();
		 * System.out.println("Double clicked.......");
		 
		driver.navigate().to("https://demoqa.com/droppable");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");

		WebElement irr = driver.findElement(By.xpath("//*[text()='Simple']"));
		irr.click();

		Thread.sleep(100);

		WebElement src = driver.findElement(By.xpath("//*[text()='Drag me']"));

		WebElement dsrc = driver.findElement(By.xpath("//*[text()='Drop here']"));
		Thread.sleep(100);
		// action.dragAndDrop(src, dsrc).build().perform();

		//Action dragdrop = action.clickAndHold(src).moveToElement(dsrc).release(src).build();
		//dragdrop.perform();
		action.dragAndDrop(src, dsrc).build().perform();

		Thread.sleep(5000);
		System.out.println("Successfully performed the drag drop operation..");
		driver.quit();
*/
	}

}
