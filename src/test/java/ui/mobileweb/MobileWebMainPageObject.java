package ui.mobileweb;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

public class MobileWebMainPageObject extends CorePageObject {
    final String SEARCH_BUTTON = "css:button#searchIcon";

    public MobileWebMainPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        this.waitForElementAndClick(SEARCH_BUTTON);
    }
}
