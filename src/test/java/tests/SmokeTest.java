package tests;

import data.Data;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.GooglePage;
import pages.YopEmail;

public class SmokeTest extends CommonConditions {
    @Test
    public void goToGmailCreateAccAndSendEmail() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        GooglePage googlePage = new GooglePage(driver);
        YopEmail yopEmail = new YopEmail(driver);
        basePage.openPage(Data.URL);
        googlePage.clickOnSingInButton()
                .fillInLogin(Data.LOGIN)
                .fillInPassword(Data.PASSWORD)
                .createLetter()
                .enterEmailInWhoField()
                .enterSummaryInTheLetter(Data.SUMMARY)
                .clickOnSubmitButton();
        Assert.assertTrue(yopEmail.clickOnCheckEmailButton()
                .verifyLetter());

    }

}
