package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppPage extends BasePage {
    private final By ruStoreLink = By.xpath("//a[@href='https://www.rustore.ru/catalog/app/com.apegroup.mcdonaldsrussia']");
    private final By appStoreLink = By.xpath("//a[@href='https://apps.apple.com/RU/app/id896111038']");
    private final By googlePlayLink = By.xpath("//a[@href='https://play.google.com/store/apps/details?id=com.apegroup.mcdonaldsrussia']");
    private final By appGalleryLink = By.xpath("//a[@href='https://appgallery.huawei.com/#/app/C102465481']");

    public AppPage(WebDriver driver) {
        super(driver);
    }
    public WebElement googlePlayLink() {
        return findElement(googlePlayLink);
    }
    public WebElement  ruStoreLink() {
        return findElement(ruStoreLink);
    }
    public WebElement  appGalleryLink() {
        return findElement(appGalleryLink);
    }
    public WebElement  appStoreLink() {
        return findElement(appStoreLink);
    }
}
