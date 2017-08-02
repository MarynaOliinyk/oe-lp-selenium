package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.UNREGISTERED_EMAIL;
import static com.openenglish.core.TestData.Recovery.RECOVERY_PASSWORD_FORM_TITLE;
import static com.openenglish.core.TestData.Recovery.RECOVERY_TOOLTIP_EMAIL;

public class C20ResetPasswordForIncorrectEmailTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void resetPasswordForIncorrectEmailTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(RECOVERY_PASSWORD_FORM_TITLE));
        //TODO BUG LPTRIAGE-302 https://openenglish.jira.com/browse/LPTRIAGE-302
//        recoveryPage.enterEmailAndSubmit(UNREGISTERED_EMAIL);
//        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(RECOVERY_TOOLTIP_EMAIL));

    }
}
