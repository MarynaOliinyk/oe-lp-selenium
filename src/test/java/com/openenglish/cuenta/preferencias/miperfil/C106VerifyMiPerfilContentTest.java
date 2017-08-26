package com.openenglish.cuenta.preferencias.miperfil;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.Attribute.HREF;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_LINK;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PERFIL_DE_APRENDIZAJE_LINK;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_USER_NICK_NAME_AND_HOLA;
import static org.testng.Assert.assertTrue;

public class C106VerifyMiPerfilContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private PreferencesPage preferencesPage = new PreferencesPage();

    public void loginWithCorrectCredentialsAndPagePreferenciasIsOpen() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().should(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().should(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getMiPerfilTabActive().should(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
    }

    @Test
    public void verifyMiPerfilContentTestUserSectionS1() {
        loginWithCorrectCredentialsAndPagePreferenciasIsOpen();
        preferencesPage.getUserNameAndHolaText().should(visible, text(PREFERENCES_USER_NICK_NAME_AND_HOLA));
        preferencesPage.getPhotoFrame().should(visible);
        preferencesPage.getMiPerfilTabActive().should(visible).getAttribute(HREF).contains(PREFERENCES_MI_PERFIL_LINK);
        preferencesPage.getPrefilDeAprendizajeTab().should(visible).getAttribute(HREF).contains(PREFERENCES_PERFIL_DE_APRENDIZAJE_LINK);
    }
}