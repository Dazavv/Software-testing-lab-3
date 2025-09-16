package org.example.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseUiElement {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseUiElement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }

    protected void typeText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void scrollIntoView(WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center', inline: 'center'});",
                element
        );

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitUntilInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitUntilNumberOfElements(By locator, int count) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
    }

    protected void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
