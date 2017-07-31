package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.MENSAJES_BUTTON_TEXT;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Notifications.NOTIFICATIONS_URL_END_WITH_TEXT;
import static org.testng.Assert.assertTrue;

public class C103VerifyCuentaMenuLinksScenario1Test extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void mensajesCuentaMenuSuboptionVerificationTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(exactText(INICIO_LINK));
        inicioPage.getUserName().shouldHave(text(USER_NICK_NAME));
        inicioPage.getAccountMenu().hover();
        inicioPage.getCuentaSuboptions().shouldBe(visible);
        inicioPage.getMensajesCuentaSuboptionButton().shouldBe(visible).shouldHave(exactText(MENSAJES_BUTTON_TEXT)).click();
        assertTrue(url().endsWith(NOTIFICATIONS_URL_END_WITH_TEXT));
    }

}
