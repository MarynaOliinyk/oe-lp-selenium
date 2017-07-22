package com.openenglish.core;

import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.openenglish.util.PropertiesCache.getProperty;

public class TestBase extends DriverBase {

    protected String emailWithoutATsymbol = getProperty("recovery.email.without@");
    protected String emailWithoutDotCom = getProperty("recovery.email.without.com");
    protected String notValidEmailText = getProperty("recovery.tooltip.not.valid.email");
    protected String recoveryTooltipEmail = getProperty("recovery.tooltip.text");

    protected String resetPasswordFormTitle = getProperty("reset.password.form.title");
    protected String resetPasswordFaq = getProperty("reset.password.faq");
    protected String resetPasswordSingUpText = getProperty("reset.password.sing.up");
    protected String registrateText = getProperty("register.link.text");

    protected String faqText = getProperty("faq.text");
    protected String inicioLink = getProperty("home.link.text");
    protected String email = getProperty("email");
    protected String userName = getProperty("user.name");
    protected String registeredEmail = getProperty("email");
    protected String unregisteredEmail = getProperty("unregistered.email");
    protected String correctPassword = getProperty("password");
    protected String invalidPassword = getProperty("invalid.password");
    protected String securityPlaceHolderText = getProperty("security.placeholder");

    protected String loginTooltipPassword = getProperty("login.tooltip.text.for.password");
    protected String loginTooltipSecurityCode = getProperty("login.tooltip.invalid.security.text");
    protected String invalidSecurityCode = getProperty("login.invalid.security.code");
    protected String popUpInvalidSecurityCode = getProperty("login.popUp.invalid.security.code");

    protected LoginPage loginPage = new LoginPage();
    protected InicioPage inicioPage = new InicioPage();

    protected void logOut() {
        inicioPage.getAccountMenu().should(visible).hover();
        inicioPage.getLogOutLink().click();
    }

    protected void positiveLogIn() {
        loginPage.cookieBannerVisibility();
        loginPage.logIn(email, correctPassword);
    }
}
