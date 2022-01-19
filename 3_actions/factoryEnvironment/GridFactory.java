package factoryEnvironment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class GridFactory {
    private WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String port;

    public GridFactory(String browserName, String ipAddress, String port) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public WebDriver createDriver() {
        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
        DesiredCapabilities capability = null;
        if (browser == BROWSER.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName(browserName);
            capability.setPlatform(Platform.WINDOWS);

//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.merge(capability);
        } else if (browser == BROWSER.CHROME) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//            options.setExperimentalOption("useAutomationExtension", false);
//            options.addExtensions(new File(GlobalConstants.PROJECT_PATH + "/browserExtensions/extension_1_6_0_0.crx"));

            capability = DesiredCapabilities.chrome();
            capability.setBrowserName(browserName);
            capability.setPlatform(Platform.WINDOWS);

//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.merge(capability);

        } else if (browser == BROWSER.EDGE_CHROMIUM) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browser == BROWSER.EDGE_LEGACY) {
            driver = new EdgeDriver();

        } else if (browser == BROWSER.COC_COC) {
            WebDriverManager.chromedriver().driverVersion("91.0.4472.101").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files(x86)\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);

        } else if (browser == BROWSER.OPERA) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        }
        else if (browser == BROWSER.IE) {
            WebDriverManager.iedriver().arch32().driverVersion("3.141.59").setup();
            driver = new InternetExplorerDriver();

        } else if (browser == BROWSER.SAFARI) {
            driver = new SafariDriver();

        } else if (browser == BROWSER.H_CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1366x768");
            driver = new ChromeDriver(options);

        } else if (browser == BROWSER.H_FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1366x768");
            driver = new FirefoxDriver(options);

        } else {
            throw new RuntimeException("Please enter correct browser name!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
