package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.value;

public class С3RememberLoginInformationTest extends TestBase {

    @Test
    public void rememberLoginInformationTest() {
        loginPage.cookieBannerVisibility();
        loginPage.getRememberLogin().should(exist).click();
        loginPage.logIn(email, correctPassword);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getEmail().shouldHave(value(email));
    }
}
