package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BigFestPage extends BasePage {
    private final By bigFestLogo = By.cssSelector("svg.bigfest-pleaser-main-section-logo");
    private final By bigFestCarousel = By.cssSelector(".bigfest-pleaser-main-section-slider"); // блок с картинками
    private final By bigFestPromoMorn = By.xpath("//div[@class='common-switch bigfest-switch']//span[contains(text(), 'Акции утра')]");
    private final By bigFestPromoDay = By.xpath("//div[@class='common-switch bigfest-switch']//span[contains(text(), 'Акции дня')]");

    public BigFestPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBigFestLogo() {
        return findElement(bigFestLogo);
    }
    public WebElement getBigFestCarousel() {
        return findElement(bigFestCarousel);
    }

    public WebElement getBigFestPromoMorn() {
        return findElement(bigFestPromoMorn);
    }

    public WebElement getBigFestPromoDay() {
        return findElement(bigFestPromoDay);
    }



}
