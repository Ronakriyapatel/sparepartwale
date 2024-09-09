package Testing;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class testassertion 
{
	
	
		WebDriver driver;  
		
		
		@BeforeClass
		public void chrome()
		{		
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");
        System.out.println();
        
        
        
        
		driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();    
        
		}
		
		@Test
		
		public void titlematch()
		{
		String expectedTitle = "Google";
        String actualTitle = driver.getTitle();		
        Assert.assertEquals(expectedTitle, actualTitle);	        
		}
//		
//		@AfterClass
		
//		public void close()
//		{
//			driver.close();
//		}
	
		
}


