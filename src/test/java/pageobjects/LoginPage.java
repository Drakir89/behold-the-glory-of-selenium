package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class LoginPage extends Page {
    @FindBy(id="user")
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

    //internal login method to avoid code duplication
    private void attemptLogin(String user, String password){
        inputUser.clear();
        inputPassword.clear();

        inputUser.sendKeys(user);
        inputPassword.sendKeys(password);
        btnLogin.click();
    }

    public void failLogin(String givenUser, String givenPass){
        attemptLogin(givenUser, givenPass);
    }

    //has a small wait to give the browser time to show the error
    public boolean errorDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(divError));
        return divError.isDisplayed();
    }

    public String getErrorText(){
        return divError.getText();
    }

    public UserHomePage login(String givenUser, String givenPass){
        attemptLogin(givenUser, givenPass);
        return new UserHomePage(driver);
    }
}
