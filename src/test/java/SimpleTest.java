import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest extends BaseTest {

    @Test
    void openSiteAndCheckTitle() {
        runOnAllBrowsers(driver -> {
            WebElement menuLink = driver.findElement(By.xpath("//a[@href='/menu']"));
            assertTrue(menuLink.isDisplayed(), "Ссылка 'Меню' должна отображаться");
        });
    }
}
