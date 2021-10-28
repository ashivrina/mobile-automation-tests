package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserStackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import helpers.BrowserStack;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class TestBase {

    static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browser = getBrowserDependingOnHost(deviceHost);
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void tearDown() {
        String sessionId = getSessionId();

        Attach.attachScreenshot("Last screenshot");
        Attach.attachPageSource();
        closeWebDriver();
    }

    static String getBrowserDependingOnHost(String deviceHost) {
        String browser = SelenoidMobileDriver.class.getName();

        switch (deviceHost) {
            case "browserstack":
                browser = BrowserStackMobileDriver.class.getName();
                break;
            case "selenoid":
                browser = SelenoidMobileDriver.class.getName();
                break;
            case "emulator":
            case "local":
                browser = LocalMobileDriver.class.getName();
                break;
        }
        return browser;
    }
}
