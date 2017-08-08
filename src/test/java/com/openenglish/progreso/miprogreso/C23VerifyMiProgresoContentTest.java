package com.openenglish.progreso.miprogreso;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ProfilePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Profile.PROFILE_ESTADISTICAS_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_LESSONS_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE;
import static com.openenglish.core.TestData.Profile.PROFILE_NIVEL_ACTUAL_COLUMN;
import static com.openenglish.core.TestData.Profile.PROFILE_PRUEBA_DE_NIVEL_BUTTON;
import static com.openenglish.core.TestData.Profile.PROFILE_PRUEBA_DE_NIVEL_COLUMN;
import static com.openenglish.core.TestData.Profile.PROFILE_TOMAR_PRUEBA_DE_NIVEL_BUTTON;
import static com.openenglish.core.TestData.Profile.PROFILE_ULTIMO_INGRESO_COLUMN;
import static com.openenglish.core.TestData.Profile.PROFILE_ULTIMO_NIVEL_COMPLETADO_COLUMN;
import static com.openenglish.core.TestData.Profile.PROFILE_VER_EL_INDICE_DEL_CURSO_LINK;
import static com.openenglish.core.TestData.Profile.PROFILE_VER_EL_INDICE_DEL_CURSO_TEXT;
import static org.testng.Assert.assertTrue;

public class C23VerifyMiProgresoContentTest extends DriverBase {
    ProfilePage profilePage = new ProfilePage();
    private AbstractPage page = new AbstractPage();

    private void loginWithCorrectCredentialsAndProfilePageIsOpen() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getMiProgressoLink().click();
        profilePage.getHeaderText().should(visible).shouldHave(text(PROFILE_HEADER_TEXT));
    }

    @Test
    public void progressLevelTestS1() {
        loginWithCorrectCredentialsAndProfilePageIsOpen();
        assertTrue(profilePage.getVerElIndiceDelCursoLink().should(text(PROFILE_VER_EL_INDICE_DEL_CURSO_TEXT)).getAttribute("href")
                .contains(PROFILE_VER_EL_INDICE_DEL_CURSO_LINK));
        profilePage.getLevels().should(visible).getText().matches(PROFILE_LESSONS_HEADER_TEXT);
        profilePage.getProfilePicture().should(visible);
        profilePage.getInfoBlock().should(visible);
        profilePage.getPracticeProgress().should(visible);
        profilePage.getLiveClassesProgress().should(visible);
        profilePage.getUnitsProgress().should(visible);
        profilePage.getTomarPruabaDeNivelButton().should(text(PROFILE_TOMAR_PRUEBA_DE_NIVEL_BUTTON), disabled);
    }

    @Test
    public void estadisticasTestS2() {
        loginWithCorrectCredentialsAndProfilePageIsOpen();
        profilePage.getEstadisticasHeaderText().should(visible, text(PROFILE_ESTADISTICAS_HEADER_TEXT));
        profilePage.getVerPorMesButton().should(visible);
        profilePage.getVerPorSemanaButton().should(visible);
        profilePage.getMesTimeBlock().should(visible);
        profilePage.getPrevArrowButton().should(visible);
        profilePage.getItemList().should(visible);
        profilePage.getNivelActualColumn().should(visible, text(PROFILE_NIVEL_ACTUAL_COLUMN));
        profilePage.getUltimoNivelCompletadoColumn().should(visible, text(PROFILE_ULTIMO_NIVEL_COMPLETADO_COLUMN));
        profilePage.getPruebaDeNivelColumn().should(visible, text(PROFILE_PRUEBA_DE_NIVEL_COLUMN));
        profilePage.getUltimoIngresoColumn().should(visible, text(PROFILE_ULTIMO_INGRESO_COLUMN));
        profilePage.getStatisticsGraph().should(visible);
        profilePage.getPruebaDeNivelButton().should(visible, text(PROFILE_PRUEBA_DE_NIVEL_BUTTON));
    }

    @Test
    public void certificatesTestS3() {
        loginWithCorrectCredentialsAndProfilePageIsOpen();
        profilePage.getCertificatesCarousel().should(visible);
        profilePage.getMessageOverActualCertificate().should(visible).getText().matches(PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE);
        profilePage.getPrevButton().should(visible);
        profilePage.getNextButton().should(visible);
    }
}
