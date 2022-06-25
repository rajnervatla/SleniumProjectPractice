package com.testng;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.ous.jtoml.ParseException;

public class DatadrivenTestingThroughJsonFile {

	WebDriver driver;

	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.get("https://www.nopcommerce.com/en/login?returnUrl=%2Fen");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

	@Test(dataProvider = "dp")
	void login(String data) throws InterruptedException {

		String users[] = data.split(",");

		driver.findElement(By.xpath("//*[@class='username']")).sendKeys(users[0]);
		driver.findElement(By.xpath("//*[@class='password']")).sendKeys(users[1]);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		Thread.sleep(5000);
		String actual_title = driver.getTitle();
		String expected_title = "";
		Assert.assertEquals(actual_title, expected_title);

	}

	@DataProvider(name = "dp")
	String[] readJson() throws IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\jsonfiles\\jsonviewer.json");

		Object obj = jsonparser.parse(reader);
		JSONObject userloginsobj = (JSONObject) obj;
		JSONArray userloginarray = (JSONArray) userloginsobj.get("userlogins");

		String arr[] = new String[userloginarray.size()];

		for (int i = 0; i < userloginarray.size(); i++) {
			JSONObject users = (JSONObject) userloginarray.get(i);
			String user = (String) users.get("username");
			String pass = (String) users.get("password");

			arr[i] = user + "," + pass;

		}
		return arr;
	}

}
