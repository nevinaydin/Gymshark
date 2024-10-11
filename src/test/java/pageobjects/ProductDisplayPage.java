package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.SeleniumCommands.getCommands;


public class ProductDisplayPage {

    private static final By PRODUCT_DISPLAY_PAGE = By.cssSelector("[data-locator-id='pdp-page']");
    private static final By SIZE_SMALL_BUTTON = By.cssSelector("[data-locator-id='pdp-size-s-select']");
    private static final By ADD_TO_BAG_BUTTON = By.cssSelector("[data-locator-id='pdp-addToBag-submit']");

    //private static final By QTY_DROPDOWN = By.cssSelector("[data-locator-id='miniBag-quantityDropdown-39654522814667-select']");
    private static final By QTY_DROPDOWN = By.xpath("//select[@aria-label='quantity selector']");
    // private static final By QTY_DROPDOWN = By.xpath("//*[@class='icon-delete']/../../../..//select");
    private static final By REMOVE_PRODUCT = By.xpath("//*[contains(@data-locator-id,'miniBag-remove')]");
    private static final By QUANTITY_DROPDOWN_CONTAINER = By.className("qty-selector_dropdown__R7OIE");

    private static final By DELETE_BUTTON = By.cssSelector("button[aria-label='remove from bag']");
    private static final By REMOVED_ITEM_MESSAGE = By.xpath("//*[text()='You removed an item from your bag.']");
    private static final By EMPTY_BAG_MESSAGE = By.xpath("//h2[text()='Your bag is empty']");


    public ProductDisplayPage() {
        getCommands().waitForAndGetVisibleElementLocated(PRODUCT_DISPLAY_PAGE);
    }

    public ProductDisplayPage selectSmallSize() {
        getCommands().waitForAndClickOnElementLocated(SIZE_SMALL_BUTTON);
        return this;
    }

    public ProductDisplayPage selectAddToBag() {
        getCommands().waitForAndClickOnElementLocated(ADD_TO_BAG_BUTTON);
        getCommands().waitForAndGetVisibleElementLocated(ADD_TO_BAG_BUTTON);
        return this;
    }

    public ProductDisplayPage selectDropDownByValue(String value) {
        //getCommands().selectDropDown(QTY_DROPDOWN, Integer.parseInt(value));
        getCommands().selectDropDown(QTY_DROPDOWN, value);
        return this;
    }

    public ProductDisplayPage selectQuantityDropdown(String quantity) {
        getCommands().waitForAndGetAllVisibleElementsLocated(REMOVE_PRODUCT);
        getCommands().waitForAndClickOnElementLocated(QUANTITY_DROPDOWN_CONTAINER);
        By xpath = By.xpath("//option[@value='" + quantity + "']");
        getCommands().waitForAndClickOnElementLocated(xpath);
        return this;
    }

    public String getQuantityDropdownValue(String quantity) {
        getCommands().waitForAndGetAllVisibleElementsLocated(QUANTITY_DROPDOWN_CONTAINER);
        By xpath = By.xpath("//option[@value='" + quantity + "']");
        WebElement qty = getCommands().waitForAndGetVisibleElementLocated(xpath);
        String actualQuantity = qty.getText();
       // System.out.println(actualQuantity);
        return actualQuantity;
    }

    public ProductDisplayPage deleteItem() {
        getCommands().waitForAndClickOnElementLocated(DELETE_BUTTON);
        return this;
    }

    public String getDeletedProductMessage() {
        return getCommands().getTextFromElement(getCommands().waitForAndGetVisibleElementLocated(REMOVED_ITEM_MESSAGE));
    }
}