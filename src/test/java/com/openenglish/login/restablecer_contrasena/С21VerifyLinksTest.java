package com.openenglish.login.restablecer_contrasena;

import com.openenglish.core.TestBase;
import com.openenglish.pages.FAQPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.RecoveryPage;
import com.openenglish.pages.RegisterFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class С21VerifyLinksTest extends TestBase {

    @BeforeMethod
    public void userCredetialsAndRecoveryPassword() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                 .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        logOut();
        loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }


    @Test
    public void returnToLoginPageTestS1() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getReturnToLogin().shouldBe(visible).click();
        LoginPage loginPage = new LoginPage();
        loginPage.getPassword().should(visible);
        loginPage.getLoginButton().should(visible);
    }


    @Test
    public void fAQpageIsOpenedTestS2() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(resetPasswordFaq)).click();
        FAQPage faqPage = new FAQPage();
        faqPage.getFaqText().shouldBe(visible).should(text(faqText));
    }

    @Test
    public void goToRegisterPageTestS3() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getSingUp().shouldBe(visible).shouldHave(text(resetPasswordSingUpText)).click();
        RegisterFormPage registerFormPage = new RegisterFormPage();
        registerFormPage.getTooltipWindowClose().click();
        registerFormPage.getStartNowButton().should(visible).should(text(registrateText));
    }
}
