package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.userNickName;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;

public class C99InicioMenuOptionRedirectsToInicioTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void openEnglishLogoLinkTest() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
        inicioPage.getProgresoLink().click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink)).click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
    }
}
