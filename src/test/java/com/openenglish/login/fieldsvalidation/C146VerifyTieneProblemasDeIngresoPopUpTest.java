package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.invalidPassword;
import static com.openenglish.core.TestData.Login.loginTooltipPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.securityPlaceHolderText;

public class C146VerifyTieneProblemasDeIngresoPopUpTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    //TODO Chat is not enabled
    @Test
    public void verifyTieneProblemasDeIngresoPopUpTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logInAndCheckText(registeredEmail, invalidPassword, loginTooltipPassword);
        page.loginPage.logInAndCheckText(registeredEmail, invalidPassword, loginTooltipPassword);
        page.loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
        page.loginPage.getPopUpResetPassword().shouldBe(visible).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChatButton().shouldBe(visible).click();
    }
}
