package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Department 
{

    WebDriver driver;

    public void chrome() throws InterruptedException
	{
		System.setProperty("WebDriver.chromedriver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");
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
	}
	

    public void adddepartment(String departname[], String description[]) throws InterruptedException
    {
        // Click on Setting
        WebElement settingclick = driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
        settingclick.click();

        // Click on department
        WebElement departmentclick = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div[10]/div[5]"));
        departmentclick.click();

        int row = departname.length;

        for (int i = 0; i < row; i++) 
        {         
        	
        	// Check if department already exists
            if (!driver.findElements(By.xpath("//td[text()='" + departname[i] + "']")).isEmpty()) 
            {
                System.out.println("Duplicate department found: " + departname[i]);
                continue; // Skip the duplicate department
            }
        	
        else        	
        {
        	
        	try        	
        	{
        	
            // Add department
            WebElement adddepartmentclick = driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
            adddepartmentclick.click();

            WebElement departmentname = driver.findElement(By.xpath("//input[@id='name']"));
            departmentname.sendKeys(departname[i]);

            WebElement descriptionElement = driver.findElement(By.xpath("//textarea[@id='description']"));
            descriptionElement.sendKeys(description[i]);

            WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
            submit.click();

            // Wait for the new department to be added before checking the next one
            Thread.sleep(2000);
        	}
        	
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }}
        
    }
    

    public static void main(String[] args) throws InterruptedException 
    {
        Department obj = new Department();
        obj.chrome();
        String[] departname = {"contentrttrrr", "marketiddnttgrre", "Accddottunte", "Salesjhghg", "Retailerjgj"};
        String[] description = {"this is content writer post", "this is posdt for marketing", "Accounting", "This is a Sales Departmet", "This is a Retailer department"};
        obj.adddepartment(departname, description);
    }
}
