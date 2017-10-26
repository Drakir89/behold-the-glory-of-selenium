package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;


public class StartPage extends Page{
    @FindBy(linkText="Logga in")
    WebElement btnLogin;

    public StartPage(WebDriver givenDriver){
        super(givenDriver);
        assertTrue(btnLogin.isDisplayed());
    }

    public LoginPage goToLogin(){
        btnLogin.click();
        return new LoginPage(driver);
    }

}
