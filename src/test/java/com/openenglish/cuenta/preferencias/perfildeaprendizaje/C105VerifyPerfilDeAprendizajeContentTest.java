package com.openenglish.cuenta.preferencias.perfildeaprendizaje;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.VALUE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_COMPROMISOS_Y_MOTIVACIONES;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_GENERAL_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PERFIL_DE_APRENDIZAJE;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_USER_NICK_NAME_AND_HOLA;

public class C105VerifyPerfilDeAprendizajeContentTest extends DriverBase {

    @Test
    public void verifyPerfilDeAprendizajeContentTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getActiveTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        pp.getNotActiveTab().shouldBe(visible, exactText(PREFERENCES_PERFIL_DE_APRENDIZAJE)).click();
        pp.getUserNameAndHolaText().should(visible, exactText(PREFERENCES_USER_NICK_NAME_AND_HOLA));
        pp.getPhotoFrameForPerfilDeAprendizaje().should(visible);
        pp.getCompromisosYMotivacionesSection().should(visible);
        pp.getCompromisosYMotivacionesSectionHeader().should(visible, exactText(PREFERENCES_COMPROMISOS_Y_MOTIVACIONES));
        //TODO: https://openenglish.jira.com/browse/LPTRIAGE-332
//        pp.getCompromisosYMotivacionesSectionGuardarCambiosButton()
//                .should(disabled, attribute(VALUE, PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT));
        pp.getGeneralSectionHeader().should(visible, exactText(PREFERENCES_GENERAL_TEXT));
        //TODO: https://openenglish.jira.com/browse/LPTRIAGE-332
//        pp.getGeneralSectionGuardarCambiosButton()
//                .should(visible, attribute(VALUE, PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT));
    }

}