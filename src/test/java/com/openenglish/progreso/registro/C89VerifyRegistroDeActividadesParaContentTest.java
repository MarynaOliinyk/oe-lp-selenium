package com.openenglish.progreso.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HistoryPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.HREF;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.History.HISTORY_HEADER_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_HEADER_LINK_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_TABLE_HEADER_DESCRIPCION_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_TABLE_HEADER_FECHA_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_TABLE_HEADER_RESULTS_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_TABLE_HEADER_TIPO_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_TABLE_HEADER_TITULO_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_URL_ENDS_WITH;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static org.testng.Assert.assertEquals;

public class C89VerifyRegistroDeActividadesParaContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void registroDeActividadesParaContentVerifyTest() {
        open(LP_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        page.inicioPage.getProgresoLink().hover();
        page.inicioPage.getRegistroLink().click();

        HistoryPage historyPage = new HistoryPage();
        historyPage.getHeaderBlock().shouldBe(visible);

        historyPage.getHeaderRegistroDeActividadesText().shouldBe(visible)
                .shouldHave(exactText(HISTORY_HEADER_TEXT + " " + USER_NAME));
        historyPage.getHeaderVerIndiceDelCursoLink().shouldBe(visible)
                .shouldHave(exactText(HISTORY_HEADER_LINK_TEXT));
        assertEquals(historyPage.getHeaderVerIndiceDelCursoLink().getAttribute(HREF), LP_URL + HISTORY_URL_ENDS_WITH);

        historyPage.getPaginationBlock().shouldBe(visible);

        historyPage.getSearchBlock().shouldBe(visible);

        historyPage.getRefinementsBlock().shouldBe(visible);

        historyPage.getTableBlock().shouldBe(visible);
        historyPage.getFechaHeaderCellText().shouldBe(visible).shouldHave(exactText(HISTORY_TABLE_HEADER_FECHA_TEXT));
        historyPage.getTipoHeaderCellText().shouldBe(visible).shouldHave(exactText(HISTORY_TABLE_HEADER_TIPO_TEXT));
        historyPage.getTituloHeaderCellText().shouldBe(visible).shouldHave(exactText(HISTORY_TABLE_HEADER_TITULO_TEXT));
        historyPage.getDescriptionHeaderCellText().shouldBe(visible).shouldHave(exactText(HISTORY_TABLE_HEADER_DESCRIPCION_TEXT));
        historyPage.getResultsAndActionsHeaderCellText().shouldBe(visible).shouldHave(exactText(HISTORY_TABLE_HEADER_RESULTS_TEXT));

        historyPage.getDayCompletedAllElements().shouldBe(visible);
        historyPage.getTimeCompletedAllElements().shouldBe(visible);
        historyPage.getTipoTableAllElements().shouldBe(visible);
        historyPage.getTituloTableAllElements().shouldBe(visible);
        historyPage.getDescriptionTableAllElements().shouldBe(visible);
        historyPage.getResultsAndActionsTableAllElements().shouldBe(visible);
    }

}
