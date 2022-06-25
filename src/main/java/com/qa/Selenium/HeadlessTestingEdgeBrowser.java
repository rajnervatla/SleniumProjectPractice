package com.qa.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTestingEdgeBrowser {
	
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		  EdgeOptions edgeOptions =new EdgeOptions();
	        
	        //Use the addArguments method for configuring headless
	        edgeOptions.addArguments("headless");
	        
	        //Pass the edgeOptions object to the Edge Driver
	        WebDriver driver= new EdgeDriver(edgeOptions);
	        
	        //Navigate to toolsQA site url
	        driver.get("https://demoqa.com/");
	        
	        //Print the Title of the Page
	        System.out.println("Title of the page is -> " + driver.getTitle());
	        
	        //Close the driver
	        driver.close();
	    }
	}


