package org.example.pages.mainPageComponents;

import org.example.base.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailComponent extends BaseComponent {
    private By subscribeEmailInput = By.xpath("//input[contains(@class, 'field-subscribe-newsletter__input') and @placeholder='Введите адрес эл. почты']");
    private By subscribeButton = By.xpath("//button[contains(@class, 'field-subscribe-newsletter__confirm-btn')]");
    private By subscribeErrorMessage = By.xpath("//div[contains(@class, 'field-subscribe-newsletter__error')]");
    private By subscribeSuccessMessage = By.xpath("//div[contains(@class, 'header-subscribe-success')]");

    public EmailComponent(WebDriver driver) {
        super(driver);
    }
    public void subscribeToNewsletter(String email) {
        WebElement inputField = driver.findElement(subscribeEmailInput);
        scrollIntoView(inputField);
        inputField.clear();
        inputField.sendKeys(email);
        driver.findElement(subscribeButton).click();
    }

    public boolean isSubscriptionSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeSuccessMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isSubscriptionError() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeErrorMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
