package generic;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by a on 1/20/2017.
 */
public class CommonAPI {

    public WebDriver driver =null;
    public String url="http://www.demo.guru99.com/V4/";

    @BeforeMethod
    public void setUP(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\a\\udemyAutomation\\Guru\\src\\resources\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @AfterMethod
    public void tearDown(){
        driver.close();

    }


    //takeing screenshot

    /**
     *
     */
    public void takeScreenShot(String screenShotName) throws Exception{
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //the below method will save the screen shot in  d drive with name
        FileUtils.copyFile(scrFile,new File("C:\\Users\\a\\udemyAutomation\\Guru\\ScreenShot\\"+screenShotName+".png"));

    }
    public void typeByXpath(String locator,String input){
        driver.findElement(By.xpath(locator)).sendKeys(input);
    }

    //takes xpath
    public void clickUsingXpath(String locator){
        driver.findElement(By.xpath(locator)).click();


    }


    //start method get webpage title of a web page
    public String getTitle(){
      return driver.getTitle();
    }


    //Read Alert text
    public String textAlert(){

        Alert alert=driver.switchTo().alert();

        return alert.getText();
    }






}
