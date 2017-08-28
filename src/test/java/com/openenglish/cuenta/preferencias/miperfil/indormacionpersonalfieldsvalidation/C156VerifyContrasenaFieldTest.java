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
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEWPASSWORD_LESS_THEN_SIX_CHARS;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEWPASSWORD_LESS_THEN_SIX_CHARS_NOTIFICATION;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEWPASSWORD_SPECIAL_SYMBOLS_NOTIFICATION;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEWPASSWORD_WITHOUT_NUMBERS;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEWPASSWORD_WITHOUT_NUMBERS_NOTIFICATION;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_SPECIAL_SYMBOLS;

public class C156VerifyContrasenaFieldTest extends DriverBase {

    @Test
    public void verifyContrasenaFieldTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getMiPerfilTabActive().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        pp.getContrasenaField().clear();
        pp.getContrasenaField().sendKeys(PREFERENCES_NEWPASSWORD_WITHOUT_NUMBERS);
        pp.getGuardarCambiosButton().click();
        pp.getContrasenaFieldNotification().shouldBe(visible, exactText(PREFERENCES_NEWPASSWORD_WITHOUT_NUMBERS_NOTIFICATION));
        pp.getContrasenaField().sendKeys(PREFERENCES_NEWPASSWORD_LESS_THEN_SIX_CHARS);
        pp.getGuardarCambiosButton().click();
        pp.getContrasenaFieldNotification().shouldBe(visible, exactText(PREFERENCES_NEWPASSWORD_LESS_THEN_SIX_CHARS_NOTIFICATION));
        pp.getContrasenaField().clear();
        pp.getContrasenaField().sendKeys(PREFERENCES_SPECIAL_SYMBOLS);
        pp.getGuardarCambiosButton().click();
        pp.getContrasenaFieldNotification().shouldBe(visible, exactText(PREFERENCES_NEWPASSWORD_SPECIAL_SYMBOLS_NOTIFICATION));
    }

}
