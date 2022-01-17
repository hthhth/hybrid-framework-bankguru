package commons;

import java.io.File;

public class GlobalConstants {
    public static final String DEV_APP_URL = "http://demo.nopcommerce.com";
    public static final String STAGING_APP_URL = "http://staging.nopcommerce.com";
    public static final String TESTING_APP_URL = "http://test.nopcommerce.com";

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";

    public static final String DEV_DB_URL = "";
    public static final String DEV_DB_USER = "";
    public static final String DEV_DB_PASS = "";

    public static final String TEST_DB_URL = "";
    public static final String TEST_DB_USER = "";
    public static final String TEST_DB_PASS = "";

    public static final String BROWSER_STACK_USERNAME = "hth4";
    public static final String BROWSER_STACK_AUTOMATE_KEY = "eDmvS3JAyuvD1tLLKJXT";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_STACK_USERNAME + ":" + BROWSER_STACK_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static final String SAUCE_LAB_USERNAME = "hth";
    public static final String SAUCE_LAB_AUTOMATE_KEY = "53cab6eb-f8e3-4b4f-a552-ce4a07f8136a";
    public static final String SAUCE_LAB_URL = "https://" + SAUCE_LAB_USERNAME + ":" + SAUCE_LAB_AUTOMATE_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    public static final String CROSS_BROWSER_TESTING_USERNAME = "".replaceAll("@", "%40");
    public static final String CROSS_BROWSER_TESTING_AUTOMATE_KEY = "ua433784d2175feb";
    public static final String CROSS_BROWSER_TESTING_URL = "http://" + CROSS_BROWSER_TESTING_USERNAME + ":" + CROSS_BROWSER_TESTING_AUTOMATE_KEY + "@hub.crossbrowsertesting.com:80/wd/hub";

    public static final String LAMBDA_USERNAME = "hthxtct";
    public static final String LAMBDA_AUTOMATE_KEY = "1K7HuNBCfASLHFrDaa5lstLwTtxvhdwREtVp4iFsun6H5KEIsr";
    public static final String LAMBDA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";


}
