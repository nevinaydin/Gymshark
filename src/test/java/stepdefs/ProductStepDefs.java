package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.BagPage;
import pageobjects.ProductDisplayPage;
import stepdefs.hooks.Hooks;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class ProductStepDefs {

  private final WebDriver driver;

  public ProductStepDefs(){
    this.driver = Hooks.getDriver();
  }

  @Given("the user is on a product page")
  public void theUserIsOnAProductPage() {
    driver.get("https://uk.gymshark.com/products/gymshark-speed-t-shirt-black-aw23");
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
//    assertThat(bagPage.)
  }
}
