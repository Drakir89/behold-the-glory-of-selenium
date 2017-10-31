package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;


public class StartPage extends Page{
    GlobalHeader header;

    public StartPage(WebDriver givenDriver){
        super(givenDriver);
        header = new GlobalHeader(givenDriver);
        //add assert for page load, when class is more fleshed out
    }

    public GlobalHeader getHeader() {
        return header;
    }
}
