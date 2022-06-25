package com.qa.Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitMechanisminSelenium {

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement gmail = driver.findElement(By.partialLinkText("Gmail"));
		gmail.click();
		driver.navigate().back();
		WebElement forwork = driver.findElement(By.partialLinkText("Images"));
		forwork.click();
		System.out.println("We are not able to find the no nutton on the popup");

		// WebElement nopopup = driver.findElement(By.xpath("//button[text()='No
		// thanks']"));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20); WebElement nobtn = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[text()='No thanks']"))); //nobtn.click();
		 */

		Thread.sleep(5000);

		WebElement sign_in_btn = driver.findElement(By.xpath("//div[@id='yDmH0d']//*[text()='Sign in']"));
		sign_in_btn.click();

		// Get handles of the windows
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch the
		// heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println("New Window tab ...Heading of child window is  ::  " + text.getText());
				// driver.close();
			}
			String windowTitle = driver.switchTo().window(mainWindowHandle).getTitle();
			System.out.println("Successfully switched to main window..." + windowTitle);
		}

		Thread.sleep(5000);
		WebElement nobtn = driver.findElement(By.xpath("//div[@class='QlyBfb']//button[text()='No thanks']"));
		Thread.sleep(5000);
		nobtn.click();

		WebElement textbox = driver.findElement(By.xpath("//*[@name='q']"));
		textbox.sendKeys("Wow work hard");
		WebElement search_btn = driver.findElement(By.xpath("//*[@class='zgAlFc']"));
		search_btn.click();

	}
}
