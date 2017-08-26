package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.CLASS;
import static com.openenglish.core.AttributeValue.PreferencesPage.PREFERENCES_PAGE_DATE_PICKER;
import static com.openenglish.core.AttributeValue.PreferencesPage.PREFERENCES_PAGE_DATE_PICKER_VALID;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;

public class C153VerifyFechaDeNacimientoTest extends DriverBase {

    @Test
    public void verifyFechaDeNacimientoTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getMiPerfilTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        pp.getFechaDeNacimientoField().shouldBe(visible, attribute(CLASS,  PREFERENCES_PAGE_DATE_PICKER)).click();
        pp.getCalendar().shouldBe(visible);
        pp.getFirstAvailableDate().shouldBe(visible).click();
        pp.getFechaDeNacimientoField().shouldBe(visible, attribute(CLASS, PREFERENCES_PAGE_DATE_PICKER_VALID));
    }

}
