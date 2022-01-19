package factoryEnvironment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LocalFactory {
    private String browserName;
    private WebDriver driver;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver createDriver() {
        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
        if (browser == BROWSER.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser == BROWSER.CHROME) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//            options.setExperimentalOption("useAutomationExtension", false);
//            options.addExtensions(new File(GlobalConstants.PROJECT_PATH + "/browserExtensions/extension_1_6_0_0.crx"));

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
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

        return driver;
    }
}
