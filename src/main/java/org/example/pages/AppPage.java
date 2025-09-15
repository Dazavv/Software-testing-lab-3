package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage extends BasePage {
    // Локаторы основных элементов страницы
    private final By pageTitle = By.xpath("//h1[contains(text(),'Приложение')]");
    private final By advantagesSection = By.xpath("//section[contains(@class,'app-advantages')]");
    private final By rucstoreLink = By.xpath("//a[contains(@href,'ructore')]");
    private final By appStoreLink = By.xpath("//a[contains(@href,'apple.com')]");
    private final By googlePlayLink = By.xpath("//a[contains(@href,'play.google.com')]");
    private final By appGalleryLink = By.xpath("//a[contains(@href,'appgallery')]");

    public AppPage(WebDriver driver) {
        super(driver);
    }

    // Метод для проверки, что открыта именно страница приложения
    public boolean isPageOpened() {
        return isElementVisible(pageTitle);
    }

    // Проверка, что отображены преимущества приложения
    public boolean areAdvantagesVisible() {
        return isElementVisible(advantagesSection);
    }

    // Методы для проверки наличия ссылок на магазины
    public boolean isRuStoreLinkVisible() {
        return isElementVisible(rucstoreLink);
    }

    public boolean isAppStoreLinkVisible() {
        return isElementVisible(appStoreLink);
    }

    public boolean isGooglePlayLinkVisible() {
        return isElementVisible(googlePlayLink);
    }

    public boolean isAppGalleryLinkVisible() {
        return isElementVisible(appGalleryLink);
    }

    // Можно добавить метод для перехода по ссылке, если нужно
    public void clickGooglePlayLink() {
        clickElement(googlePlayLink);
    }

}
