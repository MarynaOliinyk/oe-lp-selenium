package com.openenglish.cuenta.preferencias.perfildeaprendizaje;

import com.codeborne.selenide.ElementsCollection;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.Attribute.CLASS;
import static com.openenglish.core.Attribute.DISABLED;
import static com.openenglish.core.Attribute.VALUE;
import static com.openenglish.core.AttributeValue.PreferencesPage.PREFERENCES_PAGE_OPTION_CHOOSE_VALUE;
import static com.openenglish.core.AttributeValue.PreferencesPage.PREFERENCES_PAGE_PRESSED_VALUE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.READ_ONLY_USER;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_GENERAL_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PERFIL_DE_APRENDIZAJE;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PERFIL_DE_APRENDIZAJE_LINK;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_SELECCIONAR_TEXT;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C62VerifyGeneralFormTest extends DriverBase {

    @Test
    public void verifyGeneralFormTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(READ_ONLY_USER, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getPreferenciasCuentaSuboptionButton().shouldBe(visible).click();
        PreferencesPage pp = new PreferencesPage();
        pp.getActiveTab().shouldBe(visible, exactText(PREFERENCES_MI_PERFIL_TAB_TEXT));
        pp.getNotActiveTab().shouldBe(visible, exactText(PREFERENCES_PERFIL_DE_APRENDIZAJE)).click();

        assertTrue(url().endsWith(PREFERENCES_PERFIL_DE_APRENDIZAJE_LINK));
        pp.getGeneralSection().should(visible).scrollTo();
        pp.getGeneralSectionHeader().should(visible, exactText(PREFERENCES_GENERAL_TEXT));
        pp.getGeneralSectionGuardarCambiosButton()
                .should(visible, attribute(VALUE, PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT),
                        attribute(DISABLED), not(enabled));

        ElementsCollection listOfAllTheBoxesTextInGeneralForm = pp.getListOfAllTheBoxesToChooseTextInGeneralOfAprendizajeTab();
        listOfAllTheBoxesTextInGeneralForm.forEach(elemet -> elemet.shouldBe(visible, not(empty),
                not(exactText(PREFERENCES_SELECCIONAR_TEXT)), attribute(CLASS)));
        listOfAllTheBoxesTextInGeneralForm.stream().findFirst().get().hover().shouldNotBe(visible);
        ElementsCollection listOfAllTheBoxesHoverTextInGeneralForm = pp.getListOfAllTheBoxesToChooseHoverTextInGeneralOfAprendizajeTab();
        assertEquals(listOfAllTheBoxesTextInGeneralForm.size(), listOfAllTheBoxesHoverTextInGeneralForm.size());
        listOfAllTheBoxesHoverTextInGeneralForm.stream().findFirst().get().should(not(empty),
                exactText(PREFERENCES_SELECCIONAR_TEXT), attribute(CLASS, PREFERENCES_PAGE_OPTION_CHOOSE_VALUE));
        listOfAllTheBoxesHoverTextInGeneralForm.stream().findFirst().get().click();
        ElementsCollection listOfAllTheBoxesAfterFirstPressInGeneralForm = pp.getListOfAllTheBoxesToChooseInGeneralOfAprendizajeTab();
        listOfAllTheBoxesAfterFirstPressInGeneralForm.stream().findFirst().get().
                shouldHave(attribute(CLASS, PREFERENCES_PAGE_PRESSED_VALUE));
        listOfAllTheBoxesTextInGeneralForm.get(1).click();
        listOfAllTheBoxesAfterFirstPressInGeneralForm.stream().findFirst().get().
                shouldNotHave(attribute(CLASS, PREFERENCES_PAGE_PRESSED_VALUE));
        pp.getGeneralSectionGuardarCambiosButton()
                .should(visible, enabled, attribute(VALUE, PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT)).
                shouldNotHave(attribute(DISABLED));
    }

}