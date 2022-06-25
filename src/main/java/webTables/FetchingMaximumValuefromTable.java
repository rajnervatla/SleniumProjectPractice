package webTables;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingMaximumValuefromTable {
	public static void main(String[] args) throws ParseException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  driver.get("https://money.rediff.com/gainers/bsc/daily/groupa.");
	        String max;
	        double n=0, p=0;
	        
	        //No of Columns
	        List<WebElement>  columns = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
	        System.out.println("No of columns : " +columns.size());
	        
	      //No of Rows
	        List<WebElement>  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	        System.out.println("No of rows : " +rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
	            max= driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            n = Double.parseDouble(max);
	            if(n>p)
	             {    
	                p=n;
	             }
	        }
	        System.out.println("The web table current price : "+ p);

	        

	}
	}


