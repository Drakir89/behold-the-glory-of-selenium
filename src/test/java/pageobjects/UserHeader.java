package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class UserHeader extends Page{
    @FindBy(className="js-open-header-member-menu")
    WebElement linkMemberMenu;

    @FindBy(className="js-logout")
    WebElement linkLogout;

    public UserHeader(WebDriver givenDriver){
        super(givenDriver);
        assertTrue(linkMemberMenu.isDisplayed());
    }

    //open user menu and wait for it to show
    public void openMemberMenu(){
        linkMemberMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(linkLogout));
    }

    public LoggedOutPage logoutFromMemberMenu(){
        linkLogout.click();
        return new LoggedOutPage(driver);
    }
}
