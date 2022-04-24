package com.qa.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;

		System.out.println("Hello World!");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		// self
		String textavailable = driver.findElement(By.xpath("//*[contains(text(),'Triveni')]/self::a")).getText();
		System.out.println("Text is " + textavailable);

		String prent_tag = driver.findElement(By.xpath("//*[contains(text(),'Triveni')]/parent::td")).getTagName();

		System.out.println("tag name  " + prent_tag);

		List<WebElement> lis = driver
				.findElements(By.xpath("//*[contains(text(),'Triveni')]/ancestor::tr//descendant::*"));
		System.out.println(lis.size());
		for (WebElement element : lis) {
			System.out.println(element.getText());
		}

		// following siblings
		List<WebElement> flwSibling = driver
				.findElements(By.xpath("//*[contains(text(),'Triveni')]/ancestor::tr/following-sibling::tr"));
		int sizeOfSiblings = flwSibling.size();
		System.out.println("The Size of siblings is " + sizeOfSiblings);

		// Preceding elements
		List<WebElement> preceding = driver
				.findElements(By.xpath("//*[contains(text(),'Triveni')]/ancestor::tr/preceding::*"));
		System.out.println("Preceding elements.." + preceding.size());

		// preceding the preceding siblings and the type of variables should be list of

		List<WebElement> precedingsiblings = driver
				.findElements(By.xpath("//*[contains(text(),'Triveni')]/ancestor::tr/preceding-sibling::*"));
		System.out.println("Preceding siblings " + precedingsiblings.size());

		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		WebElement root = driver.findElement(By.tagName("book-app"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowdom1 = (WebElement) js.executeScript("return.arguments[0].shadowroot", root);

		driver.quit();
		System.out.println("Test Passed...");
	}
}
