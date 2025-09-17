import org.example.pages.MainPage;
import org.example.pages.MenuPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTests extends BaseTest {
    @Test
    void testViewMenu() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            MenuPage menuPage = mainPage.getHeader().toMenuPage();

            List<WebElement> products = menuPage.getProducts();

            assertFalse(products.isEmpty());

            WebElement firstProduct = menuPage.getProducts().get(0);
            String title = menuPage.getProductTitle(firstProduct);
            String weight = menuPage.getProductWeight(firstProduct);
            String price = menuPage.getProductPrice(firstProduct);

            assertAll(
                    () -> assertNotNull(title),
                    () -> assertNotNull(weight),
                    () -> assertNotNull(price)
            );
        });
    }

    @Test
    void testViewFirstProductDetails() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            MenuPage menuPage = mainPage.getHeader().toMenuPage();
            menuPage.clickProductItem();

            assertTrue(menuPage.getProductCard().isDisplayed());
            assertTrue(menuPage.getProductImg().isDisplayed());
            assertTrue(menuPage.getProductInfo().isDisplayed());
        });
    }
    @Test
    void testViewRestaurants() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            MenuPage menuPage = mainPage.getHeader().toMenuPage();
            menuPage.clickRestaurantChooseButton();

            assertTrue(menuPage.getRestaurantChooseContainer().isDisplayed());
        });
    }

    @Test
    void testViewRestaurantProducts() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            MenuPage menuPage = mainPage.getHeader().toMenuPage();
            menuPage.clickRestaurantChooseButton();
            menuPage.clickRestaurantButton();

            assertFalse(menuPage.getAddress().isEmpty());
        });
    }

}
