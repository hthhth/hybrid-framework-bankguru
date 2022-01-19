package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LambdaFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;

    public LambdaFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;
    }

    public WebDriver createDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform", osName);
        capability.setCapability("browserName", browserName);
        capability.setCapability("version", "latest");
        if (osName.contains("Windows")) {
            capability.setCapability("screenResolution", "1920x1080");
        } else {
            capability.setCapability("screenResolution", "2560x1600");
        }
        capability.setCapability("name", "Run on " + osName + " and " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
