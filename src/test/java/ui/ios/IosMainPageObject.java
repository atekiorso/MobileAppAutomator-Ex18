package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

public class IosMainPageObject extends CorePageObject {
    final String SEARCH_WIKIPEDIA_CONTAINER = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and not(following-sibling::*)]";

    public IosMainPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickSearchWikipediaContainer() {
        this.waitForElementAndClick(SEARCH_WIKIPEDIA_CONTAINER);
    }
}
