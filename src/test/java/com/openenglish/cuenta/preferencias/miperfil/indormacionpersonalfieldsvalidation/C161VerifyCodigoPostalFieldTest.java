package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.Attribute.VALUE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_CODIGO_POSTAL_ERROR_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_DIRECTION_ONE_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_SPECIAL_SYMBOLS;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_TELEFONO_PRINCIPAL_VALUE_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_VALUE_FOR_FIELD;
import static com.openenglish.core.TestData.Selenide.TIMEOUT;
import static org.testng.Assert.assertTrue;

public class C161VerifyCodigoPostalFieldTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private PreferencesPage preferencesPage = new PreferencesPage();

    @Test
    public void verifyCodigoPostalFieldTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getActiveTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
        assertTrue(preferencesPage.getDireccionFirstField().getValue().matches(PREFERENCES_DIRECTION_ONE_VALUE_TEXT));
        assertTrue(preferencesPage.getTelefonoPrincipalFirstField().should(visible).getValue().matches(PREFERENCES_TELEFONO_PRINCIPAL_VALUE_TEXT));
        assertTrue(preferencesPage.getTelefonoPrincipalSecondField().getValue().matches(PREFERENCES_TELEFONO_PRINCIPAL_VALUE_TEXT));
        preferencesPage.getCodigoPostalField().setValue(PREFERENCES_VALUE_FOR_FIELD);
        preferencesPage.getDireccionFirstField().click();
        preferencesPage.getContactoSection().scrollTo();
        preferencesPage.getGuardarCambiosButtonOnContactoSection().should(enabled).click();
        preferencesPage.getCodigoPostalField().should(attribute(VALUE, PREFERENCES_VALUE_FOR_FIELD));
        preferencesPage.getCodigoPostalField().waitUntil(appear, TIMEOUT);
        preferencesPage.getCodigoPostalField().setValue(PREFERENCES_SPECIAL_SYMBOLS);
        preferencesPage.getDireccionFirstField().click();
        preferencesPage.getCodigoPostalErrorText().should(exist, text(PREFERENCES_CODIGO_POSTAL_ERROR_TEXT));
    }
}
