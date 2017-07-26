package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;

public class C99InicioMenuOptionRedirectsToInicioTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void openEnglishLogoLinkTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getProgresoLink().click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink)).click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
    }
}
