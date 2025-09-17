import org.example.pages.BigFestPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigFestTest extends BaseTest {
    @Test
    void testBigFestLogo() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            BigFestPage bigFestPage = mainPage.getHeader().toBigFestPage();

            WebElement bigFestLogo = bigFestPage.getBigFestLogo();

            assertTrue(bigFestLogo.isDisplayed());
        });
    }

    @Test
    void testBigFestCarousel() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            BigFestPage bigFestPage = mainPage.getHeader().toBigFestPage();

            WebElement bigFestCarousel = bigFestPage.getBigFestCarousel();

            assertTrue(bigFestCarousel.isDisplayed());
        });
    }

    @Test
    void testBigFestPromoMorn() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            BigFestPage bigFestPage = mainPage.getHeader().toBigFestPage();

            WebElement bigFestPromoMorn = bigFestPage.getBigFestPromoMorn();

            assertTrue(bigFestPromoMorn.isDisplayed());
        });
    }

    @Test
    void testBigFestPromoDay() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            BigFestPage bigFestPage = mainPage.getHeader().toBigFestPage();

            WebElement bigFestPromoDay = bigFestPage.getBigFestPromoDay();

            assertTrue(bigFestPromoDay.isDisplayed());
        });
    }
}
