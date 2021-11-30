package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

    WebDriver driver;

    private By searchBar = By.id("SearchBoxOld");
    private By searchBarTexField = By.cssSelector("input.desktopOldAutosuggestTheme-input");
    private By searchButton= By.cssSelector("div.SearchBoxOld-buttonContainer");
    private By firstSearchResult = By.id("i0");

    public homePage(WebDriver driver){
    this.driver = driver;
    }

    public void clickSearchBar(){
        driver.findElement(searchBar).click();
    }

    public void enterProductName(String product){
        driver.findElement(searchBarTexField).sendKeys(product);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

    public void clickFirstSearchResult(){
        driver.findElement(firstSearchResult).click();
    }
}
