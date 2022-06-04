package pages;

import data.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class YopEmail extends BasePage {
    public YopEmail(WebDriver driver) {
        super(driver);
    }


    public static String copyEmail;
    public static String window1;
    public static String window2;
    private final Logger logger = LogManager.getRootLogger();

    private String url = "https://yopmail.com/ru/";
    @FindBy(xpath = "//a[@href='email-generator']")
    private WebElement generateEmail;
    @FindBy(xpath = "//div[@id='egen']")
    private WebElement randomEmail;
    @FindBy(css = "[onclick='egengo();']")
    private WebElement buttonOfEmailCheck;
    @FindBy(xpath = "//div[@class='fl']")
    private WebElement emailSent;
    @FindBy(id = "ifmail")
    private WebElement iframe;

    public YopEmail createNewWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        window1 = driver.getWindowHandle();
        logger.info("Create a new Window");
        js.executeScript("window.open()");
        Set<String> currentWindow = driver.getWindowHandles();
        window2 = null;
        for (String window : currentWindow)
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        driver.switchTo().window(window2);


        return new YopEmail(driver);
    }

    public YopEmail openPage() {
        logger.info("Go to " + url);
        driver.get(url);
        waitForPageLoadComplete(WAIT_TIME);
        return new YopEmail(driver);
    }

    public YopEmail generateRandomEmail() {
        waitForPageLoadComplete(WAIT_TIME);
        generateEmail.click();
        waitForPageLoadComplete(WAIT_TIME);
        waitVisibilityOfElement(WAIT_TIME, randomEmail);
        copyEmail = randomEmail.getText();
        logger.info("Generate random email " + copyEmail);
        return new YopEmail(driver);
    }

    public GmailPage switchPage() {
        driver.switchTo().window(window1);
        waitForPageLoadComplete(WAIT_TIME);
        return new GmailPage(driver);
    }

    public YopEmail clickOnCheckEmailButton() throws InterruptedException {
        driver.switchTo().window(window2);
        waitForPageLoadComplete(WAIT_TIME);
        logger.info("Wait for the letter");
        Thread.sleep(12000);
        buttonOfEmailCheck.click();
        waitForPageLoadComplete(WAIT_TIME);
        return new YopEmail(driver);
    }

    public boolean verifyLetter() {
        driver.navigate().refresh();
        driver.switchTo().frame(iframe);
        waitVisibilityOfElement(WAIT_TIME, emailSent);
        System.out.println(emailSent.getText());
        return emailSent.getAttribute("innerText").contains(Data.SUMMARY);
    }
}
