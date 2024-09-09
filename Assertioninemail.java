package Testing;



import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Assertioninemail 
{

    WebDriver driver;
    
	@Test 
    public void chrome() throws InterruptedException
    {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");        
        // Initialize WebDriver and WebDriverWait        
        driver = new ChromeDriver();
        
        // WebDriverWait wait = new WebDriverWait(driver, null);        
        // Open the URL
        driver.get("https://dev.poonamcoatings.com");
        driver.manage().window().maximize();
        
        // Login
        WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
        username.sendKeys("admin@poonamcoatings.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Super@1234");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        
        String expectedtitle="Dashboard";
        String actualtitle=driver.getTitle();
        
        Assert.assertEquals(actualtitle, expectedtitle,"title is matched : pass");      
     }     
 
}
