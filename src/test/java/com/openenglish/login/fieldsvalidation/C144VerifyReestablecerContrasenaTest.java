package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordFormTitle;

public class C144VerifyReestablecerContrasenaTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyReestablecerContrasenaTest() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(recoveryPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }
}
