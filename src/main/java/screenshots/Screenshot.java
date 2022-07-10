package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) {

		WebDriver driver = null;

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(dc);

		driver = new ChromeDriver(dc);
		driver.manage().window().maximize();

		driver.manage().window().maximize();

		String URL = "https://www.facebook.com";
		driver.get(URL);

		WebElement element = driver.findElement(By.xpath("//input[@name='email']"));
		element.sendKeys("Deepak");

		// Convert web driver object into TakeScreenshot.
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Call getScreenshotAs() method to create image file.
		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		// Create an object of the file to move the image file to the new destination
		// and pass the file path as an argument.
		File desFile = new File("./Screenshots/facebook.png");

		// Call copyFile() method to save the file at destination.
		try {
			FileUtils.copyFile(scrFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Taking Screenshots");

		driver.close();
	}
}
