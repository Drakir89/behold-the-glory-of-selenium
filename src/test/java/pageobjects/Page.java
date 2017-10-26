package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver givenDriver){
        driver = givenDriver;
        PageFactory.initElements(driver, this);
    }


}
