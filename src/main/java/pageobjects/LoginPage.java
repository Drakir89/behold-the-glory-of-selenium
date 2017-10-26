package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class LoginPage extends Page {
    @FindBy(id="user")
    WebElement inputUser;

    @FindBy(id="password")
    WebElement inputPassword;

    @FindBy(id="login")
    WebElement btnLogin;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
        assertTrue(inputUser.isDisplayed());
    }

    public UserHomePage login(String user, String password){
        inputUser.sendKeys(user);
        inputPassword.sendKeys(password);
        btnLogin.click();

        return new UserHomePage(driver);
    }
}
