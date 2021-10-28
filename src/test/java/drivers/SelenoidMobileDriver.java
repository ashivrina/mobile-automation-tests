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

public class SelenoidMobileDriver implements WebDriverProvider {
    static AndroidTestsConfig config = ConfigFactory.create(AndroidTestsConfig.class);

    public static URL getSelenoidUrl() {
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
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("appPackage", config.appPackage());
        desiredCapabilities.setCapability("appActivity", config.appActivity());
        desiredCapabilities.setCapability("app", apkUrl());

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL(config.apkUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
