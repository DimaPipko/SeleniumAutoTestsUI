
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    //Webdriver advanced p2 HW
    @Test
    public void transitionToSubcategoryTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksMenuItem = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-1']"));
        WebElement RDSubcategoryItem = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-2']"));
        Actions action = new Actions(driver);
        action.moveToElement(rubberDucksMenuItem).moveToElement(RDSubcategoryItem).click(RDSubcategoryItem).perform();
        Assert.assertTrue((driver.findElement(By.xpath("//div[@id='breadcrumbs-wrapper']//li[contains(text(),'Subcategory')]"))).isDisplayed());
        driver.close();
    }

    @Test
    public void sortingByPriceTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksMenuItem = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-1']"));
        WebElement RDSubcategoryItem = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-2']"));
        Actions action = new Actions(driver);
        action.moveToElement(rubberDucksMenuItem).moveToElement(RDSubcategoryItem).click(RDSubcategoryItem).perform();
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@id='box-category']//div[@class='price-wrapper']"));
        ArrayList<Double> doubles = new ArrayList<>();
        for (WebElement a : allPrices) {
            String s = a.getText();
            Pattern pattern = Pattern.compile("\\d*[.,]?\\d+(?=[^\\d\\n]*$)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String result = s.substring(matcher.start(), matcher.end());
                doubles.add(Double.valueOf(result));
            }
        }
        ArrayList<Double> sortedDouble = new ArrayList<>(doubles);
        Collections.sort(sortedDouble);
        Assert.assertEquals(doubles, sortedDouble);
        driver.close();
    }


    @Test
    public void sortingByNameTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksMenuItem = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-1']"));
        WebElement RDSubcategoryItem = driver.findElement(By.xpath("//div[@id='site-menu-wrapper']//li[@class='category-2']"));
        Actions action = new Actions(driver);
        action.moveToElement(rubberDucksMenuItem).moveToElement(RDSubcategoryItem).click(RDSubcategoryItem).perform();
        WebElement sortByNameButton = driver.findElement(By.xpath("//a[@class='button' and contains(text(),'Name')]"));
        sortByNameButton.click();
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='name']"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement a : allNames) {
            String s = a.getText();
            names.add(s);
        }
        ArrayList<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        Assert.assertEquals(names, sortedNames);
        driver.close();
    }
}
