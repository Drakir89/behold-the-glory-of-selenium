package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class UserHomePage extends Page{
    @FindBy(className="js-boards-page")
    WebElement divBoardsPage;

    public UserHomePage(WebDriver givenDriver){
        super(givenDriver);
        assertTrue(boardsDisplayed());
    }

    public boolean boardsDisplayed(){
        return divBoardsPage.isDisplayed();
    }
}
