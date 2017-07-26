package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.TestBase;
import com.openenglish.pages.FAQsPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.RecoveryPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C21VerifyLinksTest extends TestBase {

    @BeforeMethod
    public void userCredetialsAndRecoveryPassword() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                 .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
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
        FAQsPage FAQsPage = new FAQsPage();
        FAQsPage.getFaqsText().shouldBe(visible).should(text(faqsText));
    }

    @Test
    public void goToRegisterPageTestS3() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getSingUp().shouldBe(visible).shouldHave(text(resetPasswordSingUpText)).click();
        RegisterPage registerPage = new RegisterPage();
        registerPage.getTooltipWindowClose().click();
        registerPage.getComienzaAhoraButton().should(visible).should(text(registrateText));
    }
}
