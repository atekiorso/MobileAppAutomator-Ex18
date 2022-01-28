package tests.mobileweb;

import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import tests.ArticlesInSearchResultTests;
import ui.mobileweb.MobileWebMainPageObject;
import ui.mobileweb.MobileWebSearchPageObject;

import java.util.List;

@Category(MobileWebTests.class)
public class MobileWebArticlesInSearchResultsTests extends ArticlesInSearchResultTests {
    private MobileWebMainPageObject mainPageObject;
    private MobileWebSearchPageObject searchPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.driver = this.getMobileWebDriver();
        mainPageObject = new MobileWebMainPageObject(this.driver);
        searchPageObject = new MobileWebSearchPageObject(this.driver);
    }

    @Override
    protected void skipWelcomeScreen() {
        // В MobileWeb-версии приложения экран приветствия отсутствует
    }

    @Override
    protected void searchArticles(String searchText) {
        mainPageObject.clickSearchButton();
        searchPageObject.sendKeysSearchInputField(searchText);
        searchPageObject.checkSearchResultsPresent();
    }

    @Override
    protected List<WebElement> getTitleElementsInSearchResults() {
        return searchPageObject.getSearchResultsTitles();
    }
}
