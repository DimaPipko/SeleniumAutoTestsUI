
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class WebDriverTest {
    //selenium 1st HW
    @Test
    public void getAllLinksAndClickTenthTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());
        WebElement tenthElement = allLinks.get(9);
        tenthElement.click();
        driver.close();
    }

    //Webdriver advanced p1 HW
    @Test
    public void openDeliveryInfoTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-2']"));
        element.click();
        WebElement deliveryInfoElement = driver.findElement
                (By.xpath("//ul[@class='list-horizontal']/li[contains(text(),'Delivery Information')]"));
        Assert.assertTrue(deliveryInfoElement.isDisplayed());
        driver.close();
    }

    @Test
    public void openTermsAndConditionTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-4']"));
        element.click();
        WebElement TermsAndConditionElement = driver.findElement
                (By.xpath("//ul[@class='list-horizontal']/li[contains(text(),'Terms & Conditions')]"));
        Assert.assertTrue(TermsAndConditionElement.isDisplayed());
        driver.close();
    }
}
