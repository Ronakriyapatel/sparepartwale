package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class testduplicatedata 
{

    WebDriver driver;

    
    public void chrome() throws InterruptedException
	{
		
		System.setProperty("Webdriver.chromedriver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");		
		driver=new ChromeDriver();
		driver.get("https://dev.poonamcoatings.com");
		driver.manage().window().maximize();	
		
		//login
		WebElement Username=driver.findElement(By.xpath("//input[@id='email']"));
		Username.sendKeys("admin@poonamcoatings.com");		
		
		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys("Super@1234");
		
		WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
		Login.click();	
		Thread.sleep(8000);	
//		
//	      // Wait until the settings button is clickable to ensure page has loaded
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
    }

    	public void addDepartment(String[] departNames, String[] descriptions) throws InterruptedException 
    	{
        // Click on Settings
        WebElement settingClick = driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
        settingClick.click();

        // Wait for the department menu to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div[10]/div[5]")));

        // Click on Department
        WebElement departmentClick = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div[10]/div[5]"));
        departmentClick.click();

        int rowCount = departNames.length;

        for (int i = 0; i < rowCount; i++) 
        {
            try 
            {
                // Check if department already exists
                List<WebElement> existingDepartments = driver.findElements(By.xpath("//td[text()='" + departNames[i] + "']"));
                if (!existingDepartments.isEmpty()) 
                {
                    System.out.println("Duplicate department found: " + departNames[i] + ". Skipping...");
                    continue; // Skip the duplicate department
                }

                // Add department
                WebElement addDepartmentClick = driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
                addDepartmentClick.click();

                // Wait for the department name input field to be visible
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));

                WebElement departmentName = driver.findElement(By.xpath("//input[@id='name']"));
                departmentName.sendKeys(departNames[i]);

                WebElement descriptionElement = driver.findElement(By.xpath("//textarea[@id='description']"));
                descriptionElement.sendKeys(descriptions[i]);

                WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
                submit.click();

                // Wait for the department list to be updated
                Thread.sleep(2000);

                System.out.println("Successfully added department: " + departNames[i]);

            } 
            
            catch (Exception e) 
            {
                System.out.println("An error occurred while adding department: " + departNames[i]);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception 
    {
    	testduplicatedata obj = new testduplicatedata();
        obj.chrome();
        String[] departNames = {"contentdrttrrr", "marketidsdnttgrre", "Accddosdttsdunte", "Salsesjsdhghg", "Retasdilerjgsj"};
        String[] descriptions = {"this is content writer post", "this is post for marketing", "Accounting", "This is a Sales Department", "This is a Retailer department"};
        obj.addDepartment(departNames, descriptions);
    }
}
