package configs;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({"classpath:mobile.properties"})
public interface AndroidTestsConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("browserstackUrl")
    String browserstackUrl();

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("osVersion")
    String oSVersion();
}
