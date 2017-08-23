package com.openenglish.progreso.miprogreso;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ProfilePage;
import com.openenglish.util.CompareUtil;
import com.openenglish.util.Result;
import java.io.File;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Profile.PROFILE_ACTUAL_MONTH;
import static com.openenglish.core.TestData.Profile.PROFILE_ESTADISTICAS_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_OVER_SEMANA_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_POP_UP_CANCEL_BUTTON_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_POP_UP_CONTINUE_BUTTON_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_POP_UP_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_PREVIOUS_MONTH;
import static org.testng.AssertJUnit.assertEquals;

public class C83VerifyEstadisticasTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyEstadisticasTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible, text(PROFILE_HEADER_TEXT));
        profilePage.getEstadisticasHeaderText().scrollTo();
        profilePage.getMesTimeBlock().should(visible);
        profilePage.getMonthInEstradisticas().should(visible, text(PROFILE_ACTUAL_MONTH));
        profilePage.getPrevArrowButton().should(visible).click();
        profilePage.getMonthInEstradisticas().should(visible, text(PROFILE_PREVIOUS_MONTH));
        profilePage.getNextArrowButton().should(visible).click();
        profilePage.getMonthInEstradisticas().should(visible, text(PROFILE_ACTUAL_MONTH));
        profilePage.getNextArrowButton().shouldNot(disabled);
        File mes = profilePage.getCanvasGraph().should(visible).screenshot();
        profilePage.getVerPorSemanaButton().should(visible).click();
        profilePage.getOverSemanaText().shouldHave(text(PROFILE_OVER_SEMANA_TEXT));
        File semana = profilePage.getCanvasGraph().should(visible).screenshot();
        assertEquals(Result.PixelMismatch, CompareUtil.CompareImage(mes.getAbsolutePath(), semana.getAbsolutePath()));
        profilePage.getPruebaDeNivelButton().should(visible).click();
        profilePage.getPopUpHeaderText().should(visible, text(PROFILE_POP_UP_HEADER_TEXT));
        profilePage.getPopUpInstuction().should(visible);
        profilePage.getClosePopupButton().should(visible, text(PROFILE_POP_UP_CANCEL_BUTTON_TEXT));
        profilePage.getContinuePopupButton().should(visible, text(PROFILE_POP_UP_CONTINUE_BUTTON_TEXT));
        profilePage.getCloseIcon().should(visible).click();
        profilePage.getEstadisticasHeaderText().should(visible, text(PROFILE_ESTADISTICAS_HEADER_TEXT));
    }
}
