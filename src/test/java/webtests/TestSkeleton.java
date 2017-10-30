package webtests;

import data.DataProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestSkeleton {
    protected WebDriver driver;
    protected DataProvider data;

    @BeforeClass
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        data = new DataProvider();
    }

    @AfterClass()
    public void closeDriver(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
