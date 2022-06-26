package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected final String baseURL = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
