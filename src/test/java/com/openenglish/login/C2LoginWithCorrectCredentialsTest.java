package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;

public class C2LoginWithCorrectCredentialsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void loginWithCorrectCredentialsTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                      .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().should(visible).shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        page.logOut();
    }
}
