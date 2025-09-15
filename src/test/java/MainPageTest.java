import org.example.pages.AppPage;
import org.example.pages.BonusPage;
import org.example.pages.FeedbackPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest extends BaseTest {

    private final String charityPageLink = "https://rabotaitochka.ru/";

    @Test
    void testChangeCity() {
        runOnAllBrowsers(driver -> {
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
            MainPage mainPage = new MainPage(driver);
            String firstCity = "Санкт-Петербург";
            String secondCity = "Покров";

            mainPage.getHeader().city().selectCity(firstCity);
            assertEquals(firstCity, mainPage.getHeader().city().getSelectedCity());

            mainPage.getHeader().city().changeCity(secondCity);
            assertEquals(secondCity, mainPage.getHeader().city().getSelectedCity());
        });
    }

    @Test
    void testSuccessLetterSubscription() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            String validEmail = "test@example.com";
            mainPage.subscribe().subscribeToNewsletter(validEmail);
            assertTrue(mainPage.subscribe().isSubscriptionSuccessful());
        });
    }

    @Test
    void testFailLetterSubscription() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            String email = "test@";
            mainPage.subscribe().subscribeToNewsletter(email);
            assertTrue(mainPage.subscribe().isSubscriptionError());
        });
    }

    @Test
    void testEmptyLetterSubscription() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            String email = "";
            mainPage.subscribe().subscribeToNewsletter(email);
            assertTrue(mainPage.subscribe().isSubscriptionError());
        });
    }

    @Test
    void testFeedbackPageNavigation() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            FeedbackPage feedbackPage = mainPage.clickFeedbackLink();
            assertEquals("https://vkusnoitochka.ru/feedback", feedbackPage.getCurrentUrl());
        });
    }

    @Test
    void testBonusPageNavigation() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.clickBonusLink();
            assertEquals("https://vkusnoitochka.ru/bonus", bonusPage.getCurrentUrl());
        });
    }

    @Test
    void testAppPageNavigation() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            AppPage appPage = mainPage.clickAppLink();
            assertEquals("https://vkusnoitochka.ru/app-benefits", appPage.getCurrentUrl());
        });
    }

    @Test
    void testVacanciesLink() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickVacanciesLink();
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains(charityPageLink));
        });
    }

    @Test
    void testCharityLink() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickCharityLink();
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("https://semyavmeste.org/"));
        });
    }
}
