package SeleniumPractice;

import Utilities.DriverFactory;
import Utilities.SmartBearUtil;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {
    WebDriver driver;

    @BeforeClass
    public void open_driver_Login() throws InterruptedException {
    driver= DriverFactory.getDriver("chrome");
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    SmartBearUtil.loginToSmartBear(driver);
    driver.manage().window().maximize();
    }



    @Test
            public void smartBearTest1() throws InterruptedException {
        List<WebElement>allLinks= driver.findElements(By.xpath("//body//a"));
        System.out.println("count of all links in website = " + allLinks.size());
        for(WebElement eachLink:allLinks){
            System.out.println(eachLink.getText());
        }

    WebElement order=driver.findElement(By.xpath("//a[.='Order']"));
        order.click();
        Thread.sleep(3000);
        Select product=new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        product.selectByIndex(1);

        WebElement quantity= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.clear();
        quantity.sendKeys("2");
        WebElement calculate=driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();
    }
       @Test
        public void smartBearTest2(){

            Faker faker = new Faker();
            String fullName = faker.name().fullName();
            String street = faker.address().streetName();
            String city = faker.address().city();
            String state = faker.address().state();
            String zipCode = faker.address().zipCode().substring(0,5);


            WebElement inputName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
            inputName.sendKeys(fullName);
            WebElement inputStreet = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
            inputStreet.sendKeys(street);
            WebElement inputCity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
            inputCity.sendKeys(city);
            WebElement inputState = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
            inputState.sendKeys(state);
            WebElement inputZipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
            inputZipCode.sendKeys(zipCode);

            WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
            visaButton.click();
            String cardNumber = faker.number().digits(16);

            WebElement inputCardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
            inputCardNumber.sendKeys(cardNumber);
            String expDate = faker.business().creditCardExpiry();
            String CorrectFormat= SmartBearUtil.changeFormat(expDate);

            WebElement inputExpDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
            inputExpDate.sendKeys(CorrectFormat);

            WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
            process.click();

        }

     @Test
      public void smartBearTest3(){
     WebElement viewAllOrders=driver.findElement(By.xpath("//a[.='View all orders']"));
     viewAllOrders.click();

      WebElement susanOrderDate=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//td[.='Susan McLaren']/../td[5]"));
      String actualDate=susanOrderDate.getText();
      String expectedDate="01/05/2010";

         Assert.assertEquals(actualDate,expectedDate,"Susuan does not have order on 01/05/2010");

     }
    }

