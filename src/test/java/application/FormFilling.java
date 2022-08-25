package application;

import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.qa.Selenium.HeighLightTheWebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormFilling {
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

		driver.get("https://demo.automationtesting.in/Register.html");

		WebElement firstname = driver.findElement(By.xpath("//*[@ng-model='FirstName']"));
		WebElement lastName = driver.findElement(By.xpath("//*[@ng-model=\"LastName\"]"));
		WebElement fullnameLabel = driver.findElement(By.xpath("//*[text()='Full Name* ']"));
		WebElement addressLabel = driver.findElement(By.xpath("//*[text()='Address']"));
		WebElement addressTextbox = driver.findElement(By.xpath("//*[@ng-model='Adress']"));
		WebElement emailLabel = driver.findElement(By.xpath("//*[@ng-model='Adress']"));
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@type='email']"));

		WebElement phoneLabel = driver.findElement(By.xpath("//*[text()='Phone*']"));
		WebElement phoneTextbox = driver.findElement(By.xpath("//*[@ng-model=\"Phone\"]"));

		WebElement genderLabel = driver.findElement(By.xpath("//*[text()=\"Gender*\"]"));
		WebElement male = driver.findElement(By.xpath("//*[@type='radio'and  @value='Male']"));
		WebElement female = driver.findElement(By.xpath("//*[@type='radio'and  @value='FeMale']"));

		WebElement hobbies = driver.findElement(By.xpath("//*[text()='Hobbies']"));
		WebElement cricket = driver.findElement(By.xpath("//*[text()=' Cricket ']/../input"));
		WebElement movies = driver.findElement(By.xpath("//*[text()='Movies ']/../input"));
		WebElement hocky = driver.findElement(By.xpath("//*[text()='Hockey']/../input"));

		WebElement languages = driver.findElement(By.xpath("//*[text()='Languages']"));
		WebElement lang_options = driver.findElement(By.xpath("//*[text()='Languages']/following::*[@id='msdd']"));
		WebElement skills = driver.findElement(By.xpath("//*[text()='Skills']"));
		WebElement skills_dropdwn = driver
				.findElement(By.xpath("//*[text()='Skills']/following::select[@id='Skills']"));

		WebElement selectCountry = driver.findElement(By.xpath("//*[text()='Select Country :']"));
		WebElement country_dropdown = driver
				.findElement(By.xpath("//*[text()='Select Country :']/following::select[@id='country']"));
		WebElement DOB_label = driver.findElement(By.xpath("//*[text()='Date Of Birth']"));
		WebElement year = driver.findElement(By.xpath("//*[text()='Date Of Birth']/following::select[@id='yearbox']"));
		WebElement month = driver
				.findElement(By.xpath("//*[text()='Date Of Birth']/following::select[@placeholder='Month']"));
		WebElement day = driver.findElement(By.xpath("//*[text()='Date Of Birth']/following::select[@id=\"daybox\"]"));

		WebElement password = driver
				.findElement(By.xpath("//*[text()='Password']/following::input[@id=\"firstpassword\"]"));
		WebElement confimrpassword = driver.findElement(By.xpath("//*[text()='Confirm Password']/following::div/input[@id='secondpassword']"));
		WebElement submit = driver.findElement(By.xpath("//*[@id='submitbtn']"));
		WebElement refresh = driver.findElement(By.xpath("//*[text()='Refresh']"));

		//firstname.sendKeys("Rajkumar");
		lastName.sendKeys("Nervatla");

		System.out.println(firstname.getAttribute("placeholder"));
		System.out.println(lastName.getAttribute("placeholder"));

		boolean status = fullnameLabel.isDisplayed();
		System.out.println(status);

		if (addressLabel.isDisplayed()) {
			HeighLightTheWebElement.highlightElement(driver, addressTextbox);
			addressTextbox.sendKeys("Chandrapur");
		}

		if (emailLabel.isDisplayed()) {
			HeighLightTheWebElement.highlightElement(driver, emailTextbox);
			emailTextbox.sendKeys("rajnervatla@gmail.com");
		}

		if (phoneLabel.isDisplayed()) {
			HeighLightTheWebElement.highlightElement(driver, phoneTextbox);
			
			phoneTextbox.sendKeys("994u93u4");

		}

		if (genderLabel.isDisplayed()) {
			if (!male.isSelected()) {
				HeighLightTheWebElement.highlightElement(driver, male);
				male.click();
				System.out.println(" Male is selected ");
			} else {
				female.click();
				System.out.println("female is selected ");
			}
		}

		if (hobbies.isDisplayed()) {
			HeighLightTheWebElement.highlightElement(driver, hobbies);
			if (!cricket.isSelected()) {
				cricket.click();
			}
		}
		
		
		try {
			if(languages.isDisplayed())
			{
				HeighLightTheWebElement.highlightElement(driver, lang_options);
				Select select_obje=new Select(lang_options);
				select_obje.selectByIndex(1);
				 select_obje.getFirstSelectedOption();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(100);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
           
		if(skills.isDisplayed())
		{
			HeighLightTheWebElement.highlightElement(driver, skills_dropdwn);
			Select slc=new Select(skills_dropdwn);
			slc.selectByIndex(1);
			
		}
		
		Thread.sleep(5000);
		try {
			if(selectCountry.isDisplayed())
			{
				HeighLightTheWebElement.highlightElement(driver, country_dropdown);
				Select celect=new Select(country_dropdown);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(DOB_label.isDisplayed())
		{
			HeighLightTheWebElement.highlightElement(driver, year);
			HeighLightTheWebElement.highlightElement(driver, month);
            HeighLightTheWebElement.highlightElement(driver, day);
            
            Select slc=new Select(year);
			slc.selectByIndex(1);
			Thread.sleep(2000);
			
			Select slcm=new Select(month);
			slcm.selectByIndex(1);
			Thread.sleep(2000);
			
			
			Select slcday=new Select(day);
			slcday.selectByIndex(1);
			Thread.sleep(2000);
			

			
			
		}
		
		if(password.isDisplayed())
		{
			HeighLightTheWebElement.highlightElement(driver, password);
			password.sendKeys("Password1");
			
			
		}
		

		if(confimrpassword.isDisplayed())
		{
			HeighLightTheWebElement.highlightElement(driver, confimrpassword);
			password.sendKeys("Password1sec");
			
			
		}
		
		if(submit.isDisplayed())
		{
			HeighLightTheWebElement.highlightElement(driver, submit);
			HeighLightTheWebElement.highlightElement(driver, refresh);
			
			submit.click();
			
			
			Thread.sleep(100);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,-350)");
			
			Thread.sleep(5000);
			String msg=firstname.getAttribute("validationMessaage");
			
			Thread.sleep(5000);
			System.out.println(msg);
		}
	}
 
}
