package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryInformation {
    public By deliveryInfo = By.xpath("//ul[@class='list-horizontal']/li[contains(text(),'Delivery Information')]");
    private WebDriver driver;

    public DeliveryInformation(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isDeliveryPageOpen() {
        return driver.findElement(deliveryInfo).isDisplayed();
    }
}
