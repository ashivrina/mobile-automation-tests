package tests.browserstack;

import com.codeborne.selenide.Configuration;
import drivers.BrowserStackMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class BrowserstackTestBase {
    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = BrowserStackMobileDriver.class.getName();
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
        Attach.attachVideo(sessionId);
    }
}
