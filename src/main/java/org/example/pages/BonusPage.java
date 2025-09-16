package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BonusPage extends BasePage {
    private final By bonusSteps = By.xpath("//div[@class='bonus-steps__container page-bonus__section']");
    private final By bonusProductsQA = By.xpath("//div[@class='bonus-questions__container page-bonus__section']");
    private final By bonusMoreProductsButton = By.xpath("//button[@class='common-button bonus-products__more bonus-btn common-button--default']");
    private final By bonusLessProductsButton = By.xpath("//button[@class='common-button bonus-products__more bonus-btn --hide common-button--default']");
    private final By bonusProduct = By.xpath("//div[@class='bonus-products__item']");

    public BonusPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getBonusSteps() {
        return findElement(bonusSteps);
    }
    public WebElement getBonusQA() {
        return findElement(bonusProductsQA);
    }

    public void clickMoreProductsButton() {
        WebElement moreButton = wait.until(ExpectedConditions.elementToBeClickable(bonusMoreProductsButton));
        scrollIntoView(moreButton);
        clickElement(bonusMoreProductsButton);

    }
    public void clickLessProductsButton() {
        WebElement lessButton = wait.until(ExpectedConditions.presenceOfElementLocated(bonusMoreProductsButton));
        scrollIntoView(lessButton);
        clickElement(bonusLessProductsButton);
    }

    public List<WebElement> getBonusProducts() {
        return findElements(bonusProduct);
    }
}
