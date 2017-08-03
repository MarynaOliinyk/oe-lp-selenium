package com.openenglish.progreso.sugerenciasdelprofesor.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.HistoryPage;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.VideoPopUp;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.History.HISTORY_TABLE_RESULTS_REPRODUCIR_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_TIPO_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Selenide.WAIT_UNTIL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class C2225CheckThatUserCanReplayTestPrepCoursesTest extends DriverBase {

    @Test
    public void checkThatStudentCanSeeTestPrepCoursesTest() {
        open(LP_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        InicioPage inicioPage = new InicioPage();
        inicioPage.getProgresoLink().hover();
        inicioPage.getRegistroLink().click();

        HistoryPage historyPage = new HistoryPage();
        historyPage.getTableBlock().shouldBe(visible);
        historyPage.getSearchTypePractice().shouldNotBe(visible);
        assertFalse(historyPage.isAllTheListContainsText($$(By.xpath(historyPage.getTipoTableEllements())), HISTORY_TIPO_TEXT));
        historyPage.getAddTypeButton().click();
        historyPage.getSearchTypePractice().shouldBe(visible).click();
        historyPage.getAddTypeButton().click();
        assertTrue(historyPage.isAllTheListContainsText($$(By.xpath(historyPage.getTipoTableEllements())), HISTORY_TIPO_TEXT));
        assertEquals(historyPage.getResultsAndActionsTableAllElements().getText(), HISTORY_TABLE_RESULTS_REPRODUCIR_TEXT);
        historyPage.getResultsAndActionsTableAllElements().click();

        VideoPopUp videoPopUp = new VideoPopUp();
        switchTo().frame(videoPopUp.getVideoIframe());
        videoPopUp.getPausaButton().waitUntil(visible, WAIT_UNTIL).click();
        videoPopUp.getReproducirButton().waitUntil(visible, WAIT_UNTIL);
    }

}
