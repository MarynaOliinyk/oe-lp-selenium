package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenEnglishPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class С5VerifyLinksTest extends TestBase {

    @Test
    public void verifyTooltipIsPresentTestS1() {
        loginPage.cookieBannerVisibility();
        loginPage.getQuestionIcon().hover();
        loginPage.getTooltip().should(visible);
    }

    @Test
    public void verifyResetPasswordPageIsOpenTestS2() {
        positiveLogIn();
        logOut();
        loginPage.getPassword()
                 .shouldHave(attribute("type", "password"));
        loginPage.getPasswordReset().click();

        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }

    @Test
    public void verifyRegisterFormIsOpenTestS3() {
        loginPage.getPassword()
                 .shouldHave(attribute("type", "password"));
        loginPage.cookieBannerVisibility();
        loginPage.getSignUp().click();
        OpenEnglishPage openEnglishPage = new OpenEnglishPage();
        openEnglishPage.getRegisterForm().shouldBe(visible);
    }

    @Test
    public void recoveryPasswordTestS4() {
        positiveLogIn();
        logOut();
        loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }

    //TODO Bug with chat (Chat page is opened in a new window.)
    @Test
    public void chatPageIsOpenTestS5() {
        positiveLogIn();
        logOut();
        loginPage.logIn(registeredEmail, userName);
        loginPage.getPassword().should(visible).val(userName);
        loginPage.getLoginButton().should(visible).click();
        loginPage.getPassword().should(exist).sendKeys(userName);
        loginPage.getLoginButton().should(visible).click();
        loginPage.getSecurityField().sendKeys(userName);
        loginPage.getPassword().should(visible).val(userName);
        loginPage.getLoginButton().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChat().shouldBe(visible).click();
    }
}
