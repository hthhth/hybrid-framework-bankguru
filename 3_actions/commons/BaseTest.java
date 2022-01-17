package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected final Log log;

    protected BaseTest(){
        log = LogFactory.getLog(getClass());
    }

    private enum BROWSER {
        CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX, COC_COC, OPERA;
    }

    private enum ENVIRONMENT {
        DEV, TESTING, STAGING, PRODUCTION;
    }

    private String osName = System.getProperty("os.name");

    protected WebDriver getBrowserDriver(String browserName){
        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
        if (browser == BROWSER.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser == BROWSER.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser == BROWSER.EDGE_CHROMIUM) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please enter correct browser name!");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(GlobalConstants.DEV_APP_URL);
        return driver;
    }
    protected WebDriver getBrowserDriver(String browserName, String appURL){
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

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
//        driver.get(getEnvironmentValue(appURL));
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String appURL, String ipAddress, String port){
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

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
//        driver.get(getEnvironmentValue(appURL));
        return driver;
    }

    protected WebDriver getBrowserDriverBrowserStack(String browserName, String appURL, String osName, String osVersion){
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os", osName);
        capability.setCapability("os_version", osVersion);
        capability.setCapability("browser", browserName);
        capability.setCapability("browser_version", "latest");
        capability.setCapability("browserstack.debug", "true");
        capability.setCapability("project", "HRM");
        capability.setCapability("resolution", "1920x1080");
        capability.setCapability("name", "Run on " + osName + " " + osVersion + " and " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
//        driver.get(getEnvironmentValue(appURL));
        return driver;
    }
    protected WebDriver getBrowserDriverSauceLab(String browserName, String appURL, String osName){
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", osName);
        capability.setCapability("browserName", browserName);
        capability.setCapability("browserVersion", "latest");
        capability.setCapability("name", "Run on " + osName + " and " + browserName);

        Map<String, Object> sauceOptions = new HashMap<>();
        if (osName.contains("Windows")) {
            sauceOptions.put("screenResolution", "1920x1080");
        } else {
            sauceOptions.put("screenResolution", "1920x1440");
        }
        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_LAB_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
//        driver.get(getEnvironmentValue(appURL));
        return driver;
    }

    protected WebDriver getBrowserDriverCrossBrowserTesting(String browserName, String appURL, String osName){
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform", osName);
        capability.setCapability("browserName", browserName);
//        capability.setCapability("version", "latest");
        capability.setCapability("record_video", "true");
        if (osName.contains("Windows")) {
            capability.setCapability("screenResolution", "1920x1080");
        } else {
            capability.setCapability("screenResolution", "2560x1600");
        }
        capability.setCapability("name", "Run on " + osName + " and " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.CROSS_BROWSER_TESTING_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
//        driver.get(getEnvironmentValue(appURL));
        return driver;
    }

    protected WebDriver getBrowserDriverLambda(String browserName, String appURL, String osName){
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

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
//        driver.get(getEnvironmentValue(appURL));
        return driver;
    }

    private String getEnvironmentValue(String environmentName) {
        ENVIRONMENT environment = ENVIRONMENT.valueOf(environmentName.toUpperCase());
        String envUrl;
        if (environment == ENVIRONMENT.DEV) {
            envUrl = "http://demo.guru99.com/v1/";
        } else if (environment == ENVIRONMENT.TESTING) {
            envUrl = "http://demo.guru99.com/v2/";
        } else if (environment == ENVIRONMENT.STAGING) {
            envUrl = "http://demo.guru99.com/v3/";
        } else if (environment == ENVIRONMENT.PRODUCTION) {
            envUrl = "http://demo.guru99.com/v4/";
        } else {
            throw new RuntimeException("Please enter correct environment name!");
        }
        return envUrl;
    }

    public WebDriver getWebDriver(){
        return driver;
    }

    protected String getRandomEmail(){
        Random rand = new Random();
        return "testing" + rand.nextInt(99999) + "@live.com";
    }
    protected int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(99999);
    }
    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;
            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    @AfterSuite(alwaysRun = true)
    public void cleanExecutableDriver(){
        String cmd = "";
        try {

            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.contains("windows"))  {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }

            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }

            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }

            } else if (driver.toString().toLowerCase().contains("edge")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            }  else if (driver.toString().toLowerCase().contains("opera")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            }
            if (driver != null){
                driver.manage().deleteAllCookies();
                Thread.sleep(5000);
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeTest
    public void deleteAllFilesInReportNGScreenshot() {
        System.out.println("---------- START delete file in folder ----------");
        deleteAllFileInFolder("./ReportNGScreenshots");
        System.out.println("---------- END delete file in folder ----------");
    }

    @BeforeTest
    public void deleteAllFilesInAllureJSON() {
        System.out.println("---------- START delete file in folder ----------");
        deleteAllFileInFolder("./allure-json");
        System.out.println("---------- END delete file in folder ----------");
    }

    public void deleteAllFileInFolder(String pathFolderDownload) {
        try {
//            String pathFolderDownload = "./ReportNGScreenshots";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected void showBrowserConsoleLogs(WebDriver driver){
        if (driver.toString().contains("chrome")){
            LogEntries logs = driver.manage().logs().get("browser");
            List<LogEntry> logList = logs.getAll();
            for (LogEntry logging : logList){
                log.info("-------------" + logging.getLevel().toString() + "-------------\n" + logging.getMessage());
            }
        }
    }
}
