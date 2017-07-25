package com.openenglish.core;

import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Condition.visible;
import static com.openenglish.util.PropertiesCache.getProperty;

public class TestBase extends DriverBase {

    protected String emailWithoutATsymbol = getProperty("recovery.email.without@");
    protected String emailWithoutDotCom = getProperty("recovery.email.without.com");
    protected String notValidEmailText = getProperty("recovery.tooltip.not.valid.email");
    protected String notValidEmailTextForRegistration = getProperty("field.email.acceptense.message");
    protected String recoveryTooltipEmail = getProperty("recovery.tooltip.text");
    protected String fieldShouldBeCompleted = getProperty("obligatory.field.message");
    protected String inCorrectValue = getProperty("incorrect.field.value.message");
    protected String lessThenEightyCharacters = getProperty("field.surname.lenth.acceptense.message");
    protected String lessThenFortyCharacters = getProperty("field.name.lenth.acceptense.message");
    protected String charQuantityNombre = getProperty("char.quantity.name");
    protected String charQuantityAppelido = getProperty("char.quantity.surname");
    protected String numberLength = getProperty("number.length");
    protected String specialCharacters = getProperty("special.characters");

    protected String resetPasswordFormTitle = getProperty("reset.password.form.title");
    protected String resetPasswordFaq = getProperty("reset.password.faq");
    protected String resetPasswordSingUpText = getProperty("reset.password.sing.up");
    protected String registrateText = getProperty("register.link.text");

    protected String faqText = getProperty("faq.text");
    protected String inicioLink = getProperty("home.link.text");
    protected String mensajesButtonText = getProperty("inicio.mensajes.link.text");
    protected String preferenciasButtonText = getProperty("inicio.preferencias.link.text");
    protected String salirButtonText = getProperty("inicio.salir.link.text");
    protected String notificationsUrlEndWithText = getProperty("notifications.page.url.endwith");
    protected String preferencesUrlEndWithText = getProperty("preferences.page.url.endwith");
    protected String miPerfilTabText = getProperty("preferences.miperfil.tab.text");
    protected String email = getProperty("email");
    protected String password = getProperty("password");
    protected String userName = getProperty("user.name");
    protected String registeredEmail = getProperty("email");
    protected String unregisteredEmail = getProperty("unregistered.email");
    protected String correctPassword = getProperty("password");
    protected String invalidPassword = getProperty("invalid.password");
    protected String securityPlaceHolderText = getProperty("security.placeholder");

    protected String loginTooltipPassword = getProperty("login.tooltip.text.for.password");
    protected String loginTooltipSecurityCode = getProperty("login.tooltip.invalid.security.text");
    protected String invalidSecurityCode = getProperty("login.invalid.security.code");
    protected String popUpInvalidSecurityCode = getProperty("login.popup.invalid.security.code");

    protected String oeUrl = getProperty("base.oe.url");
    protected String comienzaAhora = getProperty("comienza.ahora.button.text");

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

    protected String randonNumbers(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    protected String randCharacters(int charactersQuantity) {
        return RandomStringUtils.randomAlphabetic(charactersQuantity);
    }

}
