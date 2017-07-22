package com.openenglish.login.restablecercontrasena.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class С147VerifyEmailFieldTest extends TestBase {

    @Test
    public void enterUnregisteredEmailTest() {
        positiveLogIn();
        logOut();
        loginPage.getPasswordReset().shouldBe(visible).click();
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
