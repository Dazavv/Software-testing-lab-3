import org.example.pages.CompanyPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyPageTest extends BaseTest {

    @Test
    void testCompanyManagement() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            companyPage.clickCompanySectionManagementButton();
            String actual = driver.getCurrentUrl();

            assertEquals("https://vkusnoitochka.ru/company/management", actual);
        });
    }
    @Test
    void testCompanyQuality() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionQualityButton();

            assertEquals("https://vkusnoitochka.ru/quality", driver.getCurrentUrl());
        });
    }
    @Test
    void testCompanyFacts() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionFactsButton();

            assertEquals("https://vkusnoitochka.ru/company/facts", driver.getCurrentUrl());
        });
    }
    @Test
    void testCompanyDevelopment() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionDevelopmentButton();

            assertEquals("https://vkusnoitochka.ru/company/development", driver.getCurrentUrl());
        });
    }
    @Test
    void testCompanyFranchising() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionFranchisingButton();

            assertEquals("https://vkusnoitochka.ru/company/franchising", driver.getCurrentUrl());
        });
    }

    @Test
    void testCompanyValues() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionValuesButton();

            assertEquals("https://vkusnoitochka.ru/company/values", driver.getCurrentUrl());
        });
    }

    @Test
    void testCompanyCharity() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionSemyavmesteButton();

            assertEquals("https://vkusnoitochka.ru/company/semyavmeste", driver.getCurrentUrl());
        });
    }
    @Test
    void testCompanySustainability() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionSustainabilityButton();

            assertEquals("https://vkusnoitochka.ru/sustainability", driver.getCurrentUrl());
        });
    }
    @Test
    void testCompanyEcoDay() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionEcoDayButton();

            assertEquals("https://vkusnoitochka.ru/ecoday", driver.getCurrentUrl());
        });
    }
    @Test
    void testCompanyMedia() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            companyPage.clickCompanySectionMediaButton();

            assertEquals("https://vkusnoitochka.ru/company/media", driver.getCurrentUrl());
        });
    }

}
