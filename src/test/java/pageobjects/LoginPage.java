package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class LoginPage extends Page {
    @FindBy(id = "user")
    WebElement inputUser;

    @FindBy(id="password")
    WebElement inputPassword;

    @FindBy(id="login")
    WebElement btnLogin;

    @FindBy(id="error")
    WebElement divError;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
        assertTrue(inputUser.isDisplayed());
    }

    public void failLogin(String user, String password){
        this.login(user, password);
    }

    public boolean errorDisplayed(){
        return divError.isDisplayed();
    }

    public UserHomePage login(String user, String password){
        inputUser.sendKeys(user);
        inputPassword.sendKeys(password);
        btnLogin.click();

        return new UserHomePage(driver);
    }
}
