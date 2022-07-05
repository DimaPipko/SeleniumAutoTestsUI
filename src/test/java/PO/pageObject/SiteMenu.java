package PO.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SiteMenu extends BasePage {
    public By btnHomePage = By.cssSelector(".fa.fa-home");
    public By btnRubberDuck = By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-1']");
    public By btnDeliveryInformation = By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-2']");
    public By btnTermsAndCondition = By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-4']");
    public By btnDiscounts = By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-5']");
    public By btnRubberDuckSubcategory = By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-2']");

    private WebDriver driver;

    public SiteMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomePageBtn() {
        LOG.info("Click Home Page");
        driver.findElement(btnHomePage).click();
    }

    public void clickRubberDuckBtn() {
        LOG.info("Click duck btn");
        driver.findElement(btnRubberDuck).click();
    }

    public void clickDeliveryInfoBtn() {
        LOG.info("Click DeliveryInfo btn");
        driver.findElement(btnDeliveryInformation).click();
    }

    public void clickTermsAndConditionBtn() {
        LOG.info("Click Terms and Condition btn");
        driver.findElement(btnTermsAndCondition).click();
    }

    public void clickDiscountBtn() {
        LOG.info("Click Discount btn");
        driver.findElement(btnDiscounts).click();
    }

    public void openRDSubcategory() {
        LOG.info("open duck subcategory");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(btnRubberDuck))
                .moveToElement(driver.findElement(btnRubberDuckSubcategory)).click().perform();
    }
}
