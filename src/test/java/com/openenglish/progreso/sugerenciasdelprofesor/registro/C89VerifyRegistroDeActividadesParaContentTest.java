package com.openenglish.progreso.sugerenciasdelprofesor.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HistoryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.History.historyHeaderLinkText;
import static com.openenglish.core.TestData.History.historyHeaderText;
import static com.openenglish.core.TestData.History.historyTableHeaderDescripcionText;
import static com.openenglish.core.TestData.History.historyTableHeaderFechaText;
import static com.openenglish.core.TestData.History.historyTableHeaderResultsText;
import static com.openenglish.core.TestData.History.historyTableHeaderTipoText;
import static com.openenglish.core.TestData.History.historyTableHeaderTituloText;
import static com.openenglish.core.TestData.History.historyUrlEndsWith;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static org.testng.Assert.assertEquals;

public class C89VerifyRegistroDeActividadesParaContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void registroDeActividadesParaContentVerifyTest() {
        open(lpUrl);

        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(registeredEmail, correctPassword);

        page.inicioPage.getProgresoLink().hover();
        page.inicioPage.getRegistroLink().click();

        HistoryPage historyPage = new HistoryPage();
        historyPage.getHeaderBlock().shouldBe(visible);

        historyPage.getHeaderRegistroDeActividadesText().shouldBe(visible)
                .shouldHave(exactText(historyHeaderText + " " + userName));
        historyPage.getHeaderVerIndiceDelCursoLink().shouldBe(visible)
                .shouldHave(exactText(historyHeaderLinkText));
        assertEquals(historyPage.getHeaderVerIndiceDelCursoLink().getAttribute("href"), lpUrl + historyUrlEndsWith);

        historyPage.getPaginationBlock().shouldBe(visible);

        historyPage.getSearchBlock().shouldBe(visible);

        historyPage.getRefinementsBlock().shouldBe(visible);

        historyPage.getTableBlock().shouldBe(visible);
        historyPage.getFechaHeaderCellText().shouldBe(visible).shouldHave(exactText(historyTableHeaderFechaText));
        historyPage.getTipoHeaderCellText().shouldBe(visible).shouldHave(exactText(historyTableHeaderTipoText));
        historyPage.getTituloHeaderCellText().shouldBe(visible).shouldHave(exactText(historyTableHeaderTituloText));
        historyPage.getDescriptionHeaderCellText().shouldBe(visible).shouldHave(exactText(historyTableHeaderDescripcionText));
        historyPage.getResultsAndActionsHeaderCellText().shouldBe(visible).shouldHave(exactText(historyTableHeaderResultsText));

        historyPage.getDayCompletedAllElements().shouldBe(visible);
        historyPage.getTimeCompletedAllElements().shouldBe(visible);
        historyPage.getTipoTableAllElements().shouldBe(visible);
        historyPage.getTituloTableAllElements().shouldBe(visible);
        historyPage.getDescriptionTableAllElements().shouldBe(visible);
        historyPage.getResultsAndActionsTableAllElements().shouldBe(visible);
    }

}
