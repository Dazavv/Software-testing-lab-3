import org.example.pages.BonusPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BonusPageTest extends BaseTest {
    @Test
    void testGetBonusSteps() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.getHeader().toBonusPage();

            WebElement bonusSteps = bonusPage.getBonusSteps();

            assertTrue(bonusSteps.isDisplayed());
        });
    }

    @Test
    void testGetBonusQA() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.getHeader().toBonusPage();

            WebElement bonusQA = bonusPage.getBonusQA();

            assertTrue(bonusQA.isDisplayed());
        });
    }

    @Test
    void testGetBonusProducts() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.getHeader().toBonusPage();

            List<WebElement> bonusProducts = bonusPage.getBonusProducts();

            assertEquals(8, bonusProducts.size());
        });
    }

    @Test
    void testGetMoreBonusProducts() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.getHeader().toBonusPage();

            bonusPage.clickMoreProductsButton();

            List<WebElement> bonusProducts = bonusPage.getBonusProducts();

            assertEquals(12, bonusProducts.size());
        });
    }

    @Test
    void testGetLessBonusProducts() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            BonusPage bonusPage = mainPage.getHeader().toBonusPage();

            bonusPage.clickMoreProductsButton();
            bonusPage.clickLessProductsButton();

            List<WebElement> bonusProducts = bonusPage.getBonusProducts();

            assertEquals(8, bonusProducts.size());
        });
    }
}
