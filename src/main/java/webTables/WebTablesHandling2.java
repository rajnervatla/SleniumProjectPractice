package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesHandling2 {
	public static void main(String[] args) {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://demo.guru99.com/test/write-xpath-table.html";
		driver.get(baseUrl);
		String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();
		System.out.println(innerText);
		driver.quit();

	}
}
	