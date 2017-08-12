package com.openenglish.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.WARNING_MESSAGE;
import static org.testng.AssertJUnit.assertTrue;

public class C18VerifyMandatoryFieldsTest extends DriverBase {

    @Test(enabled = false)
    public void verifyWarningMessagesForMandatoryFieldsTest() {
        open(OE_URL);
        RegisterPage regForm = new RegisterPage();
        regForm.getPopUpCloseButton().should(exist).click();
        regForm.getStartNowButton().click();
        //TODO bug https://openenglish.jira.com/browse/LPTRIAGE-306
        assertTrue(regForm.getWarningMessages().stream().allMatch(elem -> elem.getText().equals(WARNING_MESSAGE)));
    }
}
