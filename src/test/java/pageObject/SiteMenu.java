package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SiteMenu {
    public By homePageButton = By.cssSelector(".fa.fa-home");
    public By rubberDuckButton = By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-1']");
    public By deliveryInformationButton = By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-2']");
    public By termsAndConditionButton = By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-4']");
    public By discountsButton = By.xpath("//div[@id='site-menu-wrapper']//li[@class='page-5']");
    public By rubberDuckSubcategory = By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-2']");

    private WebDriver driver;

    public SiteMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomePageBtn() {
        driver.findElement(homePageButton).click();
    }

    public void clickRubberDuckBtn() {
        driver.findElement(rubberDuckButton).click();
    }

    public void clickDeliveryInfoBtn() {
        driver.findElement(deliveryInformationButton).click();
    }

    public void clickTermsAndConditionBtn() {
        driver.findElement(termsAndConditionButton).click();
    }

    public void clickDiscountBtn() {
        driver.findElement(discountsButton).click();
    }

    public void openRDSubcategory() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(rubberDuckButton))
                .moveToElement(driver.findElement(rubberDuckSubcategory)).click().perform();
    }
}
