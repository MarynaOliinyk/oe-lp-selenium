package com.openenglish.menu;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C99InicioMenuOptionRedirectsToInicioTest extends TestBase {

    @Test
    public void openEnglishLogoLinkTest() {
        positiveLogIn();
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getProgresoLink().click();
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink)).click();
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
    }
}
