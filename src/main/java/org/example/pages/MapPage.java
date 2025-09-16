package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MapPage extends BasePage {
    private final By mapContainer = By.xpath("//div[contains(@class,'restaurants-map__map')]");
    private final By restaurantMarkers = By.xpath("//img[contains(@class,'restaurant-pin')]");
    private final By restaurantInfoPopup = By.xpath("//div[contains(@class,'restaurant-balloon absolute')]");
    private final By routeButton = By.xpath("//button[contains(@class,'common-button restaurant-balloon-content__action')]");

    public MapPage(WebDriver driver) {
        super(driver);
    }
    public boolean isMapVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mapContainer)).isDisplayed();
    }
    public boolean hasRestaurantMarkers() {
        return !driver.findElements(restaurantMarkers).isEmpty();
    }
    public boolean hasRouteButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(routeButton)).isDisplayed();
    }
    public void clickFirstRestaurantMarker() {
        WebElement marker = wait.until(ExpectedConditions.elementToBeClickable(restaurantMarkers));
        marker.click();
    }
    public boolean isRestaurantInfoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantInfoPopup)).isDisplayed();
    }
}
