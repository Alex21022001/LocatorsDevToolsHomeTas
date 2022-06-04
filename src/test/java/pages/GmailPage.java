package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends BasePage {
    public GmailPage(WebDriver driver) {
        super(driver);
    }

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    private WebElement writeLetter;
    @FindBy(name = "subjectbox")
    private WebElement summaryField;
    @FindBy(xpath = "//div[@class='wO nr l1']/textarea")
    private WebElement whoField;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement writeSummary;
    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement submitButton;

    public GmailPage createLetter() {
        logger.info("create the letter");
        writeLetter.click();
        waitVisibilityOfElement(WAIT_TIME, summaryField);
        return new GmailPage(driver);
    }

    public GmailPage enterEmailInWhoField() {
        YopEmail yopEmail = new YopEmail(driver);
        yopEmail.createNewWindow()
                .openPage()
                .generateRandomEmail()
                .switchPage();
        whoField.sendKeys(YopEmail.copyEmail);
        logger.info("enter copy email  " + YopEmail.copyEmail);
        return new GmailPage(driver);
    }

    public GmailPage enterSummaryInTheLetter(String text) {
        writeSummary.sendKeys(text);
        return new GmailPage(driver);
    }

    public GmailPage clickOnSubmitButton() {
        submitButton.click();
        waitForPageLoadComplete(WAIT_TIME);
        return new GmailPage(driver);
    }
}
