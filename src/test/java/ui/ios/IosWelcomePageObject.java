package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

public class IosWelcomePageObject extends CorePageObject {
    final String
            SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";

    public IosWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickSkipButton() {
        this.waitForElementAndClick(SKIP_BUTTON);
    }
}
