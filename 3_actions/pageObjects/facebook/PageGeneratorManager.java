package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    private static RegisterPageObject registerPage;

    private PageGeneratorManager(){

    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        if (registerPage == null){
            registerPage = new RegisterPageObject(driver);
        }
        return registerPage;
    }
}
