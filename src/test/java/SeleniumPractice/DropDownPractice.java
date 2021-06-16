package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;

public class DropDownPractice {
   WebDriver driver;

    @BeforeClass
    public void open_driver(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.get("https://qa3.vytrack.com/user/login");
    }
   @Test
    public void Dropdown() throws InterruptedException {
       WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
       userName.sendKeys("user24");
       Thread.sleep(4000);

       WebElement userPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
       userPassword.sendKeys("UserUser123");
       Thread.sleep(4000);

       WebElement login = driver.findElement(By.xpath("//button[@id='_submit']"));
       login.click();

       Thread.sleep(5000);
       //4.Navigate to Fleet module and click Vehicles
       Select fleetDropdown =new Select( driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]")));

       Thread.sleep(5000);
       fleetDropdown.selectByVisibleText("Vehicles");
       Thread.sleep(5000);
   }

}
