import org.example.pages.MainPage;
import org.example.pages.NewsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsPageTest extends BaseTest {
    @Test
    void testSeeNewsList() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            NewsPage newsPage = mainPage.getHeader().toNewsPage();

            assertTrue(newsPage.hasNewsList());

        });
    }

    @Test
    void testSeeNewsListData() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            NewsPage newsPage = mainPage.getHeader().toNewsPage();

            assertTrue(newsPage.newsHaveDates());
        });
    }

    @Test
    void testSeeNew() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            NewsPage newsPage = mainPage.getHeader().toNewsPage();

            newsPage.clickFirstNews();
            assertTrue(newsPage.isNewsDetailVisible());
        });
    }

    @Test
    void testSeeNewsListTitles() {
        runOnAllBrowsers(driver -> {
            MainPage mainPage = new MainPage(driver);
            NewsPage newsPage = mainPage.getHeader().toNewsPage();

            assertTrue(newsPage.newsHaveTitles());
        });
    }

}
