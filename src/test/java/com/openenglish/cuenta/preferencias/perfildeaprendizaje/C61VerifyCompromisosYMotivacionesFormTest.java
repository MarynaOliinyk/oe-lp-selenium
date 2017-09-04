package com.openenglish.cuenta.preferencias.perfildeaprendizaje;

import com.codeborne.selenide.ElementsCollection;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.PreferencesPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.Attribute.CLASS;
import static com.openenglish.core.Attribute.VALUE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.READ_ONLY_USER;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_COMPROMISOS_Y_MOTIVACIONES;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_GENERAL_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_MI_PERFIL_TAB_TEXT;
import static com.openenglish.core.TestData.Preferences.PREFERENCES_PERFIL_DE_APRENDIZAJE;
import static org.testng.Assert.assertTrue;

public class C61VerifyCompromisosYMotivacionesFormTest extends DriverBase {

    @Test
    public void verifyPerfilDeAprendizajeContentTest() {
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

        assertTrue(url().endsWith("/account/history.html"));
        pp.getCompromisosYMotivacionesSection().should(visible);
        pp.getCompromisosYMotivacionesSectionHeader().should(visible, exactText(PREFERENCES_COMPROMISOS_Y_MOTIVACIONES));
        pp.getCompromisosYMotivacionesSectionGuardarCambiosButton()
                .should(visible, attribute(VALUE, PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT), attribute("disabled"));
        pp.getGeneralSectionHeader().should(visible, exactText(PREFERENCES_GENERAL_TEXT));
        pp.getGeneralSectionGuardarCambiosButton()
                .should(visible, attribute(VALUE, PREFERENCES_GUARDAR_CAMBIOS_BUTTON_TEXT), attribute("disabled"), not(enabled));

        ElementsCollection listOfAllTheBoxesToChooseText = pp.getListOfAllTheBoxesToChooseTextInAprendizajeTab();
        listOfAllTheBoxesToChooseText.forEach(elemet -> elemet.shouldBe(visible, not(empty), not(exactText("seleccionar")),
                attribute(CLASS)));
//        System.out.println(listOfAllTheBoxesToChooseText.stream().findFirst().get().getAttribute(CLASS));
//        System.out.println(listOfAllTheBoxesToChooseText.stream().findFirst().get().hover().getAttribute(CLASS));
        listOfAllTheBoxesToChooseText.stream().findFirst().get().hover().shouldNotBe(visible);

        ElementsCollection listOfAllTheBoxesToChooseHoverText = pp.getListOfAllTheBoxesToChooseHoverTextInAprendizajeTab();
        listOfAllTheBoxesToChooseHoverText.stream().findFirst().get().should(not(empty),
                exactText("seleccionar"), attribute(CLASS, "option-choose"));
        listOfAllTheBoxesToChooseHoverText.stream().findFirst().get().click();
        ElementsCollection listOfAllTheBoxesToChooseAfterFirstPress = pp.getListOfAllTheBoxesToChooseInAprendizajeTab();
        listOfAllTheBoxesToChooseAfterFirstPress.stream().findFirst().get().shouldHave(attribute(CLASS, "pressed"));
        listOfAllTheBoxesToChooseText.get(1).click();
        listOfAllTheBoxesToChooseAfterFirstPress.stream().findFirst().get().shouldNotHave(attribute(CLASS, "pressed"));


    }

}