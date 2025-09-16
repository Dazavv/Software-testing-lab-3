package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsPage extends BasePage {
    private By newsItems = By.xpath("//div[contains(@class,'news-preview')]");
    private By newsTitle = By.xpath("//div[contains(@class,'news-preview')]//h2");
    private By newsDate = By.xpath("//div[contains(@class,'news-preview')]//time");
    private By newsDetailsButton = By.xpath("//a[contains(@class,'common-button news-preview__btn')]");

    public NewsPage(WebDriver driver) {
        super(driver);
    }
    public boolean hasNewsList() {
        return !driver.findElements(newsItems).isEmpty();
    }

    public boolean newsHaveTitles() {
        return driver.findElements(newsTitle).stream().allMatch(WebElement::isDisplayed);
    }

    public boolean newsHaveDates() {
        return driver.findElements(newsDate).stream().allMatch(WebElement::isDisplayed);
    }

    public void clickFirstNews() {
        driver.findElements(newsItems).get(0).click();
    }

    public boolean isNewsDetailVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newsDetailsButton)).isDisplayed();
    }

}
