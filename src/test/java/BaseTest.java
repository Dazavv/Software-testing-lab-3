import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class BaseTest {
    public enum Browser {
        CHROME,
        FIREFOX
    }

    protected WebDriver initDriver(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME -> {
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.geolocation", 2);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--lang=ru");
//                chromeOptions.addArguments("--headless=new"); // запускаем в фоновом режиме
//                chromeOptions.addArguments("--window-size=1920,1080"); // обязательно указываем размер окна

                driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("intl.accept_languages", "ru");
                firefoxOptions.addPreference("geo.enabled", true); // включаем геолокацию
                firefoxOptions.addPreference("geo.prompt.testing", true); // включаем тестовый режим
                firefoxOptions.addPreference("geo.prompt.testing.allow", false); // запрещаем разрешение
                firefoxOptions.addPreference("geo.provider.use_corelocation", false);
                firefoxOptions.addPreference("geo.provider.network.url", ""); // отключаем сетевой провайдер
                firefoxOptions.addPreference("geo.wifi.scan", false);
//                firefoxOptions.addArguments("--headless"); // запускаем в фоновом режиме
//                firefoxOptions.addArguments("--width=1920"); // задаём ширину окна
//                firefoxOptions.addArguments("--height=1080"); // задаём высоту окна

                driver = new FirefoxDriver(firefoxOptions);

            }
            default -> throw new IllegalArgumentException("Unknown browser: " + browser);

        }
        driver.manage().window().maximize();
        driver.get("https://vkusnoitochka.ru/");
        return driver;
    }

    protected void runOnAllBrowsers(Consumer<WebDriver> test) {
        List<Browser> browsers = List.of(Browser.FIREFOX);
        browsers.parallelStream().forEach(browser -> {
            WebDriver driver = null;
            try {
                driver = initDriver(browser);
                test.accept(driver);
            } finally {
                if (driver != null) driver.quit();
            }
        });
    }
}
