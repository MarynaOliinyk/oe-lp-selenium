package com.openenglish.login.restablecercontrasena.fieldsvalidation;

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
import static com.openenglish.core.TestData.Recovery.EMAIL_WITHOUT_A_TSYMBOL;
import static com.openenglish.core.TestData.Recovery.EMAIL_WITHOUT_DOT_COM;
import static com.openenglish.core.TestData.Recovery.NOT_VALID_EMAIL_TEXT;
import static com.openenglish.core.TestData.Recovery.RECOVERY_TOOLTIP_EMAIL;

public class C147VerifyEmailFieldTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void enterUnregisteredEmailTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.getPasswordReset().shouldBe(visible).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.enterEmailAndSubmit(UNREGISTERED_EMAIL);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(RECOVERY_TOOLTIP_EMAIL));
        recoveryPage.getEmail().clear();
        recoveryPage.getEmail().sendKeys(EMAIL_WITHOUT_A_TSYMBOL);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(NOT_VALID_EMAIL_TEXT));
        recoveryPage.getEmail().clear();
        recoveryPage.getEmail().sendKeys(EMAIL_WITHOUT_DOT_COM);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(NOT_VALID_EMAIL_TEXT));

    }
}
