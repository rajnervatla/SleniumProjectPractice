package com.qa.Selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {
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
		driver.get("https://demoqa.com/alerts");
		WebElement alrtbtn = driver.findElement(By.id("alertButton"));
		alrtbtn.click();
		Alert alt = driver.switchTo().alert();
		System.out.println("SUccessfully Handled the Alert...");
		alt.accept();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		WebElement alrtTimerbtn = driver.findElement(By.id("timerAlertButton"));

		alrtTimerbtn.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());

		Alert altTimer = driver.switchTo().alert();
		altTimer.accept();
		System.out.println("SUccessfully clicked timer alert");

		WebElement alrt_ok_cancel = driver.findElement(By.id("confirmButton"));
		alrt_ok_cancel.click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
		Alert altokcanl = driver.switchTo().alert();
		altokcanl.accept();
		System.out.println("Clicked on OK on popup..");

		WebElement prompt = driver.findElement(By.id("promtButton"));
		prompt.click();
		new WebDriverWait(driver, Duration.ofSeconds(01)).until(ExpectedConditions.alertIsPresent());
		System.out.println("Clicked on OK on prompt popup..");
		driver.switchTo().alert().sendKeys("Rajkumar");
		Thread.sleep(5000);

		driver.quit();
	}

}
