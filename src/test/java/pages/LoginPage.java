package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(name = "identifier")
    private WebElement loginField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;


    public LoginPage fillInLogin(String login){
        logger.info("Enter login  "+login);
        loginField.sendKeys(login, Keys.ENTER);
        waitForPageLoadComplete(WAIT_TIME);
        waitVisibilityOfElement(WAIT_TIME,passwordField);
        return new LoginPage(driver);
    }

    public GmailPage fillInPassword(String password) throws InterruptedException {
        logger.info("Enter password  "+password);
        passwordField.sendKeys(password,Keys.ENTER);
        waitForPageLoadComplete(WAIT_TIME);
        Thread.sleep(5000);
        return new GmailPage(driver);
    }
}
