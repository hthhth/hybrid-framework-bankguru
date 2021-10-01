package environmentConfig;

import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.Key;

@Sources({"classpath:dev.properties"})
public interface Environment {

    @Key("app.url")
    String appUrl();

    @Key("app.username")
    String appUsername();

    @Key("app.password")
    String appPassword();

}
