package webTables;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesHeads {
	public static void main(String[] args) {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
		driver.get(baseUrl);
		
		List<WebElement> theads=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int no_of_rows=rows.size();
		System.out.println("Number of rows"+no_of_rows);
		
		for(WebElement heads:theads)
		{
			System.out.println(heads.getText());
			System.out.println(heads.getSize());
		}
		driver.quit();

	}
}
