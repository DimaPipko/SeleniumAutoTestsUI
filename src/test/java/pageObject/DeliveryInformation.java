package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class DeliveryInformation extends BasePage {
    public By deliveryInfo = By.xpath("//ul[@class='list-horizontal']/li[contains(text(),'Delivery Information')]");
    private WebDriver driver;

    public DeliveryInformation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDeliveryPageOpen() {
        LOG.info("Checking is DeliveryPage open");
        return driver.findElement(deliveryInfo).isDisplayed();
    }
}
