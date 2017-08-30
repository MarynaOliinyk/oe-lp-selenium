package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RecoveryPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.TYPE;
import static com.openenglish.core.AttributeValue.LoginPage.PASSWORD;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.INVALID_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Recovery.RECOVERY_PASSWORD_FORM_TITLE;

public class C5VerifyLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyTooltipIsPresentTestS1() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getQuestionIcon().hover();
        page.loginPage.getTooltip().should(visible);
    }

    @Test
    public void verifyResetPasswordPageIsOpenTestS2() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.getPassword()
                .shouldHave(attribute(TYPE, PASSWORD));
        page.loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(RECOVERY_PASSWORD_FORM_TITLE));
        recoveryPage.getEmail().shouldBe(visible);
    }

    @Test
    public void verifyRegisterFormIsOpenTestS3() {
        open(LP_URL);
        page.loginPage.getPassword()
                .shouldHave(attribute(TYPE, PASSWORD));
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getSignUp().click();
        RegisterPage regForm = new RegisterPage();
        regForm.getRegisterForm().shouldBe(visible);
    }

    @Test
    public void recoveryPasswordTestS4() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(RECOVERY_PASSWORD_FORM_TITLE));
        recoveryPage.getEmail().shouldBe(visible);
    }

    //TODO LPTRIAGE-299 https://openenglish.jira.com/browse/LPTRIAGE-299
    @Test
    public void chatPageIsOpenTestS5() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logIn(REGISTERED_EMAIL, INVALID_PASSWORD);
        page.loginPage.getPassword().should(visible).val(INVALID_PASSWORD);
        page.loginPage.getLoginButton().should(visible).click();
        page.loginPage.getPassword().should(exist).sendKeys(INVALID_PASSWORD);
        page.loginPage.getLoginButton().should(visible).click();
        page.loginPage.getSecurityField().sendKeys(INVALID_PASSWORD);
        page.loginPage.getPassword().should(visible).val(INVALID_PASSWORD);
        page.loginPage.getLoginButton().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChat().shouldBe(visible).click();
    }
}
