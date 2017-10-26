import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        StartPage startPage = initializeDriver();
        LoginPage loginPage = startPage.goToLogin();
        UserHomePage userHomePage = loginPage.login("rftester","rftester");
        int uselessVariable = 42;
    }



    private static StartPage initializeDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/");
        return new StartPage(driver);
    }
}
