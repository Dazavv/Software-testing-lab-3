package org.example.pages.mainPageComponents;

import org.example.base.BaseComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailComponent extends BaseComponent {
    private final By subscribeEmailInput = By.xpath("//input[contains(@class, 'field-subscribe-newsletter__input') and @placeholder='Введите адрес эл. почты']");
    private final By subscribeButton = By.xpath("//button[contains(@class, 'field-subscribe-newsletter__confirm-btn')]");
    private final By subscribeErrorMessage = By.xpath("//div[contains(@class, 'field-subscribe-newsletter__error')]");
    private final By subscribeSuccessMessage = By.xpath("//div[contains(@class, 'header-subscribe-success')]");

    public EmailComponent(WebDriver driver) {
        super(driver);
    }
    public void subscribeToNewsletter(String email) {
        WebElement inputField = findElement(subscribeEmailInput);
        scrollIntoView(inputField);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                inputField, email
        );

        clickElement(subscribeButton);
    }

    public boolean isSubscriptionSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeSuccessMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isSubscriptionError() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeErrorMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
