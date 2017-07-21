package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;


public class C143VerifyRecordarMisDatosCheckTest extends TestBase {

    //TODO BUG doesnt visible password
    @Test
    public void rememberEnteredDataTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.getRememberLogin().should(exist).click();
        loginPage.logIn(email, correctPassword);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getEmail().shouldHave(value(email));
//        loginPage.getPassword().shouldHave(value(password));
    }

}
