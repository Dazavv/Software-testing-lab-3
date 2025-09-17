import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class BaseTest {
    protected List<WebDriver> drivers;
    protected static final String URL = "https://vkusnoitochka.ru/";


    @BeforeEach
    public void setUp() {
        drivers = new ArrayList<>();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=ru");Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "ru");
        profile.setPreference("geo.enabled", true);
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", false);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
        WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);

        chromeDriver.manage().window().maximize();
        firefoxDriver.manage().window().maximize();

        drivers.add(chromeDriver);
        drivers.add(firefoxDriver);
    }


    @AfterEach
    public void tearDown() {
        if (drivers != null) {
            drivers.forEach(WebDriver::quit);
        }
    }

    protected void runOnAllBrowsers(Consumer<WebDriver> test) {
        drivers.parallelStream().forEach(test);
    }

}
