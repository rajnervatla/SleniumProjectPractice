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

public class SelectMultipleValueFromDropdown {

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
		// Navigate to the URL
		driver.get("https://demoqa.com/select-menu");

		// Selecting the multi-select element by locating its id
		Select select = new Select(driver.findElement(By.id("cars")));

		// Get the list of all the options
		System.out.println("The dropdown options are -");

		List<WebElement> optn = select.getOptions();

		for (WebElement option : optn)
			System.out.println(option.getText());

		// Using isMultiple() method to verify if the element is multi-select, if yes go
		// onto next steps else eit
		if (select.isMultiple()) {

			// Selecting option as 'Opel'-- ByIndex
			System.out.println("Select option Opel by Index");
			select.selectByIndex(2);

			// Selecting the option as 'Saab'-- ByValue
			System.out.println("Select option saab by Value");
			select.selectByValue("saab");

			// Selecting the option by text
			System.out.println("Select option Audi by Text");
			select.selectByVisibleText("Audi");

			// Get the list of selected options
			System.out.println("The selected values in the dropdown options are -");

			List<WebElement> selectedOptions = select.getAllSelectedOptions();

			for (WebElement selectedOption : selectedOptions)
				System.out.println(selectedOption.getText());

			// Deselect the value "Audi" by Index
			System.out.println("DeSelect option Audi by Index");
			select.deselectByIndex(3);

			// Deselect the value "Opel" by visible text
			System.out.println("Select option Opel by Text");
			select.deselectByVisibleText("Opel");

			// Validate that both the values are deselected
			System.out.println("The selected values after deselect in the dropdown options are -");
			List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

			for (WebElement selectedOptionAfterDeselect : selectedOptionsAfterDeselect)
				System.out.println(selectedOptionAfterDeselect.getText());

			// Step#8- Deselect all values
			select.deselectAll();
		}

		driver.quit();
	}

}
