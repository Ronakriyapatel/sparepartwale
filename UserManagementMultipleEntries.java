package Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagementMultipleEntries 
{

    WebDriver driver;

    // Initialize the Chrome WebDriver
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

    // Add Admin User with provided details
    public void addAdminUser(String firstName, String lastName, String email, String phoneNumber, String gender, String dob, String role, String department, String privileges) throws InterruptedException 
    {
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try
        {
            WebElement settingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
            settingClick.click();

            WebElement userManagementClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'User Management')]")));
            userManagementClick.click();

            //Click on Add button
            WebElement addButtonClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary header-btn']")));
            addButtonClick.click();

            //Fill User Details
            WebElement firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='first_name']")));
            firstNameInput.sendKeys(firstName);

            WebElement lastNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='last_name']")));
            lastNameInput.sendKeys(lastName);

            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
            emailInput.sendKeys(email);

            WebElement phoneNumberInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phone_no']")));
            phoneNumberInput.sendKeys(phoneNumber);

            //Gender Selection
            WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[1]")));
            genderDropdown.click();
            WebElement genderSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + gender + "']")));
            genderSelect.click();
            Thread.sleep(2000);

            //Date of Birth
            WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dob']")));
            dobInput.sendKeys("23-12-1991");
            Thread.sleep(3000);            
        
            //Role Selection
            WebElement roleDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[2]")));
            roleDropdown.click();
            WebElement roleselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + role + "']")));
            roleselect.click();
            Thread.sleep(2000);            

            //Department Selection
            WebElement departmentDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[3]")));
            departmentDropdown.click();
            WebElement departmentSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + department + "']")));
            departmentSelect.click();
            Thread.sleep(2000);           

    		
    		//Privileges
    		WebElement Privileges=driver.findElement(By.xpath("//button[normalize-space()='Add Privileges']"));
    		Privileges.click();
    		
    		//User management
    		WebElement PrivilegesRead=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));		
    		WebElement PrivilegesWrite=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]"));		
    		WebElement PrivilegesDelete=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]"));
    				
    		PrivilegesRead.click();
    		PrivilegesWrite.click();
    		PrivilegesDelete.click();
    		
    		//Submit privileges
    		WebElement Submitpriv=driver.findElement(By.xpath("//div[@class='privileges-submit']//button[contains(text(),'Submit')]"));
    		Submitpriv.click();	
    		
    		
    		//Main User add Submit
    		WebElement submit=driver.findElement(By.cssSelector(".btn-primary:nth-child(2)"));
    		submit.click();
    		
    		//successfully run , code updated on 10.09.24
    			
      } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // Read User Data from Excel and Add Users
    public void addUserFromExcel(String excelFilePath) throws IOException, InterruptedException 
    {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\UserManagement.xlsx"); 
        		Workbook workbook = new XSSFWorkbook(inputStream)) 
        {
            Sheet user = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            for (int i = 1; i < user.getLastRowNum(); i++) 
            {
            	
                Row row = user.getRow(i);
                String firstName = dataFormatter.formatCellValue(row.getCell(0));
                String lastName = dataFormatter.formatCellValue(row.getCell(1));
                String email = dataFormatter.formatCellValue(row.getCell(2));
                String phoneNumber = dataFormatter.formatCellValue(row.getCell(3));
                String gender = dataFormatter.formatCellValue(row.getCell(4));
                String dob = dataFormatter.formatCellValue(row.getCell(5));
                String role = dataFormatter.formatCellValue(row.getCell(6));
                String department = dataFormatter.formatCellValue(row.getCell(7));               
                String privileges = dataFormatter.formatCellValue(row.getCell(8));    
                 
                addAdminUser(firstName, lastName, email, phoneNumber, gender, dob, role, department, privileges);
            }
        }
    }

    // Main Method
    public static void main(String[] args) throws InterruptedException, IOException 
    {
        UserManagementMultipleEntries obj = new UserManagementMultipleEntries();
        obj.chrome();
        obj.addUserFromExcel("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\UserManagement.xlsx");
    }
}
