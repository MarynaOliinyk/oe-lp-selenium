package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_OBLIGATORIO_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_SPECIAL_CHARACTERS_ERROR_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static com.openenglish.core.TestData.Register.SPECIAL_CHARACTERS;
import static org.testng.Assert.assertTrue;

public class C159VerifyDireccion1FieldTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private PreferencesPage preferencesPage = new PreferencesPage();

    @Test
    public void verifyDireccion1FieldTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().should(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().should(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getActiveTab().should(visible, text(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
        preferencesPage.getDireccionFirstField().should(empty).click();
        preferencesPage.getDireccionSecondField().click();
        assertTrue(preferencesPage.getErrorMessage().getText().equals(PREFERENCES_OBLIGATORIO_TEXT));
        preferencesPage.getDireccionFirstField().sendKeys(SPECIAL_CHARACTERS);
        preferencesPage.getDireccionSecondField().click();
        assertTrue(preferencesPage.getErrorMessage().getText().equals(PREFERENCES_SPECIAL_CHARACTERS_ERROR_TEXT));
    }
}
