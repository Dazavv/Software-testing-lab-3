package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompanyPage extends BasePage {
    private final By companySectionButton = By.xpath("//button[@class='common-section-nav__button common-section-nav-button']");
    private final By companyManagement = By.xpath("//a[@href='/company/management' and @class='common-section-nav-links__link']");
    private final By companyQuality = By.xpath("//a[@href='/quality' and @class='common-section-nav-links__link']");
    private final By companyFacts = By.xpath("//a[@href='/company/facts' and @class='common-section-nav-links__link']");
    private final By companyDevelopment = By.xpath("//a[@href='/company/development' and @class='common-section-nav-links__link']");
    private final By companyFranchising = By.xpath("//a[@href='/company/franchising' and @class='common-section-nav-links__link']");
    private final By companyValues = By.xpath("//a[@href='/company/values' and @class='common-section-nav-links__link']");
    private final By companySemyavmeste = By.xpath("//a[@href='/company/semyavmeste' and @class='common-section-nav-links__link']");
    private final By companySustainability = By.xpath("//a[@href='/sustainability' and @class='common-section-nav-links__link']");
    private final By companyEcoDay = By.xpath("//a[@href='/ecoday' and @class='common-section-nav-links__link']");
    private final By companyMedia = By.xpath("//a[@href='/company/media' and @class='common-section-nav-links__link']");

    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public void clickCompanySectionButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companySectionButton));
        scrollIntoView(button);
        clickElement(companySectionButton);
    }
    public void clickCompanySectionValuesButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyValues));
        scrollIntoView(button);
        clickElement(companyValues);
    }
    public void clickCompanySectionManagementButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyManagement));
        scrollIntoView(button);
        clickElement(companyManagement);
    }
    public void clickCompanySectionQualityButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyQuality));
        scrollIntoView(button);
        clickElement(companyQuality);
    }
    public void clickCompanySectionFactsButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyFacts));
        scrollIntoView(button);
        clickElement(companyFacts);
    }
    public void clickCompanySectionDevelopmentButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyDevelopment));
        scrollIntoView(button);
        clickElement(companyDevelopment);
    }
    public void clickCompanySectionFranchisingButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyFranchising));
        scrollIntoView(button);
        clickElement(companyFranchising);
    }
    public void clickCompanySectionSemyavmesteButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companySemyavmeste));
        scrollIntoView(button);
        clickElement(companySemyavmeste);
    }
    public void clickCompanySectionSustainabilityButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companySustainability));
        scrollIntoView(button);
        clickElement(companySustainability);
    }
    public void clickCompanySectionEcoDayButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyEcoDay));
        scrollIntoView(button);
        clickElement(companyEcoDay);
    }
    public void clickCompanySectionMediaButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(companyMedia));
        scrollIntoView(button);
        clickElement(companyMedia);
    }
}
