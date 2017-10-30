package webtests;

import data.DataProvider;
import data.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.StartPage;
import pageobjects.UserHomePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

//this class exists to try out different solutions without editing the original code
public class MessingAround{
    WebDriver driver;
    DataProvider data;

    final String START_ADDRESS = "https://trello.com/";

    StartPage startPage;
    LoginPage loginPage;
    UserHomePage userHomePage;

    @BeforeClass
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        data = new DataProvider();
    }

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
        loginPage.failLogin(badUser.getUser(),badUser.getPass());

        assertTrue(loginPage.errorDisplayed());
    }



}
