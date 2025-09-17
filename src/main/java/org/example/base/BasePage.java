package org.example.base;
import org.openqa.selenium.*;

public abstract class BasePage extends BaseUiElement{
    public BasePage(WebDriver driver) {
        super(driver);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void open(String url) {
        driver.get(url);
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
