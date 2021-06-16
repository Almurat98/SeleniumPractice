package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearUtil {
    public static void loginToSmartBear(WebDriver driver) throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
                WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        if (username.isDisplayed() && password.isDisplayed()){
            username.sendKeys("Tester");
            Thread.sleep(2000);
            password.sendKeys("test"+ Keys.ENTER);
        }
    }

    public static  String changeFormat(String fakerFormat){
        String newFormat=fakerFormat.substring(fakerFormat.indexOf("-")+1,fakerFormat.lastIndexOf("-"))+"/"+fakerFormat.substring(2,4);
        if(newFormat.length()==4){
            newFormat="0"+newFormat;
        }
        return newFormat;
    }
    public static void verifyOrder(WebDriver driver,String name){
        List<WebElement>existingName= driver.findElements(By.xpath(" "));

    }
}

