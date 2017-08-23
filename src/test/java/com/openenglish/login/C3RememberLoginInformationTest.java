package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.SALIR_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C3RememberLoginInformationTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void rememberLoginInformationTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getRememberLogin().should(exist).click();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getLogOutLinkElement().should(visible,exactText(SALIR_BUTTON_TEXT)).click();
        page.loginPage.getEmail().getText().equals((REGISTERED_EMAIL));
    }
}
