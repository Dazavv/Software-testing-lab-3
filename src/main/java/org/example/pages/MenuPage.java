package org.example.pages;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuPage extends BasePage {
    private final By restaurantItem = By.xpath("//div[contains(@class, 'menu-restaurant-modal-item')]");
    private final By productCard = By.xpath("//div[contains(@class, 'modal-abstraction__body')]");
    private final By productImg = By.xpath("//div[contains(@class, 'product-top__img')]//img");
    private final By productInfo= By.xpath("//div[contains(@class, 'product-settings__text')]");
    private final By productItem = By.xpath("//img[contains(@class, 'common-image__img')]");
    private final By product = By.xpath("//a[contains(@class, 'product-card')]");
    private final By restaurantChooseButton = By.xpath("//div[contains(@class, 'restaurant-choose-banner')]//button");
    private final By restaurantButton = By.xpath("//button[contains(@class, 'common-button menu-restaurant-modal-btn')]");
    private final By restaurantChooseContainer = By.xpath("//div[contains(@class, 'modal-abstraction__wrap')]");
    private final By restaurantModalAddress = By.xpath(".//span[contains(@class, 'menu-restaurant-modal-item__address')]");
    private final By restaurantBannerAddress = By.xpath("//div[@id='banner-restaurant-content']//span[@class='text-black']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProducts() {
        return findElements(product);
    }
    public WebElement getProductCard() {
        return findElement(productCard);
    }

    public WebElement getProductImg() {
        return findElement(productImg);
    }

    public WebElement getProductInfo() {
        return findElement(productInfo);
    }

    public String getProductTitle(WebElement product) {
        return product.findElement(By.xpath(".//span[contains(@class, 'product-card__title')]")).getText();
    }

    public String getProductWeight(WebElement product) {
        return product.findElement(By.xpath(".//div[contains(@class, 'product-card__footer')]//span")).getText();
    }

    public String getProductPrice(WebElement product) {
        return product.findElement(By.xpath(".//div[contains(@class, 'product-card__footer')]//b")).getText();
    }
    public String getAddress() {
        return findElement(restaurantBannerAddress).getText();
    }

    // Адрес ресторана из модалки (у конкретного элемента списка)
    public String getModalRestaurantAddress(WebElement restaurantItem) {
        return restaurantItem.findElement(By.xpath(".//span[contains(@class, 'menu-restaurant-modal-item__address')]")).getText();
    }

    public void clickRestaurantChooseButton() {
        clickElement(restaurantChooseButton);
    }

    public void clickRestaurantButton() {

        clickElement(restaurantButton);
    }

    public void clickProductItem() {
        clickElement(productItem);
    }

    public List<WebElement> getRestaurantItems() {
        return findElements(restaurantItem);
    }

    public WebElement getRestaurantChooseContainer() {
        return findElement(restaurantChooseContainer);
    }
}
