import org.example.pages.AppPage;
import org.example.pages.BonusPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends BaseTest {

    @Test
    void testChangeCity() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            String newCity = "Санкт-Петербург";
            mainPage.getHeader().city().selectCity(newCity);

            String selectedCity = mainPage.getHeader().city().getSelectedCity();
            assertEquals(newCity, selectedCity);
        });
    }

    @Test
    void testChangeCity2() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            String newCity = "Москва";
            mainPage.getHeader().city().selectCity(newCity);

            String selectedCity = mainPage.getHeader().city().getSelectedCity();
            assertEquals(newCity, selectedCity);
        });
    }

    @Test
    void testChangeCity3() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            String firstCity = "Санкт-Петербург";
            String secondCity = "Покров";

            mainPage.getHeader().city().selectCity(firstCity);
            assertEquals(firstCity, mainPage.getHeader().city().getSelectedCity());

            mainPage.getHeader().city().changeCity(secondCity);
            assertEquals(secondCity, mainPage.getHeader().city().getSelectedCity());
        });
    }

//    @Test
//    void testSuccessLetterSubscription() {
//        runOnAllBrowsers(driver -> {
//            driver.get(URL);
//            MainPage mainPage = new MainPage(driver);
//            String validEmail = "test@example.com";
//            mainPage.subscribe().subscribeToNewsletter(validEmail);
//            assertTrue(mainPage.subscribe().isSubscriptionSuccessful());
//        });
//    }
//
//    @Test
//    void testFailLetterSubscription() {
//        runOnAllBrowsers(driver -> {
//            driver.get(URL);
//            MainPage mainPage = new MainPage(driver);
//            String email = "test@";
//            mainPage.subscribe().subscribeToNewsletter(email);
//            assertTrue(mainPage.subscribe().isSubscriptionError());
//        });
//    }
//
//    @Test
//    void testEmptyLetterSubscription() {
//        runOnAllBrowsers(driver -> {
//            driver.get(URL);
//            MainPage mainPage = new MainPage(driver);
//            String email = "";
//            mainPage.subscribe().subscribeToNewsletter(email);
//            assertTrue(mainPage.subscribe().isSubscriptionError());
//        });
//    }


    @Test
    void testBonusPageNavigation() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.getHeader().toBonusPage();
            assertEquals("https://vkusnoitochka.ru/bonus", bonusPage.getCurrentUrl());
        });
    }

    @Test
    void testAppPageNavigation() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            AppPage appPage = mainPage.getHeader().toAppPage();
            assertEquals("https://vkusnoitochka.ru/app-benefits", appPage.getCurrentUrl());
        });
    }
}
