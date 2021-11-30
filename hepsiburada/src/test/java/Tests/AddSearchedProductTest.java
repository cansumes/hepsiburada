package Tests;

import Pages.homePage;
import Pages.productDetails;
import Pages.shoppingCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class AddSearchedProductTest {

    WebDriver driver = null;
    homePage search;
    productDetails addToBasket;
    shoppingCart checkBasket;

    @Given("user is on homepage")
    public void user_is_on_homepage() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("http://www.hepsiburada.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @And("^user makes a search for a (.*)$")
    public void user_makes_a_search_for_a_product(String product) {

        search = new homePage(driver);

        search.clickSearchBar();
        search.enterProductName(product);
        search.clickSearchButton();
    }

    @And("user clicks on a search result")
    public void user_clicks_on_a_search_result() {
        search.clickFirstSearchResult();
    }

    @And("user adds the product from the first supplier to the basket")
    public void user_adds_the_product_from_the_first_supplier_to_the_basket() throws InterruptedException {
        addToBasket = new productDetails(driver);

        addToBasket.switchSubTab();
        addToBasket.addToBasketFirstMerchant();
        Thread.sleep(5000);
        addToBasket.verifyAndCloseBasketPopup();

    }

    @And("user adds the product from the second supplier to the basket")
    public void user_adds_the_product_from_the_second_supplier_to_the_basket() throws InterruptedException {
        addToBasket = new productDetails(driver);
        addToBasket.scrollDownToMerchantList();
        addToBasket.addToBasketSecondMerchant();
        Thread.sleep(5000);
        addToBasket.verifyAndCloseBasketPopup();
    }

    @When("user navigates to the basket")
    public void user_navigates_to_the_basket() {
        addToBasket = new productDetails(driver);
        addToBasket.scrollUpToShoppingCart();
        addToBasket.clickShoppingCart();
    }

    @Then("user sees two products in the basket from selected suppliers")
    public void user_sees_two_products_in_the_basket_from_selected_suppliers(){
        checkBasket = new shoppingCart(driver);

        checkBasket.verifyItemCountInBasket();
        checkBasket.verifyMerchantNameDifference();

        driver.close();
        driver.quit();
    }
}
