package PO.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected final String baseURL = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void setup() {
        Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome"));

        switch (browser) {
            case chrome -> driver = new ChromeDriver();
            case firefox -> driver = new FirefoxDriver();
            case edge -> driver = new EdgeDriver();
        }
        driver.get(baseURL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
