package webtests;

import pageobjects.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestLogin extends TestSkeleton {

    String START_ADDRESS = "https://trello.com/";

    StartPage startPage;
    LoginPage loginPage;
    UserHomePage userHomePage;

    @Test
    public void goToLogin(){
        driver.get(START_ADDRESS);
        startPage = new StartPage(driver);
        loginPage = startPage.goToLogin();
        startPage = null;
    }

    @Test (dependsOnMethods = {"goToLogin"})
    public void failLogin(){
        loginPage.failLogin("badname","badpass");
        assertTrue(loginPage.errorDisplayed());
    }

    @Test(dependsOnMethods = {"failLogin"})
    public void login(){
        userHomePage = loginPage.login("rftester@mailinator.com", "rftester");
        loginPage = null;
    }

    @Test(dependsOnMethods = {"login"})
    public void revisitStartPageWhenLoggedIn(){
        driver.get(START_ADDRESS);
        assertTrue(userHomePage.boardsDisplayed());
    }

    @Test(enabled = false, dependsOnMethods = {"revisitStartPageWhenLoggedIn"})
    public void logoutFromUserHomePage(){

    }

}
