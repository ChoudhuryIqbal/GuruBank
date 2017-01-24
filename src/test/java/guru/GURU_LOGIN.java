package guru;

import generic.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by a on 1/20/2017.
 */
public class GURU_LOGIN extends CommonAPI {




    public  void login (String xpathReset,String userLocator,String userName,
                    String passwordLocator,String password,String login) throws InterruptedException{
        //reset

        clickUsingXpath(xpathReset);
        // clickUsingXpath("html/body/form/table/tbody/tr[1]/td[2]/input");
        typeByXpath(userLocator,userName);
        typeByXpath(passwordLocator,password);
        clickUsingXpath(login);
        Thread.sleep(1000);
       // String expectedMessage ="User or Password is not valid";
       //// String actualMessage=textAlert();
       // Assert.assertEquals(expectedMessage,actualMessage);

    }




    @Parameters({"xpathReset","userLocator","invalidUserName","passwordLocator",
            "password","login"})
    @Test(priority = 2)
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
    @Test(priority = 1)
    public void SS1(String xpathReset,String userLocator,String userName,
                      String passwordLocator,String password,String login) throws InterruptedException{
        //reset



       login(xpathReset,userLocator,userName,passwordLocator,password,login);
        Thread.sleep(1000);
        String ExpectedTitle="Guru99 Bank Manager HomePage";
        String ActualTitle=getTitle();
        Assert.assertEquals(ExpectedTitle,ActualTitle);


    }





    @Parameters({"xpathReset","userLocator","userName","passwordLocator",
            "invalidPassword","login"})
    @Test(priority = 3)
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
    @Test(priority = 4)
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
