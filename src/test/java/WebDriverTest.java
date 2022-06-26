
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.*;

import java.util.List;


public class WebDriverTest extends BaseTest {

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


    @Test
    public void openDeliveryInformationTest() {
        var siteMenu = new SiteMenu(driver);
        siteMenu.clickDeliveryInfoBtn();
        var deliveryInformation = new DeliveryInformation(driver);
        Assert.assertTrue(deliveryInformation.isDeliveryPageOpen(), "Cannot open page");
    }

    @Test
    public void openTermsAndConditionTest() {
        var siteMenu = new SiteMenu(driver);
        siteMenu.clickTermsAndConditionBtn();
        var termsAndCondition = new TermsAndCondition(driver);
        Assert.assertTrue(termsAndCondition.isTermsAndConditionPageOpen(), "Cannot open page");
    }

    @Test
    public void transitionToSubcategoryTest() {
        SiteMenu siteMenu = new SiteMenu(driver);
        siteMenu.openRDSubcategory();
        var rubberDucksSubcategory = new RubberDucksSubcategory(driver);
        Assert.assertTrue(rubberDucksSubcategory.isSubcatecoryPageOpen(), "Cannot open page");
    }

    @Test
    public void sortingDucksByNameTest() {
        var siteMenu = new SiteMenu(driver);
        var rubberDucksSubcategory = new RubberDucksSubcategory(driver);
        siteMenu.openRDSubcategory();
        rubberDucksSubcategory.clickSortingByNameBtn();
        List<String> duckName = rubberDucksSubcategory.getAllDuckName();
        Assert.assertTrue(rubberDucksSubcategory.isDucksSortedByName(duckName), "not sorted by name");
    }

    @Test
    public void sortingByPriceTest() {
        var siteMenu = new SiteMenu(driver);
        var rubberDucksSubcategory = new RubberDucksSubcategory(driver);
        siteMenu.openRDSubcategory();
        List<Double> allPrice = rubberDucksSubcategory.getAllDuckPrice();
        Assert.assertTrue(rubberDucksSubcategory.isPriceSortedASC(allPrice), "not sorted by price");
    }
}
