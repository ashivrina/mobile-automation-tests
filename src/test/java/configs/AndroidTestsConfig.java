package configs;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({"classpath:${deviceHost}.properties"})
public interface AndroidTestsConfig extends Config {

    String user();

    String key();

    String deviceUrl();

    String app();

    String device();

    String oSVersion();

    String uiautomator2ServerInstallTimeout();

    String appPackage();

    String appActivity();

    String platformName();

    String apkUrl();
}
