package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class UserHomePage extends Page{
    UserHeader header;

    @FindBy(className="js-boards-page")
    WebElement divBoardsPage;

    public UserHomePage(WebDriver givenDriver){
        super(givenDriver);
        assertTrue(boardsDisplayed());
        header = new UserHeader(driver);
    }

    public UserHeader getHeader() {
        return header;
    }

    public boolean boardsDisplayed(){
        return divBoardsPage.isDisplayed();
    }
}
