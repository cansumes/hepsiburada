package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class productDetails {

    WebDriver driver;

    private By buttonAddToBasketFirstMerchant = By.id("addToCart");
    private By buttonAddToBasketSecondMerchant = By.xpath("//table/tbody/tr[1]/td[3]/div/form/button");
    private By basketPopup = By.className("checkoutui-Modal-1k7QD");
    private By closeBasketPopup = By.className("checkoutui-Modal-2iZXl");
    private By shoppingCartButton = By.id("shoppingCart");
    //String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandler = null;

    public productDetails(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void addToBasketFirstMerchant(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToBasketFirstMerchant));
        driver.findElement(buttonAddToBasketFirstMerchant).click();
    }

    public void addToBasketSecondMerchant (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToBasketSecondMerchant));
        driver.findElement(buttonAddToBasketSecondMerchant).click();
    }

    public void switchSubTab(){

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }

    //driver.switchTo().window(parentWindowHandler);

    public void verifyProductInBasket() {
        boolean basketPopupVisibility = driver.findElement(basketPopup).isDisplayed();
        if (basketPopupVisibility == true) {
            System.out.println("Urun sepete eklenmistir.");
        }
        else {
            System.out.println("Urun sepete eklenememistir.");
        }
    }

    public void closeBasketPopup(){
        driver.findElement(closeBasketPopup).click();
    }

    public void scrollDownToMerchantList(){
        scrollToElement(driver.findElement(By.className("marketplace-list")));
    }

    public void verifyAndCloseBasketPopup(){
        switchSubTab();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        verifyProductInBasket();
        closeBasketPopup();
    }

    public void scrollUpToShoppingCart(){
        scrollToElement(driver.findElement(shoppingCartButton));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement element = driver.findElement(shoppingCartButton);
        //js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickShoppingCart(){
        driver.findElement(shoppingCartButton).click();
    }
}

