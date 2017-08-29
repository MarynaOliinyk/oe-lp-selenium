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
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_EMAIL_WITHOUT_AT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_EMAIL_WITHOUT_COM;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_OBLIGATORIO_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_WRONG_EMAIL_NOTIFICATION_TEXT;

public class C154VerifyEmailFieldTest extends DriverBase {

    @Test
    public void verifyEmailFieldTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getMiPerfilTabActive().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        pp.getEmailField().clear();
        pp.getApellidoField().click();
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getEmailFieldNotification().shouldBe(visible, exactText(PREFERENCES_OBLIGATORIO_TEXT));
        pp.getEmailField().sendKeys(PREFERENCES_EMAIL_WITHOUT_AT);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getEmailFieldNotification().shouldBe(visible, exactText(PREFERENCES_WRONG_EMAIL_NOTIFICATION_TEXT));
        pp.getEmailField().clear();
        pp.getEmailField().sendKeys(PREFERENCES_EMAIL_WITHOUT_COM);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getEmailFieldNotification().shouldBe(visible, exactText(PREFERENCES_WRONG_EMAIL_NOTIFICATION_TEXT));
    }
}
