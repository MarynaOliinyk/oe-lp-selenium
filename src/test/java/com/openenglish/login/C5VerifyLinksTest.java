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
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordFormTitle;

public class C5VerifyLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyTooltipIsPresentTestS1() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getQuestionIcon().hover();
        page.loginPage.getTooltip().should(visible);
    }

    @Test
    public void verifyResetPasswordPageIsOpenTestS2() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getPassword()
                      .shouldHave(attribute("type", "password"));
        page.loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(recoveryPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }

    @Test
    public void verifyRegisterFormIsOpenTestS3() {
        open(lpUrl);
        page.loginPage.getPassword()
                      .shouldHave(attribute("type", "password"));
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getSignUp().click();
        RegisterPage regForm = new RegisterPage();
        regForm.getRegisterForm().shouldBe(visible);
    }

    @Test
    public void recoveryPasswordTestS4() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(recoveryPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }

    //TODO Chat is not enabled
    @Test
    public void chatPageIsOpenTestS5() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logIn(registeredEmail, userName);
        page.loginPage.getPassword().should(visible).val(userName);
        page.loginPage.getLoginButton().should(visible).click();
        page.loginPage.getPassword().should(exist).sendKeys(userName);
        page.loginPage.getLoginButton().should(visible).click();
        page.loginPage.getSecurityField().sendKeys(userName);
        page.loginPage.getPassword().should(visible).val(userName);
        page.loginPage.getLoginButton().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChat().shouldBe(visible).click();
    }
}
