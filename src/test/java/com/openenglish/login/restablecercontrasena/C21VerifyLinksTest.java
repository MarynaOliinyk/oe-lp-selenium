package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.FAQsPage;
import com.openenglish.pages.RecoveryPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.FAQS.FAQS_TEXT;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.Recovery.RECOVERY_PASSWORD_FAQ;
import static com.openenglish.core.TestData.Recovery.RECOVERY_PASSWORD_FORM_TITLE;
import static com.openenglish.core.TestData.Recovery.RECOVERY_PASSWORD_SING_UP_TEXT;
import static com.openenglish.core.TestData.Recovery.REGISTRATE_TEXT;

public class C21VerifyLinksTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    public void userCredetialsAndRecoveryPassword() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserName().shouldHave(text(USER_NAME));
        page.logOut();
        page.loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(RECOVERY_PASSWORD_FORM_TITLE));
//TODO BUG LPTRIAGE-302 https://openenglish.jira.com/browse/LPTRIAGE-302
//        recoveryPage.getEmail().shouldBe(visible);
    }


    @Test
    public void returnTologinPageTestS1() {
        userCredetialsAndRecoveryPassword();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getReturnToLogin().shouldBe(visible).click();
        page.loginPage.getPassword().should(visible);
        page.loginPage.getLoginButton().should(visible);
    }


    @Test
    public void fAQpageIsOpenedTestS2() {
        userCredetialsAndRecoveryPassword();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(RECOVERY_PASSWORD_FAQ)).click();
        FAQsPage FAQsPage = new FAQsPage();
        FAQsPage.getFaqsText().shouldBe(visible).should(text(FAQS_TEXT));
    }

    @Test
    public void goToRegisterPageTestS3() {
        userCredetialsAndRecoveryPassword();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getSingUp().shouldBe(visible).shouldHave(text(RECOVERY_PASSWORD_SING_UP_TEXT)).click();
        RegisterPage registerPage = new RegisterPage();
        registerPage.getTooltipWindowClose().click();
        registerPage.getComienzaAhoraButton().should(visible).should(text(REGISTRATE_TEXT));
    }
}
