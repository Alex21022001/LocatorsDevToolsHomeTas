package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatingPage extends BasePage {
    public CreatingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(name = "ConfirmPasswd")
    private WebElement confirmPassword;
    @FindBy(xpath = "//div[@class='VfPpkd-RLmnJb']")
    private WebElement submitButton;

    public void FillInForm(String firstName, String lastName, String email,String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPassword.sendKeys(password);
        submitButton.click();
        waitForPageLoadComplete(WAIT_TIME);



    }
}
