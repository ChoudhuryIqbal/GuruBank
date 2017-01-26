package guru;

import generic.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by a on 1/20/2017.
 */
public class GURU_LOGIN extends CommonAPI {




    public  void login (String xpathReset,String userLocator,String userName,
                    String passwordLocator,String password,String login) throws InterruptedException,NoAlertPresentException{
        //reset
        try {
            clickUsingXpath(xpathReset);
            // clickUsingXpath("html/body/form/table/tbody/tr[1]/td[2]/input");
            typeByXpath(userLocator, userName);
            typeByXpath(passwordLocator, password);
            clickUsingXpath(login);
            Thread.sleep(1000);
            String expectedMessage = "User or Password is not valid";
            String actualMessage = textAlert();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
        catch (NoAlertPresentException e){

            Thread.sleep(1000);
        }

    }




    @Parameters({"xpathReset","userLocator","invalidUserName","passwordLocator",
            "password","login"})
    @Test()
    public void SS2(String xpathReset,String userLocator,String userName,
                    String passwordLocator,String password,String login) throws InterruptedException{
        //reset

      login(xpathReset,userLocator,userName,passwordLocator,password,login);
        String expectedMessage ="User or Password is not valid";
        String actualMessage=textAlert();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Parameters({"xpathReset","userLocator","userName","passwordLocator",
            "password","login"})
    @Test(priority = 0)
    public void SS1(String xpathReset,String userLocator,String userName,
                      String passwordLocator,String password,String login) throws InterruptedException,NoAlertPresentException{
        //reset



       login(xpathReset,userLocator,userName,passwordLocator,password,login);
        Thread.sleep(1000);
        String ExpectedTitle="Guru99 Bank Manager HomePage";
        String ActualTitle=getTitle();
        Assert.assertEquals(ExpectedTitle,ActualTitle);

        //Test manager Id
        String managerId=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        if(managerId.startsWith("Manger Id : mngr")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

    }





    @Parameters({"xpathReset","userLocator","userName","passwordLocator",
            "invalidPassword","login"})
    @Test()
    public void SS3(String xpathReset,String userLocator,String userName,
                    String passwordLocator,String password,String login) throws InterruptedException{
        //reset

        login(xpathReset,userLocator,userName,passwordLocator,password,login);
        Thread.sleep(1000);
        String expectedMessage ="User or Password is not valid";
        String actualMessage=textAlert();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Parameters({"xpathReset","userLocator","invalidUserName","passwordLocator",
            "invalidPassword","login"})
    @Test()
    public void SS4(String xpathReset,String userLocator,String userName,
                    String passwordLocator,String password,String login) throws InterruptedException{
        //reset

        login(xpathReset,userLocator,userName,passwordLocator,password,login);
        Thread.sleep(1000);
        String expectedMessage ="User or Password is not valid";
        String actualMessage=textAlert();
        Assert.assertEquals(expectedMessage,actualMessage);

    }




}
