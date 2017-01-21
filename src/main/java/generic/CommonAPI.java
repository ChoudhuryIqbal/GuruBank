package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by a on 1/20/2017.
 */
public class CommonAPI {

    public WebDriver driver =null;
    public String url="http://www.demo.guru99.com/V4/";

    @BeforeMethod
    public void setUP(){
        driver=new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
    public void typeByXpath(String locator,String input){
        driver.findElement(By.xpath(locator)).sendKeys(input);
    }

    //takes xpath
    public void clickUsingXpath(String locator){
        driver.findElement(By.xpath(locator)).click();


    }



}
