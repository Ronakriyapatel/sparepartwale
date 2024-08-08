package Testing;


//import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class gittest1
{
	public void chrome()
	{
		
		WebDriver driver;
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("https://www.google.com");
		driver.close();
		
	}
	
	

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		gittest1 obj=new gittest1();
		obj.chrome();
		
		
				
	}

}
