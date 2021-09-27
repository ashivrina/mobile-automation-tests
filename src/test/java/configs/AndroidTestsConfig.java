package configs;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({"classpath:${deviceHost}.properties"})
public interface AndroidTestsConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("deviceUrl")
    String deviceUrl();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String oSVersion();

    @Key("uiautomator2ServerInstallTimeout")
    String uiautomator2ServerInstallTimeout();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("platformName")
    String platformName();

    @Key("apkUrl")
    String apkUrl();
}
