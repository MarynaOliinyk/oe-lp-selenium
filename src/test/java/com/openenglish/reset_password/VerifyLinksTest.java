package com.openenglish.reset_password;

import com.openenglish.core.TestBase;
import com.openenglish.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class VerifyLinksTest extends TestBase {
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String inicioLink = getInstance().getProperty("home.link.text");
    private String userName = getInstance().getProperty("user.name");
    private String resetPasswordFaq = getInstance().getProperty("reset.password.faq");
    private String resetPasswordSingUpText = getInstance().getProperty("reset.password.sing.up");
    private String registrateText = getInstance().getProperty("register.link.text");
    private String faqText = getInstance().getProperty("faq.text");

    @BeforeMethod
    public void userCredetialsAndRecoveryPassword() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.cookieBannerVisibility();
        loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
//        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }


    @Test
    public void returnToLoginPage() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getReturnToLogin().shouldBe(visible).click();
        LoginPage loginPage = new LoginPage();
        loginPage.getPassword().should(visible);
        loginPage.getLoginButton().should(visible);
    }


    @Test
    public void FAQpageIsOpened() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(resetPasswordFaq)).click();
        FAQPage faqPage = new FAQPage();
        faqPage.getFaqText().shouldBe(visible).should(text(faqText));
    }

    @Test
    public void goToRegisterPage() {
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getSingUp().shouldBe(visible).shouldHave(text(resetPasswordSingUpText)).click();
        RegisterFormPage registerFormPage = new RegisterFormPage();
        registerFormPage.getTooltipWindowClose().click();
        registerFormPage.getStartNowButton().should(visible).should(text(registrateText));
    }
}
