package com.openenglish.cuenta.preferencias.miperfil.indormacionpersonalfieldsvalidation;

import com.codeborne.selenide.ElementsCollection;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.TYPE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_CONFIRM_NEW_PASSWORD_NOTIFICATION;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_NEW_PASSWORD_VALID;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PASSWORDS_NOT_EQUALS_NOTIFICATION;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PASSWORD_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_SECOND_NEW_PASSWORD_VALID;
import static org.testng.Assert.assertTrue;

public class C158VerifyIdiomaDePreferenciaFieldTest extends DriverBase {

    @Test
    public void verifyConfirmarContrasenaFieldTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getMiPerfilTabActive().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));

        pp.getIdiomaDePreferenciaField().shouldBe(visible).click();
        ElementsCollection idiomasList = pp.getAllTheIdiomasList();
        assertTrue(idiomasList.stream().allMatch(element -> element.is(not(empty))));
        String firsrIdioma = idiomasList.stream().findFirst().get().getText();
        idiomasList.stream().findFirst().get().click();
        pp.getIdiomaDePreferenciaField().shouldHave(text(firsrIdioma));
    }

}