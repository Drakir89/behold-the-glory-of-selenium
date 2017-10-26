package webtests;

import pageobjects.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestLogin extends TestSkeleton {

    StartPage startPage;
    LoginPage loginPage;
    UserHomePage userHomePage;

    @Test
    public void goToLogin(){
        driver.get("https://trello.com/");
        startPage = new StartPage(driver);
        loginPage = startPage.goToLogin();
        startPage = null;
    }

    @Test(dependsOnMethods = {"goToLogin"})
    public void login(){
        userHomePage = loginPage.login("rftester", "rftester");
        loginPage = null;
    }

}
