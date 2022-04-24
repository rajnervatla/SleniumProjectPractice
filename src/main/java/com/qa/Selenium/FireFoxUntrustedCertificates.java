package com.qa.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxUntrustedCertificates {
	
	public static void main(String[] args) {
		WebDriver driver = null;
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		driver =  new FirefoxDriver();
		driver.manage().window().maximize();
	}

}
