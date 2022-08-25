package widgets;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabHandling {
	
	public static void main(String[] args) throws InterruptedException {
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
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
	      // wait of 5 seconds
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      // Keys.Chord string
	      String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);
	      // open the link in new tab, Keys.Chord string passed to sendKeys
	      driver.findElement(
	      By.xpath("//*[text()='Terms of Use']")).sendKeys(clickl);
	      Thread.sleep(1000);
	      // hold all window handles in array list
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      System.out.println("Page title of new tab: " + driver.getTitle());
	      //switch to parent window
	      driver.switchTo().window(newTb.get(0));
	      System.out.println("Page title of parent window: " + driver.getTitle());
	      driver.quit();}
	

}
