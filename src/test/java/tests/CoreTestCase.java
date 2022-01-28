package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class CoreTestCase extends TestCase {
    protected RemoteWebDriver driver;
    private static final String
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub",
            WIKIPEDIA_URL = "https://en.m.wikipedia.org";

    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected AndroidDriver<AndroidElement> getAndroidDriver() throws Exception {
        return new AndroidDriver<>(new URL(APPIUM_URL), getAndroidCapabilities());
    }

    protected IOSDriver<IOSElement> getIOSDriver() throws Exception {
        return new IOSDriver<>(new URL(APPIUM_URL), getIOSCapabilities());
    }

    protected RemoteWebDriver getMobileWebDriver() {
        ChromeDriver chromeDriver = new ChromeDriver(getMobileWebChromeOptions());
        chromeDriver.get(WIKIPEDIA_URL);
        return chromeDriver;
    }

    private DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, "30000");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "and80");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wikipedia");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".main.MainActivity");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/IdeaProjects/MobileAppAutomator/MobileAppAutomator-Ex18/apks/org.wikipedia.apk");

        return capabilities;
    }

    private DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/IdeaProjects/MobileAppAutomator/MobileAppAutomator-Ex18/apks/wikipedia.app");

        return capabilities;
    }

    private ChromeOptions getMobileWebChromeOptions() {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone SE");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        return chromeOptions;
    }
}
