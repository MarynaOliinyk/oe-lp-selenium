package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.unregisteredEmail;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordFormTitle;
import static com.openenglish.core.TestData.Recovery.recoveryTooltipEmail;

public class C20ResetPasswordForIncorrectEmailTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void resetPasswordForIncorrectEmailTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(recoveryPasswordFormTitle));
        recoveryPage.enterEmailAndSubmit(unregisteredEmail);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(recoveryTooltipEmail));

    }
}
