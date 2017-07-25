package com.openenglish.core;

import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Condition.visible;
import static com.openenglish.util.PropertiesCache.getProperty;

public class TestBase extends DriverBase {

    protected String emailWithoutATsymbol = getProperty("recovery.email.without@"),
            emailWithoutDotCom = getProperty("recovery.email.without.com"),
            notValidEmailText = getProperty("recovery.tooltip.not.valid.email"),
            notValidEmailTextForRegistration = getProperty("field.email.acceptense.message"),
            recoveryTooltipEmail = getProperty("recovery.tooltip.text"),
            fieldShouldBeCompleted = getProperty("obligatory.field.message"),
            inCorrectValue = getProperty("incorrect.field.value.message"),
            lessThenEightyCharacters = getProperty("field.surname.lenth.acceptense.message"),
            lessThenFortyCharacters = getProperty("field.name.lenth.acceptense.message"),
            charQuantityNombre = getProperty("char.quantity.name"),
            charQuantityAppelido = getProperty("char.quantity.surname"),
            numberLength = getProperty("number.length"),
            specialCharacters = getProperty("special.characters"),

            resetPasswordFormTitle = getProperty("reset.password.form.title"),
            resetPasswordFaq = getProperty("reset.password.faq"),
            resetPasswordSingUpText = getProperty("reset.password.sing.up"),
            registrateText = getProperty("register.link.text"),

            faqsText = getProperty("faqs.text"),
            inicioLink = getProperty("home.link.text"),
            email = getProperty("email"),
            password = getProperty("password"),
            userName = getProperty("user.name"),
            registeredEmail = getProperty("email"),
            unregisteredEmail = getProperty("unregistered.email"),
            correctPassword = getProperty("password"),
            invalidPassword = getProperty("invalid.password"),
            securityPlaceHolderText = getProperty("security.placeholder"),

            loginTooltipPassword = getProperty("login.tooltip.text.for.password"),
            loginTooltipSecurityCode = getProperty("login.tooltip.invalid.security.text"),
            invalidSecurityCode = getProperty("login.invalid.security.code"),
            popUpInvalidSecurityCode = getProperty("login.popup.invalid.security.code"),

            oeUrl = getProperty("base.oe.url"),
            comienzaAhora = getProperty("comienza.ahora.button.text"),

            talkNowHeaderText = getProperty("talknow.header.text"),
            testYourSystemHeaderText = getProperty("testyoursystem.header.text"),
            containsPdfFile = getProperty("contains.pdf.file"),
            meetingTestText = getProperty("meetingTest.header.text"),
            faqHeaderText = getProperty("faq.header.text");



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
