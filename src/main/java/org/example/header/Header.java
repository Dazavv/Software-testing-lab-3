package org.example.header;

import org.example.base.BasePage;
import org.example.header.headerComponents.CityComponent;
import org.example.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Header extends BasePage {
    private final By menuPage = By.xpath("//a[contains(@href, 'menu')]//p[contains(text(), 'Меню')]");
    private final By bigFestPage = By.xpath("//a[@href='/bigfest']//p[contains(text(), 'Бигфест')]");
    private final By bonusPage = By.xpath("//a[@href='/bonus']//p[contains(text(), 'Мой Бонус')]");
    private final By appPage = By.xpath("//a[@href='/app-benefits']//p[contains(text(), 'Приложение')]");
    private final By mapRestaurantsPage = By.xpath("//a[contains(@href, 'restaurants/map')]//p[contains(text(), 'Мы на карте')]");
    private final By newsPage = By.xpath("//a[contains(@href, 'articles/news')]//p[contains(text(), 'Новости')]");
    private final By aboutUsPage = By.xpath("//a[contains(@href, 'company')]//p[contains(text(), 'О нас')]");
    private final CityComponent cityComponent;

    public Header(WebDriver driver) {
        super(driver);
        this.cityComponent = new CityComponent(driver);
    }
    public MenuPage toMenuPage() {
        clickElement(menuPage);
        return new MenuPage(driver);
    }
    public BigFestPage toBigFestPage() {
        clickElement(bigFestPage);
        return new BigFestPage(driver);
    }
    public BonusPage toBonusPage() {
        clickElement(bonusPage);
        return new BonusPage(driver);

    }
    public MapPage toRestaurantsPage() {
        clickElement(mapRestaurantsPage);
        return new MapPage(driver);
    }
    public NewsPage toNewsPage() {
        clickElement(newsPage);
        return new NewsPage(driver);
    }
    public CompanyPage toCompanyPage() {
        clickElement(aboutUsPage);
        return new CompanyPage(driver);
    }
    public AppPage toAppPage() {
        clickElement(appPage);
        return new AppPage(driver);
    }
    public CityComponent city() {
        return cityComponent;
    }
}
