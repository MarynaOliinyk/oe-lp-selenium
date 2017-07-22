package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


public class С20ResetPasswordForIncorrectEmailTest extends TestBase {

    @Test
    public void resetPasswordForIncorrectEmailTest() {
        positiveLogIn();
        logOut();
        loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.enterEmailAndSubmit(unregisteredEmail);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(recoveryTooltipEmail));

    }
}
