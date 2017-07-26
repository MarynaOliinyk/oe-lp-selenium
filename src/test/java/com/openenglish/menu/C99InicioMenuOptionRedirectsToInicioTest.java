package com.openenglish.menu;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class C99InicioMenuOptionRedirectsToInicioTest extends TestBase {

    @Test
    public void openEnglishLogoLinkTest() {
        positiveLogIn();
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
        inicioPage.getProgresoLink().click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink)).click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
    }
}
