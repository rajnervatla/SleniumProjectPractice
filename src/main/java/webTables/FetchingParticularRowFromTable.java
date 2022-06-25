package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingParticularRowFromTable {
	public static void main(String[] args) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
		driver.get(baseUrl);
		WebElement value=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[4]/td[3]"));
		System.out.println(value.getText());
		WebElement row_value=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[4]"));
		System.out.print(row_value.getText());
	}

}
