package PO.pageObject.pageObjectStatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import PO.pageObject.BasePage;

public class RubberDucks extends BasePage {

    private static By redDuckLabel = By.xpath("//a[@class='link' and contains(@title,'Red')]//div[@title]");
    private static By yellowDuckLabel = By.xpath("//a[@class='link' and contains(@title,'Yellow')]//div[@title]");
    private static By greenDuckLabel = By.xpath("//a[@class='link' and contains(@title,'Green')]//div[@title]");
    private static String newLabel = "NEW";
    private static String saleLabel = "SALE";

    public static boolean checkRedDuckLabel(WebDriver driver) {
        return (driver.findElement(redDuckLabel).getText()).equals(newLabel);
    }

    public static boolean checkYellowDuckLabel(WebDriver driver) {
        return (driver.findElement(yellowDuckLabel).getText()).equals(saleLabel);
    }

    public static boolean checkGreenDuckLabel(WebDriver driver) {
        return (driver.findElement(greenDuckLabel).getText()).equals(newLabel);
    }

    //    @Test
//    public void checkRedLabelTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
//        WebElement elementRedDuck = driver.findElement(By.xpath("//a[@class='link' and contains(@title,'Red')]//div[@title]"));
//        Assert.assertEquals(elementRedDuck.getText(), "NEW");
//        driver.close();
//    }
//
//    @Test
//    public void checkYellowLabelTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
//        WebElement elementYellowDuck = driver.findElement(By.xpath("//a[@class='link' and contains(@title,'Yellow')]//div[@title]"));
//        Assert.assertEquals(elementYellowDuck.getText(), "SALE");
//        driver.close();
//    }
//    @Test
//    public void checkGreenLabelTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://litecart.stqa.ru/en/");
//        WebElement elementGreenDuck = driver.findElement(By.xpath("//a[@class='link' and contains(@title,'Green')]//div[@title]"));
//        Assert.assertEquals(elementGreenDuck.getText(), "NEW");
//        driver.close();
//    }
}
