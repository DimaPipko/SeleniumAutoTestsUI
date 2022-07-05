package PO.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RubberDucksSubcategory extends BasePage {
    private By sortByNameBtn = By.xpath("//a[@class='button' and contains(text(),'Name')]");
    private By sortByPriceBtn = By.xpath("//a[@class='button' and contains(text(),'Name')]");
    private By sortByPopularityBtn;
    private By sortByDateBtn;
    private By breadcrumbsRubberDuck = By.xpath("//div[@id='breadcrumbs-wrapper']//li[contains(text(),'Subcategory')]");
    public By duckPrice = By.xpath("//div[@id='box-category']//div[@class='price-wrapper']");
    private WebDriver driver;

    public RubberDucksSubcategory(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSubcatecoryPageOpen() {
        LOG.debug("Checking is Subcategory open");
        return driver.findElement(breadcrumbsRubberDuck).isDisplayed();
    }

    public void clickSortingByNameBtn() {
        LOG.info("Click btnSortByName");
        driver.findElement(sortByNameBtn).click();
    }

    public List<String> getAllDuckName() {
        LOG.debug("get Duck names");
        List<WebElement> allNames= driver.findElements(By.xpath("//div[@class='name']"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement a : allNames) {
            String s = a.getText();
            names.add(s);
        }
        return names;
    }

    public boolean isDucksSortedByName(List<String> allDuck) {
        ArrayList<String> sortedNames = new ArrayList<>(allDuck);
        Collections.sort(sortedNames);
        return sortedNames.equals(allDuck);
    }

    public List<Double> getAllDuckPrice() {
        LOG.debug("getting duck prices");
        List<WebElement> allPriceElement = driver.findElements(duckPrice);
        ArrayList<Double> doubles = new ArrayList<>();
        for (WebElement a : allPriceElement) {
            String s = a.getText();
            Pattern pattern = Pattern.compile("\\d*[.,]?\\d+(?=[^\\d\\n]*$)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String result = s.substring(matcher.start(), matcher.end());
                doubles.add(Double.valueOf(result));
            }
        }
        return doubles;
    }
    public boolean isPriceSortedASC(List<Double> doubles){
        LOG.info("Checking is sorted ASC");
        ArrayList<Double> sortedDouble = new ArrayList<>(doubles);
        Collections.sort(sortedDouble);
        return sortedDouble.equals(doubles);
    }
}
