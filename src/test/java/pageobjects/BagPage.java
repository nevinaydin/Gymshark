package pageobjects;

import org.openqa.selenium.By;

import static utils.SeleniumCommands.getCommands;

public class BagPage {

  private static final By BAG_PAGE = By.cssSelector("[data-locator-id='miniBag-component']");
  private static final By BAG_ITEM = By.cssSelector("[data-locator-id='miniBag-miniBagItem-39654522814667-read']");

  public BagPage() {
    getCommands().waitForAndGetVisibleElementLocated(BAG_PAGE);
  }

  public String getBagItem() {

  }
}
