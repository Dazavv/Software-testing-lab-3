package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyPage extends BasePage {
    private final By companySectionButton = By.xpath("//button[@class='common-section-nav__button common-section-nav-button']");
    private final By companySection = By.xpath("//div[@class='common-section-nav common-section-nav--open common-section-nav-wrapper__btn']");

    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public void clickCompanySectionButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companySectionButton));
        scrollIntoView(button);
        clickElement(companySectionButton);
    }

    public WebElement getCompanySection() {
        return findElement(companySection);
    }
}
