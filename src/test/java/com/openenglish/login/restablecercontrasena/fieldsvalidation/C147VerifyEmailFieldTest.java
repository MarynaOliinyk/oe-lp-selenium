package com.openenglish.login.restablecercontrasena.fieldsvalidation;

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
import static com.openenglish.core.TestData.Recovery.emailWithoutATsymbol;
import static com.openenglish.core.TestData.Recovery.emailWithoutDotCom;
import static com.openenglish.core.TestData.Recovery.notValidEmailText;
import static com.openenglish.core.TestData.Recovery.recoveryTooltipEmail;

public class C147VerifyEmailFieldTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void enterUnregisteredEmailTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getPasswordReset().shouldBe(visible).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.enterEmailAndSubmit(unregisteredEmail);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(recoveryTooltipEmail));
        recoveryPage.getEmail().clear();
        recoveryPage.getEmail().sendKeys(emailWithoutATsymbol);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(notValidEmailText));
        recoveryPage.getEmail().clear();
        recoveryPage.getEmail().sendKeys(emailWithoutDotCom);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(notValidEmailText));

    }
}
