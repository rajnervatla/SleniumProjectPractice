package com.qa.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectSingleValueFromDropdown {

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
		// Step#2- Launching URL
		driver.get("https://demoqa.com/select-menu");

		// Maximizing window
		driver.manage().window().maximize();

		// Step#3- Selecting the dropdown element by locating its id
		Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

		// Step#4- Printing the options of the dropdown
		// Get list of web elements
		List<WebElement> lst = select.getOptions();

		// Looping through the options and printing dropdown options
		System.out.println("The dropdown options are:");
		for (WebElement optio : lst)
			System.out.println(optio.getText());

		// Step#5- Selecting the option as 'Purple'-- selectByIndex
		System.out.println("Select the Option by Index 4");
		select.selectByIndex(4);
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

		// Step#6- Selecting the option as 'Magenta'-- selectByVisibleText
		System.out.println("Select the Option by Text Magenta");
		select.selectByVisibleText("Magenta");
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

		// Step#7- Selecting an option by its value
		System.out.println("Select the Option by value 6");
		select.selectByValue("6");
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

		driver.quit();
	}

}
