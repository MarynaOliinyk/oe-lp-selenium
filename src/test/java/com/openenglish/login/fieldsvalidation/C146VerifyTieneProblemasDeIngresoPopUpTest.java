package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.INVALID_PASSWORD;
import static com.openenglish.core.TestData.Login.LOGIN_TOOLTIP_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.SECURITY_PLACE_HOLDER_TEXT;

public class C146VerifyTieneProblemasDeIngresoPopUpTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    //TODO LPTRIAGE-299 https://openenglish.jira.com/browse/LPTRIAGE-299
    @Test
    public void verifyTieneProblemasDeIngresoPopUpTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logInAndCheckText(REGISTERED_EMAIL, INVALID_PASSWORD, LOGIN_TOOLTIP_PASSWORD);
        page.loginPage.logInAndCheckText(REGISTERED_EMAIL, INVALID_PASSWORD, LOGIN_TOOLTIP_PASSWORD);
        page.loginPage.getSecurityField().shouldHave(attribute("placeholder", SECURITY_PLACE_HOLDER_TEXT));
        page.loginPage.getPopUpResetPassword().shouldBe(visible).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChatButton().shouldBe(visible).click();
        switchTo().window(1).close();

    }
}
