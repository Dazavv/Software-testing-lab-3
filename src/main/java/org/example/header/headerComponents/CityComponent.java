package org.example.header.headerComponents;

import org.example.base.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CityComponent extends BaseComponent {
    private final By cityChanger = By.xpath("//button[contains(@class, 'layout-header-location-button')]");
    private final By cityNotificationConfirm = By.xpath("//div[contains(@class, 'layout-header-notifications-city-confirm-wrapper__notification')]");
    private final By cityNotificationConfirmMessage = By.xpath("//p[contains(@class, 'layout-layer-notifications-city-confirm__message')]");
    private final By selectedCityLabel = By.xpath("//button[contains(@class, 'layout-header-location-button')]//span[contains(@class, 'layout-header-navigation-item__element')]");
    private final By citySelector = By.xpath("//div[contains(@class, 'change-city-modal__container')]");
    private final By citySelectorList = By.xpath("//div[contains(@class, 'change-city-modal-list')]");
    private final By citySelectorSearch = By.xpath("//input[contains(@class, 'layout-header-search-input__input') and @placeholder='Твой город']");
    //    private By cityNotificationConfirm = By.cssSelector(".layout-layer-notifications-city-confirm");
    private final By cityNotificationYesButton = By.xpath("//button[contains(@class,'layout-layer-notifications-city-confirm-buttons__button')]//span[contains(text(),'Да, верно')]");
    private final By cityNotificationNoButton = By.xpath("//*[@id=\"vit\"]/div[2]/div[1]/div[1]/div/div/div/button[1]");

    public CityComponent(WebDriver driver) {
        super(driver);
    }

    public void changeCity(String cityName) {
        clickElement(cityChanger);
        changeCityViaModal(cityName);
    }
    public void handleCityNotification(String cityName) {
        if (isElementVisible(cityNotificationConfirm)) {
            String detectedCity = driver.findElement(cityNotificationConfirmMessage)
                    .findElement(By.tagName("span"))
                    .getText();
            if (detectedCity.equalsIgnoreCase(cityName)) {
                clickElement(cityNotificationYesButton);
            } else {
                clickElement(cityNotificationNoButton);
                changeCityViaModal(cityName);
            }
        }
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selectedCityLabel, cityName));
    }

    public void changeCityViaModal(String cityName) {
        if (!isElementVisible(citySelector)) {
            throw new IllegalStateException("Модальное окно выбора города не появилось");
        }

        typeText(citySelectorSearch, cityName);

        WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'change-city-modal-cities-group')]//li[contains(@class, 'change-city-modal-city') and text()='" + cityName + "']")));

        wait.until(ExpectedConditions.elementToBeClickable(cityOption));
        cityOption.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selectedCityLabel, cityName));
    }

    public void selectCity(String cityName) {
        handleCityNotification(cityName);
    }

    public String getSelectedCity() {
        return findElement(selectedCityLabel).findElement(By.tagName("span")).getText();
    }

}
