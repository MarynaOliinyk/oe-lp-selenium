package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.FAQsPage;
import com.openenglish.pages.RecoveryPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.FAQS.faqsText;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordFaq;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordFormTitle;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordSingUpText;
import static com.openenglish.core.TestData.Recovery.registrateText;

public class C21VerifyLinksTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @BeforeMethod
    public void userCredetialsAndRecoveryPassword() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                      .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userName));
        page.logOut();
        page.loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(recoveryPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }


    @Test
    public void returnTologinPageTestS1() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getReturnToLogin().shouldBe(visible).click();
        page.loginPage.getPassword().should(visible);
        page.loginPage.getLoginButton().should(visible);
    }


    @Test
    public void fAQpageIsOpenedTestS2() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(recoveryPasswordFaq)).click();
        FAQsPage FAQsPage = new FAQsPage();
        FAQsPage.getFaqsText().shouldBe(visible).should(text(faqsText));
    }

    @Test
    public void goToRegisterPageTestS3() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getSingUp().shouldBe(visible).shouldHave(text(recoveryPasswordSingUpText)).click();
        RegisterPage registerPage = new RegisterPage();
        registerPage.getTooltipWindowClose().click();
        registerPage.getComienzaAhoraButton().should(visible).should(text(registrateText));
    }
}
