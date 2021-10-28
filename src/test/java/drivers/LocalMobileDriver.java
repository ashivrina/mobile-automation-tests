package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.AndroidTestsConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalMobileDriver implements WebDriverProvider {
    static AndroidTestsConfig config = ConfigFactory.create(AndroidTestsConfig.class);

    public static URL getAppiumUrl() {
        try {
            return new URL(config.deviceUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", config.platformName());
        desiredCapabilities.setCapability("deviceName", config.device());
        desiredCapabilities.setCapability("version", config.oSVersion());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", config.appPackage());
        desiredCapabilities.setCapability("appActivity", config.appActivity());
        desiredCapabilities.setCapability("uiautomator2ServerInstallTimeout", config.uiautomator2ServerInstallTimeout());
        desiredCapabilities.setCapability("app", getAbsolutePath(config.app()));

        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
