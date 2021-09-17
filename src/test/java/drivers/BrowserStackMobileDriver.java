package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.AndroidTestsConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {
    static AndroidTestsConfig config = ConfigFactory.create(AndroidTestsConfig.class);

    public static URL getBrowserStackUrl() {
        try {
            return new URL(config.browserstackUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", config.user());
        desiredCapabilities.setCapability("browserstack.key", config.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", config.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", config.device());
        desiredCapabilities.setCapability("os_version", config.oSVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);
    }
}
