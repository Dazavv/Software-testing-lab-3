package org.example.header;

import org.example.base.BasePage;
import org.example.header.headerComponents.CityComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Header extends BasePage {
    private final By menuPage = By.xpath("//a[contains(@href, 'menu')]");
    private final By bigFestPage = By.xpath("//a[contains(@href, 'bigfest')]");
    private final By bonusPage = By.xpath("//a[contains(@href, 'bonus')]");
    private final By mapRestaurantsPage = By.xpath("//a[contains(@href, 'restaurants/map')]");
    private final By newsPage = By.xpath("//a[contains(@href, 'articles/news')]");
    private final By aboutUsPage = By.xpath("//a[contains(@href, 'company')]");
    private final CityComponent cityComponent;

    public Header(WebDriver driver) {
        super(driver);
        this.cityComponent = new CityComponent(driver);
    }


    public void toMenuPage() { clickElement(menuPage); }
    public void toBigFestPage() { clickElement(bigFestPage); }
    public void toBonusPage() { clickElement(bonusPage); }
    public void toRestaurantsPage() { clickElement(mapRestaurantsPage); }
    public void toNewsPage() { clickElement(newsPage); }
    public void toCompanyPage() { clickElement(aboutUsPage); }

    public CityComponent city() {
        return cityComponent;
    }
}
