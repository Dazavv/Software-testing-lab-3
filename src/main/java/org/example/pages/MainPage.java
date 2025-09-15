package org.example.pages;

import org.example.base.BasePage;
import org.example.header.Header;
import org.example.pages.mainPageComponents.EmailComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private Header header;
    private EmailComponent emailComponent;
    private By vacanciesLink = By.xpath("//a[contains(text(), 'Работа у нас')]");
    private By charityLink = By.xpath("//a[contains(text(), 'Благотворительность')]");
    private By feedbackPageButton = By.xpath("//a[@href='/feedback']");
    private By bonusPageButton = By.xpath("//a[@href='/bonus']");
    private By appPageButton = By.xpath("//span[contains(@class, 'layout-header-navigation-item__element')]//p[contains(text(), 'Приложение')]");
    private By cookieButton = By.xpath("//button[contains(@class, 'layout-layer-notifications-item__close')]");

    public MainPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.emailComponent = new EmailComponent(driver);
    }

    public EmailComponent subscribe() {
        return emailComponent;
    }
    public Header getHeader() {
        return header;
    }

    public void clickVacanciesLink() {
        clickElement(vacanciesLink);
    }

    public void clickCharityLink() {
        clickElement(charityLink);
    }

    public FeedbackPage clickFeedbackLink() {
//        closeCookieNotification();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackPageButton));
//        wait.until(ExpectedConditions.elementToBeClickable(feedbackPageButton));
//        WebElement feedback = driver.findElement(feedbackPageButton);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", feedback);
        clickElement(feedbackPageButton);
        return new FeedbackPage(driver);
    }

    public BonusPage clickBonusLink() {
        clickElement(bonusPageButton);
        return new BonusPage(driver);
    }

    public AppPage clickAppLink() {
        clickElement(appPageButton);
        return new AppPage(driver);
    }
    public void closeCookieNotification() {
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.presenceOfElementLocated(cookieButton));
//            scrollIntoView(closeBtn);
            wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
            wait.until(ExpectedConditions.invisibilityOf(closeBtn));
        } catch (Exception e) {
            // баннер не появился или уже пропал — ничего страшного
        }
    }

}
