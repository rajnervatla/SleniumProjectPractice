package com.qa.Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadExcelFile {
	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");
		Thread.sleep(100);

		File ff = new File("C:\\Users\\rnervatl\\Desktop\\Login Details.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(ff);
		XSSFSheet sheet = wb.getSheet("login");
		int row = sheet.getLastRowNum();
		System.out.println("Number of Rows " + row);

		for (int i = 1; i <= row; i++) {
			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			String password = sheet.getRow(i).getCell(1).getStringCellValue();

			System.out.println(" Data Present in Excel " + username + "  " + password);

			WebElement uname = driver.findElement(By.xpath("//*[@id='userName']"));
			WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
			WebElement login_button = driver.findElement(By.xpath("//*[@id='login']"));

			uname.clear();
			uname.sendKeys(username);
			pwd.clear();
			pwd.sendKeys(password);
			Thread.sleep(100);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)");
			login_button.click();
			Thread.sleep(5000);
			String loggedinApp = driver.getCurrentUrl();
			System.out.println(loggedinApp);
			if (loggedinApp.contains("profile")) {
				System.out.println("Login successfull..");

				Thread.sleep(5000);
				WebElement logout_button = driver.findElement(By.xpath("//*[text()='Log out']"));
				logout_button.click();
				Thread.sleep(1000);

			}

			driver.quit();
		}
	}
}
