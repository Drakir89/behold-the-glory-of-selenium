package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class GlobalHeader extends Page{

    @FindBy(className = "mod-right")
    WebElement linkLoginParent; //this is just the parent to linkLogin, the element that we actually want

    WebElement linkLogin; //assigned manually in constructor

    public GlobalHeader(WebDriver givenDriver){
        super(givenDriver);
        linkLogin = linkLoginParent.findElement(By.linkText("Logga in")); //assigned manually because it is a child
        assertTrue(linkLogin.isDisplayed());
    }

    public LoginPage goToLogin(){
        linkLogin.click();
        return new LoginPage(driver);
    }
}
