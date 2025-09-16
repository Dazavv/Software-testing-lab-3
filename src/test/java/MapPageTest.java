import org.example.pages.BonusPage;
import org.example.pages.MainPage;
import org.example.pages.MapPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapPageTest extends BaseTest {
    @Test
    void testGetRestaurantsMapPage() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            MapPage mapPage = mainPage.getHeader().toRestaurantsPage();

            assertTrue(mapPage.isMapVisible());
            assertTrue(mapPage.hasRestaurantMarkers());
        });
    }

    @Test
    void testSeeRestaurantInfoOnMap() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            MapPage mapPage = mainPage.getHeader().toRestaurantsPage();

            mapPage.clickFirstRestaurantMarker();

            assertTrue(mapPage.isRestaurantInfoVisible());
            assertTrue(mapPage.hasRouteButton());
        });
    }
}
