package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.TYPE;
import static com.openenglish.core.AttributeValue.LoginPage.PASSWORD;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;

public class C2LoginWithCorrectCredentialsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void loginWithCorrectCredentialsTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute(TYPE, PASSWORD));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().should(visible.text(INICIO_LINK));
        inicioPage.getUserName().shouldHave(text(USER_NAME));
    }
}
