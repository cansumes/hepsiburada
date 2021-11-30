package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class shoppingCart {

    WebDriver driver;
    private By basketView = By.className("basket_container_1VEW_");
    private By basketItemCount = By.id("basket-item-count");
    private By merchantNames = By.className("merchant_name_1NA4w");

    public shoppingCart(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilShoppingCartPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(basketView));
    }

    public void verifyItemCountInBasket(){
        waitUntilShoppingCartPage();
        String itemCount = driver.findElement(basketItemCount).getText();
        if(itemCount.equals("2")) {
            System.out.println("Sepette iki adet urun vardir.");
        }
    }

    public void verifyMerchantNameDifference(){
        List<WebElement> merchants = driver.findElements(merchantNames);
        String firstMerchantName = merchants.get(0).getText();
        String secondMerchantName = merchants.get(1).getText();
        if (!Objects.equals(firstMerchantName, secondMerchantName)){
            System.out.println("Sepette iki farkli saticidan urun bulunmaktadir");
        }
        else {
            System.out.println("Test basarisiz");
        }
    }
}
