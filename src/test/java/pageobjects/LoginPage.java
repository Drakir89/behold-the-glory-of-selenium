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

    public void enterUser(String givenUser){
        inputUser.clear();
        inputUser.sendKeys(givenUser);
    }

    public void enterPassword(String givenPass){
        inputPassword.clear();
        inputPassword.sendKeys(givenPass);
    }

    public void submitWrongly(){
        btnLogin.click();
    }

    public UserHomePage submitCorrectly(){
        btnLogin.click();
        return new UserHomePage(driver);
    }

    public void expectErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(divError));
    }
}
