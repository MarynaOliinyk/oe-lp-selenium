package com.openenglish.pages;

import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AbstractPage {

    public LoginPage loginPage = new LoginPage();
    public InicioPage inicioPage = new InicioPage();
    private String jsClickQuery = "var els = document.querySelectorAll(\"%s\"); els[0].click()";

    public void logOut() {
        inicioPage.getOeLogo().should(exist);
        executeJavaScript(String.format(jsClickQuery, inicioPage.getLogOutLink()));
    }

    public void logIn(String email, String correctPassword) {
        loginPage.cookieBannerVisibility();
        loginPage.logIn(email, correctPassword);
    }

    public String randonNumbers(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String randCharacters(int charactersQuantity) {
        return RandomStringUtils.randomAlphabetic(charactersQuantity);
    }
}
