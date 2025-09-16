import org.example.pages.AppPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppPageTest extends BaseTest {
    @Test
    void testAppPageToGooglePlay() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            AppPage appPage = mainPage.getHeader().toAppPage();

            WebElement googlePlay = appPage.googlePlayLink();

            assertTrue(googlePlay.isDisplayed());
            assertTrue(googlePlay.isEnabled());
        });
    }

    @Test
    void testAppPageToAppGallery() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            AppPage appPage = mainPage.getHeader().toAppPage();

            WebElement appGalleryLink = appPage.appGalleryLink();

            assertTrue(appGalleryLink.isDisplayed());
            assertTrue(appGalleryLink.isEnabled());
        });
    }

    @Test
    void testAppPageToAppStore() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            AppPage appPage = mainPage.getHeader().toAppPage();

            WebElement appStoreLink = appPage.appStoreLink();

            assertTrue(appStoreLink.isDisplayed());
            assertTrue(appStoreLink.isEnabled());
        });
    }

    @Test
    void testAppPageToRuStore() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            AppPage appPage = mainPage.getHeader().toAppPage();

            WebElement ruStoreLink = appPage.ruStoreLink();

            assertTrue(ruStoreLink.isDisplayed());
            assertTrue(ruStoreLink.isEnabled());
        });
    }
}
