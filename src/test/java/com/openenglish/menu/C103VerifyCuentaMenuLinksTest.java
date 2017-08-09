package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
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
import static com.openenglish.core.TestData.Inicio.PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Inicio.SALIR_BUTTON_TEXT;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.Notifications.NOTIFICATIONS_URL_END_WITH_TEXT;
import static com.openenglish.core.TestData.Preferences.MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static org.testng.Assert.assertTrue;

public class C103VerifyCuentaMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void cuentaMenuLinksVerificationScenario1Test() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(exactText(INICIO_LINK));
        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getMensajesCuentaSuboptionButton().shouldBe(visible).shouldHave(exactText(MENSAJES_BUTTON_TEXT)).click();
        assertTrue(url().endsWith(NOTIFICATIONS_URL_END_WITH_TEXT));
    }

    @Test
    public void preferenciasCuentaMenuSuboptionVerificationScenario2Test() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(exactText(INICIO_LINK));
        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible).
                shouldHave(exactText(PREFERENCIAS_BUTTON_TEXT)).click();
        page.preferencesPage.getMiPerfilTab().shouldBe(visible).shouldHave(exactText(MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
    }

    @Test
    public void salirCuentaMenuSuboptionVerificationScenario3Test() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(exactText(INICIO_LINK));
        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getLogOutLinkElement().shouldBe(visible).
                shouldHave(exactText(SALIR_BUTTON_TEXT)).click();
        page.loginPage.getLoginForm().shouldBe(visible);
        page.inicioPage.getUserNickName().shouldNotHave(text(USER_NICK_NAME));
    }

}
