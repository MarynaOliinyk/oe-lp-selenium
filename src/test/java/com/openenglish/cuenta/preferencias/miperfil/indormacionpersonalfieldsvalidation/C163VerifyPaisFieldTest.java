package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;


import com.codeborne.selenide.SelenideElement;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.PreferencesPage;
import java.util.List;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_PREFERENCIAS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PAIS_VALUE_AFGANISTAN_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PAIS_VALUE_ALBANIA_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_URL_END_WITH_TEXT;
import static org.testng.Assert.assertTrue;

public class C163VerifyPaisFieldTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private PreferencesPage preferencesPage = new PreferencesPage();

    @Test
    public void verifyPaisFieldTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible, exactText(INICIO_PREFERENCIAS_BUTTON_TEXT)).click();
        preferencesPage.getActiveTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        assertTrue(url().endsWith(PREFERENCES_URL_END_WITH_TEXT));
        preferencesPage.getContactoSection().scrollTo();
        preferencesPage.getPaisDropDownButton().should(visible).click();
        List<SelenideElement> allPaisList = preferencesPage.getAllPaisList();
        allPaisList.forEach(element -> element.should(exist, not(empty)));
        preferencesPage.getPaisDrobDownInput().click();
        preferencesPage.getPaisDrobDownInput().setValue(PREFERENCES_PAIS_VALUE_AFGANISTAN_TEXT);
        preferencesPage.getPaisValueOnDropDown().should(text(PREFERENCES_PAIS_VALUE_AFGANISTAN_TEXT)).click();
        preferencesPage.getTelefonoPrincipalFirstField().should(visible, empty);
        preferencesPage.getTelefonoPrincipalSecondField().should(visible, empty);
        preferencesPage.getTelefonoPrincipalThirdField().should(visible, empty);
        preferencesPage.getTelefonoSecundarioFirstField().should(visible, empty);
        preferencesPage.getTelefonoSecundarioSecondField().should(visible, empty);
        preferencesPage.getTelefonoSecundarioThirdField().should(visible, empty);
        preferencesPage.getPaisDrobDownInput().should(visible).click();
        preferencesPage.getPaisDrobDownInput().setValue(PREFERENCES_PAIS_VALUE_ALBANIA_TEXT);
        preferencesPage.getPaisValueOnDropDown().should(text(PREFERENCES_PAIS_VALUE_ALBANIA_TEXT)).click();
        preferencesPage.getTelefonoPrincipalFirstField().should(visible, empty);
        preferencesPage.getTelefonoPrincipalSecondField().should(visible, empty);
        preferencesPage.getTelefonoPrincipalThirdField().shouldNot(visible);
        preferencesPage.getTelefonoSecundarioFirstField().should(visible, empty);
        preferencesPage.getTelefonoSecundarioSecondField().should(visible, empty);
        preferencesPage.getTelefonoSecundarioThirdField().shouldNot(visible);
        assertTrue(preferencesPage.getGuardarCambiosButtonOnContactoSection().isEnabled());
    }
}
