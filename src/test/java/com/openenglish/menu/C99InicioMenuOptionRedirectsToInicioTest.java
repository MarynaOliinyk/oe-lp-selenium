package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;

public class C99InicioMenuOptionRedirectsToInicioTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void inicioMenuOptionRedirectsToInicioTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getProgresoLink().click();
        inicioPage.getInicioLink().shouldHave(exactText(INICIO_LINK)).click();
        inicioPage.getInicioLink().shouldHave(exactText(INICIO_LINK));
        inicioPage.getUserName().shouldHave(text(USER_NAME));
    }
}
