package webtests;

import data.TestData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestSkeleton {
    protected WebDriver driver;
    protected TestData data;

    @BeforeClass
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        data = new TestData();
    }

    @AfterClass()
    public void closeDriver(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
