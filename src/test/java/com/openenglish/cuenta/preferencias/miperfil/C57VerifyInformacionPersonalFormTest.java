package com.openenglish.cuenta.preferencias.miperfil;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.Attribute.VALUE;
import static com.openenglish.core.Tag.STRONG;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_APELLIDO_PLACEHOLDER_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_APELLIDO_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_EMAIL_PLACEHOLDER_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_EMAIL_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_FECHA_DE_NACIMIENTO_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_IDIOMA_DE_PREFERENCIA_PLACEHOLDER_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_IDIOMA_DE_PREFERENCIA_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NOMBRE_PLACEHOLDER_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NOMBRE_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static org.testng.Assert.assertTrue;

public class C57VerifyInformacionPersonalFormTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private PreferencesPage preferencesPage = new PreferencesPage();

    @Test
    public void verifyInformacionPersonalFormTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getMiPerfilTabActive().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
        preferencesPage.getNombreField().should(visible, attribute(VALUE, PREFERENCES_NOMBRE_VALUE_TEXT));
        preferencesPage.getApellidoField().should(visible, attribute(VALUE, PREFERENCES_APELLIDO_VALUE_TEXT));
        assertTrue(preferencesPage.getSexoField().isSelected());
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-329
        assertTrue(preferencesPage.getFechaDeNacimientoField().val().equals(PREFERENCES_FECHA_DE_NACIMIENTO_VALUE_TEXT));
        assertTrue(preferencesPage.getEmailField().getValue().equals(PREFERENCES_EMAIL_VALUE_TEXT));
        preferencesPage.getContrasenaField().should(visible, empty);
        preferencesPage.getConfirmarContrasenaField().should(visible, empty);
        preferencesPage.getIdiomaDePreferenciaField().should(visible, text(PREFERENCES_IDIOMA_DE_PREFERENCIA_VALUE_TEXT));
        preferencesPage.getGuardarCambiosButtonOnPersonalSection().should(disabled);
        assertTrue(preferencesPage.getNombreVisibleParaOtrosValueText().getTagName().equals(STRONG));
        assertTrue(preferencesPage.getNivelAcademicoPlaceholder().getTagName().equals(STRONG));
        preferencesPage.getEmailPlaceholder().should(visible, text(PREFERENCES_EMAIL_PLACEHOLDER_TEXT));
        preferencesPage.getIdiomaDePreferenciaPlaceholder().should(visible, text(PREFERENCES_IDIOMA_DE_PREFERENCIA_PLACEHOLDER_TEXT));
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-327
        preferencesPage.getNombrePlaceholder().should(visible, text(PREFERENCES_NOMBRE_PLACEHOLDER_TEXT));
        preferencesPage.getApellidoPlaceholder().should(visible, text(PREFERENCES_APELLIDO_PLACEHOLDER_TEXT));
    }
}
