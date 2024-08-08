package Testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyersandSuppliers
{

    WebDriver driver;

    public void chrome() throws InterruptedException
	{
	System.setProperty("Webdriver.chromedriver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://dev.poonamcoatings.com");	
	
	//login
	WebElement Username=driver.findElement(By.xpath("//input[@id='email']"));
	Username.sendKeys("admin@poonamcoatings.com");
	
	WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
	Password.sendKeys("Super@1234");
	
	WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
	Login.click();	
	Thread.sleep(8000);	
	
        // Buyers and suppliers
        try 
        {
            WebElement buyersandsupplier = driver.findElement(By.xpath("//span[@class=\"scc-name\" and text()=\"Buyers & Suppliers\"]"));
            buyersandsupplier.click();
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void AddBuyersandSuplliers() throws InterruptedException 
    {
        WebElement addBuyersandSuppliers = driver.findElement(By.xpath("//span[normalize-space()='Add Buyers/Suppliers']"));
        addBuyersandSuppliers.click();
        Thread.sleep(8000);

        // Add new company popup
        WebElement singleCompanyAdd = driver.findElement(By.xpath("//span[normalize-space()='Add Single Company']"));
        singleCompanyAdd.click();
        
        

        // ***********Personal Info***********
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Tanvi");
        Thread.sleep(1000);

        WebElement phone = driver.findElement(By.xpath("//input[@id='mobile_no']"));
        phone.sendKeys("9012143284");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("hfddftel@gmail.com");
        Thread.sleep(1000);

        // ********Company Details***********
        WebElement nameOfCompany = driver.findElement(By.xpath("//input[@id='company_name']"));
        nameOfCompany.sendKeys("kdprdftel");
        Thread.sleep(1000);

        WebElement comRefId = driver.findElement(By.xpath("//input[@id='company_ref_id']"));
        comRefId.sendKeys("4324c63");
        Thread.sleep(1000);

        WebElement officialEmail = driver.findElement(By.xpath("//input[@id='company_email']"));
        officialEmail.sendKeys("roupodopatel@gmail.com");
        Thread.sleep(1000);

        WebElement companyContact = driver.findElement(By.xpath("//input[@id='company_num']"));
        companyContact.sendKeys("94767777");
        Thread.sleep(1000);

        WebElement gst = driver.findElement(By.xpath("//input[@id='gst_number']"));
        gst.sendKeys("22AAAAA9001A3Z5");
        Thread.sleep(1000);

        WebElement companyTypeDd = driver.findElement(By.xpath("//div[@class='drop-down-main drop-down-main-large']//div[contains(@class,'direct')]"));
        companyTypeDd.click();
        WebElement companyTypeSelect = driver.findElement(By.xpath("//span[normalize-space()='Supplier']"));
        companyTypeSelect.click();
        Thread.sleep(1000);
        
        WebElement creditlimit = driver.findElement(By.xpath("//input[@id='creditLimit']"));
        creditlimit.sendKeys("300000");
        
        WebElement paydurationinday = driver.findElement(By.xpath("//input[@id='payDate']"));
        paydurationinday.sendKeys("60");
        

        WebElement address1 = driver.findElement(By.xpath("//input[@id='address-line-one']"));
        address1.sendKeys("Shreetdhar geet Appt.");
        Thread.sleep(1000);

        WebElement address2 = driver.findElement(By.xpath("//input[@id='address_line_two']"));
        address2.sendKeys("Sola Bhagwat rd");
        Thread.sleep(1000);

        WebElement pincode = driver.findElement(By.xpath("//input[@id='pinCode']"));
        pincode.sendKeys("382481");
        Thread.sleep(1000);
        
        WebElement salespersonname = driver.findElement(By.xpath("//input[@id='handlerName']"));
        salespersonname.sendKeys("Roshni");
        Thread.sleep(1000);

        WebElement mark = driver.findElement(By.xpath("//div[@class='input-field checkbox-permission-input-field']//span[@class='filter-check-background']"));
        mark.click();
        Thread.sleep(1000);
        
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();
        Thread.sleep(1000);
        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try 
//        {
//            WebElement alreadyExistMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Already exist')]")));
//            if (alreadyExistMessage.isDisplayed()) 
//            {
//                System.out.println("Company already exists.");
//            }
//        }        
        
//        catch (Exception e)
//        
//        {
//            System.out.println("Company added successfully or some other condition occurred.");
//        }
//    
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        try 
        {
            WebElement alreadyExistMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Already exist')]")));
            if (alreadyExistMessage.isDisplayed()) 
            {
                System.out.println("Company added successfully.");
            }
        } 
        catch (Exception e)
        
        {
            System.out.println("Company already exists");
            
        }
        
        
        
    }

    // ************Edit Company details*****************

    public void EditBuyersandSuplliers() throws InterruptedException 
    {
        try 
        
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tbody tr:nth-child(1) td:nth-child(6) div:nth-child(1) button:nth-child(1) span:nth-child(1)")));
            editButton.click();
        } 
        
        catch (Exception e)         
        {
            e.printStackTrace();
        }

        // Edit Innerbutton click
        try 
        {
            WebElement singleCompanyEdit = driver.findElement(By.xpath("//button[@type=\"button\"] //span[@class=\"material-symbols-outlined small\"]"));
            singleCompanyEdit.click();
            Thread.sleep(2000);
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        // Personal Info
        WebElement efName = driver.findElement(By.xpath("//input[@id='user_name']"));
        efName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        efName.sendKeys("Trisha");
        Thread.sleep(1000);

        WebElement eEmail = driver.findElement(By.xpath("//input[@id='user_email']"));
        eEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        eEmail.sendKeys("hr5tel@gmail.com");
        Thread.sleep(1000);

        WebElement ePhone = driver.findElement(By.xpath("//input[@id='user_num']"));
        ePhone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ePhone.sendKeys("9016261284");
        Thread.sleep(1000);

        // Company Details
        WebElement eNameOfCompany = driver.findElement(By.xpath("//input[@id='company_name']"));
        eNameOfCompany.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        eNameOfCompany.sendKeys("kwpatel");
        Thread.sleep(1000);

        WebElement eOfficialEmail = driver.findElement(By.xpath("//input[@id='company_email']"));
        eOfficialEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        eOfficialEmail.sendKeys("rutupatel@gmail.com");
        Thread.sleep(1000);

        WebElement eCompanyContact = driver.findElement(By.xpath("//input[@id='company_num']"));
        eCompanyContact.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        eCompanyContact.sendKeys("9876367777");
        Thread.sleep(1000);

        WebElement eGST = driver.findElement(By.xpath("//input[@id='gst_number']"));
        eGST.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        eGST.sendKeys("22AAAFA0000A1Z5");
        Thread.sleep(1000);

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(1000);
        
        //Perfect run_18.07.24
        }

    
    //***************Delete Buyers and Suppliers****************   
    
    public void DeleteBuyersandSuppliers() throws InterruptedException 
    {
    	
    	 for(int i=0;i<=4;i++)
    	 {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[6]/div[1]/button[2]/span[1]")));
        deleteButton.click();

        WebElement yesButtonClick = driver.findElement(By.xpath("//button[@class='del-conform']"));
        yesButtonClick.click();      
        	
        
        System.out.printf("Record is:", i);
        }
    }
    
    //**************Pegination**********************

    public void pagination() throws InterruptedException
    {
       
    	try 
        
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pagination-container")));
            List<WebElement> paginationButtons = driver.findElements(By.cssSelector(".pagination-container .pagBTN"));

            for (WebElement button : paginationButtons) 
            {
                button.click();
                Thread.sleep(3000); // You might need to adjust this sleep time
                // Add your logic to handle the content on the new page here
            }
        }        
         
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException 
    {
        BuyersandSuppliers obj = new BuyersandSuppliers();
        obj.chrome();
        obj.AddBuyersandSuplliers();
        //obj.EditBuyersandSuplliers();
       // obj.DeleteBuyersandSuppliers();
       // obj.pagination();
    }
}
