package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_MENSAJES_BUTTON_TEXT;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Inicio.INICIO_SALIR_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Notifications.NOTIFICATIONS_URL_END_WITH_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static org.testng.Assert.assertTrue;

public class C103VerifyCuentaMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private PreferencesPage preferencesPage = new PreferencesPage();

    @Test
    public void cuentaMenuLinksVerificationScenario1Test() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getMensajesCuentaSuboptionButton().shouldBe(visible, exactText(INICIO_MENSAJES_BUTTON_TEXT)).click();
        assertTrue(url().endsWith(NOTIFICATIONS_URL_END_WITH_TEXT));
    }

    @Test
    public void preferenciasCuentaMenuSuboptionVerificationScenario2Test() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getMiPerfilTabActive().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
    }

    @Test
    public void salirCuentaMenuSuboptionVerificationScenario3Test() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getLogOutLinkElement().shouldBe(visible, exactText(INICIO_SALIR_BUTTON_TEXT)).click();
        page.loginPage.getLoginForm().shouldBe(visible);
    }
}
