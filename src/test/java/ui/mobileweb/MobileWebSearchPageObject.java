package ui.mobileweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

import java.util.List;

public class MobileWebSearchPageObject extends CorePageObject {
    final String
            SEARCH_INPUT_FIELD = "xpath://form/input[@name='search']",
            SEARCH_NO_RESULTS_TEXT = "xpath://p[@class='without-results'][@style=''][.='No page with this title.']",
            SEARCH_RESULTS_TITLES = "css:div.results div.results-list-container ul.page-list li.page-summary h3";

    public MobileWebSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void sendKeysSearchInputField(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_INPUT_FIELD, searchText);
    }

    public void checkSearchResultsPresent() {
        this.waitForElementNotPresent(SEARCH_NO_RESULTS_TEXT);
    }

    public List<WebElement> getSearchResultsTitles() {
        return this.getElements(SEARCH_RESULTS_TITLES);
    }
}
