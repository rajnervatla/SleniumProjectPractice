package widgets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.zeroturnaround.process.win.W32Errors;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgressBar {

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
		driver.get("https://demoqa.com/progress-bar");

		WebElement startButton = driver.findElement(By.xpath("//*[text()='Start']"));
		WebElement progressBar = driver.findElement(By.xpath("//div[@role=\"progressbar\"]"));
		
		
		startButton.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		boolean progressStatus=wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));
		
		try {
			if(progressStatus==true)
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Reset']"))).click();
				startButton.click();
				System.out.println("ProgressBar is working fine now");
			}
		} catch (Exception e) {
			WebElement startButton1 = driver.findElement(By.xpath("//*[@id='startStopButton']"));
			startButton1.click();
			System.out.println("ProgressBar is working fine now from catch..");
			//e.printStackTrace();
		}

	}

}
