package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.VALUE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_EMAIL_WITHOUT_AT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_EMAIL_WITHOUT_COM;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEW_EMAIL_NOT_CORESPONDENT_NOTIFICATION;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEW_EMAIL_VALID;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_WRONG_EMAIL_NOTIFICATION_TEXT;

public class C155VerifyConfirmarEmailFieldTest extends DriverBase {

    private PreferencesPage pp = new PreferencesPage();

    @Test
    public void verifyConfirmarEmailFieldTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        pp.getMiPerfilTabActive().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        String defaultEmail = pp.getEmailField().getAttribute(VALUE);
        pp.getEmailField().clear();
        pp.getEmailField().sendKeys(PREFERENCES_NEW_EMAIL_VALID);
        pp.getConfirmEmailField().shouldBe(visible);
        pp.getConfirmEmailField().sendKeys(PREFERENCES_EMAIL_WITHOUT_AT);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getConfirmEmailFieldNotification().shouldBe(visible, exactText(PREFERENCES_WRONG_EMAIL_NOTIFICATION_TEXT));
        pp.getConfirmEmailField().clear();
        pp.getConfirmEmailField().sendKeys(PREFERENCES_EMAIL_WITHOUT_COM);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getConfirmEmailFieldNotification().shouldBe(visible, exactText(PREFERENCES_WRONG_EMAIL_NOTIFICATION_TEXT));
        pp.getConfirmEmailField().clear();
        pp.getConfirmEmailField().sendKeys(defaultEmail);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getConfirmEmailFieldNotification().shouldBe(visible, exactText(PREFERENCES_NEW_EMAIL_NOT_CORESPONDENT_NOTIFICATION));
        pp.getConfirmEmailField().clear();
        pp.getConfirmEmailField().sendKeys(PREFERENCES_NEW_EMAIL_VALID);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getConfirmEmailFieldNotification().shouldNotBe(visible);
        postcondition(defaultEmail);
    }

    private void postcondition(String emailToRollBack) {
        pp.getEmailField().clear();
        pp.getEmailField().sendKeys(emailToRollBack);
        pp.getConfirmEmailField().sendKeys(emailToRollBack);
        pp.getGuardarCambiosButtonOnPersonalSection().click();
        pp.getConfirmEmailFieldNotification().shouldNotBe(visible);
    }
}
