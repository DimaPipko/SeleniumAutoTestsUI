package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndCondition {
    public By termsAndCondition = By.xpath("//ul[@class='list-horizontal']/li[contains(text(),'Terms & Conditions')]");
    private WebDriver driver;

    public TermsAndCondition(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTermsAndConditionPageOpen() {
        return driver.findElement(termsAndCondition).isDisplayed();
    }
}
