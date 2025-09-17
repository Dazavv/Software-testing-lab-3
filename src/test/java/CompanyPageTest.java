import org.example.pages.CompanyPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyPageTest extends BaseTest {

    @Test
    void testCompanyManagement() {
        runOnAllBrowsers(driver -> {
            driver.get(URL);
            MainPage mainPage = new MainPage(driver);
            CompanyPage companyPage = mainPage.getHeader().toCompanyPage();

            companyPage.clickCompanySectionButton();
            assertTrue(companyPage.getCompanySection().isDisplayed());
        });
    }

}
