package com.openenglish.core;

import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.openenglish.util.PropertiesCache.getInstance;

public class TestBase extends DriverBase {

    protected String emailWithoutATsymbol = getInstance().getProperty("recovery.email.without@");
    protected String emailWithoutDotCom = getInstance().getProperty("recovery.email.without.com");
    protected String notValidEmailText = getInstance().getProperty("recovery.tooltip.not.valid.email");
    protected String recoveryTooltipEmail = getInstance().getProperty("recovery.tooltip.text");

    protected String resetPasswordFormTitle = getInstance().getProperty("reset.password.form.title");
    protected String resetPasswordFaq = getInstance().getProperty("reset.password.faq");
    protected String resetPasswordSingUpText = getInstance().getProperty("reset.password.sing.up");
    protected String registrateText = getInstance().getProperty("register.link.text");

    protected String faqText = getInstance().getProperty("faq.text");
    protected String inicioLink = getInstance().getProperty("home.link.text");

    protected String email = getInstance().getProperty("email");
    protected String password = getInstance().getProperty("password");
    protected String userName = getInstance().getProperty("user.name");
    protected String registeredEmail = getInstance().getProperty("email");
    protected String unregisteredEmail = getInstance().getProperty("unregistered.email");
    protected String correctPassword = getInstance().getProperty("password");
    protected String invalidPassword = getInstance().getProperty("invalid.password");
    protected String securityPlaceHolderText = getInstance().getProperty("security.placeholder");

    protected String loginTooltipPassword = getInstance().getProperty("login.tooltip.text.for.password");
    protected String loginTooltipSecurityCode = getInstance().getProperty("login.tooltip.invalid.security.text");
    protected String invalidSecurityCode = getInstance().getProperty("login.invalid.security.code");
    protected String popUpInvalidSecurityCode = getInstance().getProperty("login.popup.invalid.security.code");

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
