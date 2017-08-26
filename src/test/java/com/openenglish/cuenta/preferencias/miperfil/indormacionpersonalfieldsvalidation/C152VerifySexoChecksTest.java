package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.*;
import static com.openenglish.core.TestData.Preferences.*;

public class C152VerifySexoChecksTest extends DriverBase {

    @Test
    public void verifySexoChecksTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getMiPerfilTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        pp.getFemeninoField().shouldBe(visible).click();
        pp.getFemeninoCheckbox().shouldBe(checked);

        pp.getMasculinoField().shouldBe(visible).click();
        pp.getMasculinoCheckbox().shouldBe(checked);
    }

}
