package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.EMAIL_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.PASSWORD_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_SPECIAL_CHARACTERS_ERROR_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_VALUE_FOR_DIRRECCION_2_FIELD;
import static com.openenglish.core.TestData.Register.SPECIAL_CHARACTERS;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class C160VerifyDireccion2FieldTest extends DriverBase {
    AbstractPage page = new AbstractPage();
    PreferencesPage preferencesPage = new PreferencesPage();

    @Test
    public void verifyDireccion2FieldTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(EMAIL_WITHOUT_NOTES, PASSWORD_WITHOUT_NOTES);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getActiveTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
        preferencesPage.getDireccionSecondField().sendKeys(PREFERENCES_VALUE_FOR_DIRRECCION_2_FIELD);
        preferencesPage.getDireccionFirstField().click();
        assertFalse(preferencesPage.getErrorMessageForDireccion2Field().exists());
        preferencesPage.getDireccionSecondField().clear();
        preferencesPage.getDireccionFirstField().click();
        assertFalse(preferencesPage.getErrorMessageForDireccion2Field().exists());
        preferencesPage.getDireccionSecondField().sendKeys(SPECIAL_CHARACTERS);
        assertTrue(preferencesPage.getErrorMessageForDireccion2Field().getText().equals(PREFERENCES_SPECIAL_CHARACTERS_ERROR_TEXT));
    }
}
