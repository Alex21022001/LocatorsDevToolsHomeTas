package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage{
    public GooglePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gmail-sign-in")
    private WebElement signInButton;
    @FindBy(className = "maia-button")
    private WebElement createAccountButton;
    private final Logger logger = LogManager.getRootLogger();

    public LoginPage clickOnCreateAccountButton(){
        createAccountButton.click();
        waitForPageLoadComplete(WAIT_TIME);
        return new LoginPage(driver);
    }
    public LoginPage clickOnSingInButton(){
        logger.info("Sign in google");
        signInButton.click();
        waitForPageLoadComplete(WAIT_TIME);
        return new LoginPage(driver);
    }
}
