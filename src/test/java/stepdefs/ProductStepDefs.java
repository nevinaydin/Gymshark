package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageobjects.BagPage;
import pageobjects.ProductDisplayPage;
import stepdefs.hooks.Hooks;
import utils.SeleniumCommands;

import static utils.SeleniumCommands.getCommands;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductStepDefs {

    private final WebDriver driver;
    private Long productId;

    public ProductStepDefs() {
        this.driver = Hooks.getDriver();
    }

    @Given("the user is on a product page")
    public void theUserIsOnAProductPage() {
        driver.get("https://uk.gymshark.com/products/gymshark-speed-t-shirt-black-aw23");
        productId = 39654522814667L;
        new ProductDisplayPage();
    }

    @When("adding the product to the Bag")
    public void addingTheProductToTheBag() {
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.selectSmallSize();
        productDisplayPage.selectAddToBag();
    }

    @Then("the product should appear in the Bag")
    public void theProductShouldAppearInTheBag() {
        BagPage bagPage = new BagPage();
        List<Long> variantIds = bagPage.getVariantIdsInBag();
        assertThat(variantIds).as("Expected product is in Bag").contains(productId);
    }

    @When("the user remove a product")
    public void theUserRemoveAProduct() {
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.deleteItem();
    }

    @Then("the product should be removed from the bag")
    public void theProductShouldBeRemovedFromTheBag() {
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        System.out.println("productDisplayPage.getDeletedProductMessage() = " + productDisplayPage.getDeletedProductMessage());
        assertThat(productDisplayPage.getDeletedProductMessage())
                .as("Removed Element Message")
                .isEqualTo("You removed an item from your bag.");
    }

    String expectedQuantityValue;
    String actualQuantityValue;

    @When("the user change the quantity to {string}")
    public void theUserChangeTheQuantityTo(String valueQuantity) throws InterruptedException {
        /*
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        expectedQuantityValue = valueQuantity;
        actualQuantityValue=productDisplayPage.selectDropDownByValue(valueQuantity);
        productDisplayPage.selectDropDownByValue(valueQuantity);
        System.out.println("expectedQuantityValue = " + expectedQuantityValue);
        System.out.println("actualQuantityValue = " + actualQuantityValue);
         */
        /*ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        WebElement dropDown = driver.findElement(By.cssSelector("[aria-label='quantity selector']"));
        Select select = new Select(dropDown);
        select.selectByValue(valueQuantity);
        expectedQuantityValue = valueQuantity;
        actualQuantityValue=select.getFirstSelectedOption().getText();*/
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.selectDropDownByValue(valueQuantity);



    }

    @Then("product quantity should be increased")
    public void productQuantityShouldBeIncreased() {
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        assertThat(actualQuantityValue).as("Increased Quantity Value").isEqualTo(expectedQuantityValue);
    }

    @When("the user remove the quantity")
    public void theUserRemoveTheQuantity() {
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        productDisplayPage.deleteItem();
    }

    @Then("product quantity should be removed from the bag")
    public void productQuantityShouldBeRemovedFromTheBag() {
        ProductDisplayPage productDisplayPage = new ProductDisplayPage();
        System.out.println("productDisplayPage.getDeletedProductMessage() = " + productDisplayPage.getDeletedProductMessage());
        assertThat(productDisplayPage.getDeletedProductMessage())
                .as("Removed Element Message")
                .isEqualTo("You removed an item from your bag.");
    }
}
