package com.openenglish.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AbstractPage {

    public LoginPage loginPage = new LoginPage();
    public InicioPage inicioPage = new InicioPage();
    public PreferencesPage preferencesPage = new PreferencesPage();

    private String jsClickQuery = "var els = document.querySelectorAll(\"%s\"); els[0].click()";

    public static void openInNewTab(String url) {
        executeJavaScript("window.open('" + url + "','_blank');");
    }

    public WebElement findElementByJS(String id){
        // returns the right WebElement
// it's the same as driver.findElement(By.id("someId"))
       return executeJavaScript("return document.getElementById('" + id +  "');");
    }

    public static void scroll() {
        executeJavaScript("window.scrollBy(0,250)", "");
    }

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

    public int randomNumber(int maxRandomNumber) {
        return Integer.parseInt(RandomStringUtils.randomNumeric(0, maxRandomNumber));
    }

    public String randCharacters(int charactersQuantity) {
        return RandomStringUtils.randomAlphabetic(charactersQuantity);
    }
}
