package commons;

import factoryEnvironment.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected final Log log;

    protected BaseTest(){
        log = LogFactory.getLog(getClass());
    }

    private String osName = System.getProperty("os.name");

    protected WebDriver getBrowserDriver(String envName, String serverName, String browserName, String ipAddress, String port, String osName, String osVersion) {
        switch (envName) {
            case "local":
                driver = new LocalFactory(browserName).createDriver();
                break;
            case "grid":
                driver = new GridFactory(browserName, ipAddress, port).createDriver();
                break;
            case "browserStack":
                driver = new BrowserStackFactory(browserName, osName, osVersion).createDriver();
                break;
            case "sauceLab":
                driver = new SauceLabFactory(browserName, osName).createDriver();
                break;
            case "crossBrowserTesting":
                driver = new CrossBrowserTestingFactory(browserName, osName).createDriver();
                break;
            case "lambda":
                driver = new LambdaFactory(browserName, osName).createDriver();
                break;
            default:
                driver = new LocalFactory(browserName).createDriver();
                break;

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getEnvironmentValue(serverName));
        return driver;
    }
//    protected WebDriver getBrowserDriver(String browserName){
//        BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
//        if (browser == BROWSER.FIREFOX) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if (browser == BROWSER.CHROME) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser == BROWSER.EDGE_CHROMIUM) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        } else {
//            throw new RuntimeException("Please enter correct browser name!");
//        }
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get(GlobalConstants.DEV_APP_URL);
//        return driver;
//    }

    private String getEnvironmentValue(String serverName) {
        ENVIRONMENT environment = ENVIRONMENT.valueOf(serverName.toUpperCase());
        String envUrl;
        if (environment == ENVIRONMENT.DEV) {
            envUrl = "https://opensource-demo.orangehrmlive.com/";
        } else if (environment == ENVIRONMENT.TESTING) {
            envUrl = "https://opensource-demo.orangehrmlive.com/";
        } else if (environment == ENVIRONMENT.STAGING) {
            envUrl = "https://opensource-demo.orangehrmlive.com/";
        } else if (environment == ENVIRONMENT.PRODUCTION) {
            envUrl = "https://opensource-demo.orangehrmlive.com/";
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
