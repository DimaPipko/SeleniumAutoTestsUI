package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SiteMenu {
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
        driver.findElement(btnHomePage).click();
    }

    public void clickRubberDuckBtn() {
        driver.findElement(btnRubberDuck).click();
    }

    public void clickDeliveryInfoBtn() {
        driver.findElement(btnDeliveryInformation).click();
    }

    public void clickTermsAndConditionBtn() {
        driver.findElement(btnTermsAndCondition).click();
    }

    public void clickDiscountBtn() {
        driver.findElement(btnDiscounts).click();
    }

    public void openRDSubcategory() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(btnRubberDuck))
                .moveToElement(driver.findElement(btnRubberDuckSubcategory)).click().perform();
    }
}
