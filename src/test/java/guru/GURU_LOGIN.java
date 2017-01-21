package guru;

import generic.CommonAPI;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by a on 1/20/2017.
 */
public class GURU_LOGIN extends CommonAPI {


    @Parameters({"xpathReset","userLocator","userName","passwordLocator",
    "password","login"})
    @Test
    public void login(String xpathReset,String userLocator,String userName,
                      String passwordLocator,String password,String login){
        //reset

        clickUsingXpath(xpathReset);
       // clickUsingXpath("html/body/form/table/tbody/tr[1]/td[2]/input");
        typeByXpath(userLocator,userName);
        typeByXpath(passwordLocator,password);
        clickUsingXpath(login);

    }
}
