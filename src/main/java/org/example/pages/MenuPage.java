package org.example.pages;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MenuPage extends BasePage {
    private By categoryBurger = By.xpath("//a[contains(text(), 'Бургеры')]");
    private By firstProduct = By.xpath("(//div[contains(@class, 'product-card')])[1]");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

}
