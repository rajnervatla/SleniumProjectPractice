package com.qa.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeSSLUntrustedCertificates {

	public static void main(String[] args) {
		WebDriver driver = null;

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(dc);
		// driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cacert.org/");
		System.out.println("Wow you have successfully handled the security certificates ...");
		driver.close();
	}

}
