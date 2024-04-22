package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefs.hooks.Hooks;

import java.time.Duration;
import java.util.function.Function;

public class SeleniumCommands {

  private static final SeleniumCommands instance = new SeleniumCommands();

  public void waitForAndSendKeys(By selector, CharSequence... input) {
    waitForAndGetVisibleElementLocated(selector).sendKeys(input);
  }

  public void waitForAndClickOnElementLocated(By selector) {
    waitForElementToBeClickableLocated(selector).click();
  }

  public WebElement waitForAndGetVisibleElementLocated(By selector) {
    return until(ExpectedConditions.visibilityOfElementLocated(selector));
  }

  public WebElement waitForElementToBeClickableLocated(By selector) {
    return until(ExpectedConditions.elementToBeClickable(selector));
  }

  private WebDriverWait defaultWait() {
    return new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(30));
  }

  private <V> V until(Function<? super WebDriver, V> expectedCondition) {
    return defaultWait().until(expectedCondition);
  }

  public static SeleniumCommands getCommands() {
    return instance;
  }
}
