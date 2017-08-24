package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.INVALID_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.NO_ES_NOMBRE_VALIDO_TEXT;
import static com.openenglish.core.TestData.Preferences.OBLIGATORIO_TEXT;
import static com.openenglish.core.TestData.Preferences.SPECIAL_SYMBOLS;

public class C150VerifyNombreFieldTest extends DriverBase {

    @Test
    public void verifyNombreFieldTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getMiPerfilTab().shouldBe(visible, exactText(MI_PERFIL_TAB_TEXT));

        pp.getNombreField().clear();
        pp.getApellidoField().click();
        pp.getGuardarCambiosButton().click();
        pp.getNombreFieldNotification().shouldBe(visible, exactText(OBLIGATORIO_TEXT));
        pp.getNombreField().sendKeys(INVALID_PASSWORD);
        pp.getGuardarCambiosButton().click();
        pp.getNombreFieldNotification().shouldBe(visible, exactText(NO_ES_NOMBRE_VALIDO_TEXT));
        pp.getNombreField().clear();
        pp.getNombreField().sendKeys(SPECIAL_SYMBOLS);
        pp.getGuardarCambiosButton().click();
        pp.getNombreFieldNotification().shouldBe(visible, exactText(NO_ES_NOMBRE_VALIDO_TEXT));
    }

}
