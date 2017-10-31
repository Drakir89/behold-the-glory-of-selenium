package webtests;

import data.LoginData;
import pageobjects.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestLogin extends TestSkeleton {

    final String START_ADDRESS = "https://trello.com/";

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
        LoginData badUser = data.getBadLogin();
        loginPage.enterUser(badUser.getUser());
        loginPage.enterPassword(badUser.getPass());

        loginPage.submitWrongly();
        loginPage.expectErrorMessage();
    }

    @Test(dependsOnMethods = {"failLogin"})
    public void login(){
        LoginData user1 = data.getLogin1();
        loginPage.enterUser(user1.getUser());
        loginPage.enterPassword(user1.getPass());

        userHomePage = loginPage.submitCorrectly();
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
