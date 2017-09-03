package com.openenglish.cuenta.mensajes;

import com.codeborne.selenide.ElementsCollection;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.MensajesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.READ_ONLY_USER;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_FIRST_PAGE_PAGINATION_BLOCK_TEXT;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_MAX_MENSAJES_NUMBER;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_MENSAJES_BUTTON_TEXT;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_ONE_PEGE_VALUE;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_SECOND_PAGE_PAGINATION_BLOCK_TEXT;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_TWO_PEGES_VALUE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C56VerifyPaginationOfMessagesTest extends DriverBase {

    @Test
    public void verifyPaginationOfMessagesTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(READ_ONLY_USER, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getMensajesCuentaSuboptionButton().click();

        MensajesPage mp = new MensajesPage();
        mp.getPageTitle().shouldBe(visible, exactText(MENSAJES_MENSAJES_BUTTON_TEXT));
        ElementsCollection allTheMessagesOnTheFirstPage = mp.getAllTheMessagesOnThePage();
        assertEquals(String.valueOf(allTheMessagesOnTheFirstPage.size()), MENSAJES_MAX_MENSAJES_NUMBER);
        assertTrue(Integer.valueOf(mp.getPaginationTotalPagesValue().getText()) >= 2);
        assertTrue(mp.getPaginationBlock().getText().matches(MENSAJES_FIRST_PAGE_PAGINATION_BLOCK_TEXT));
        mp.getPaginationNextPage().click();
        mp.getPaginationCurrentPageValue().shouldBe(visible, exactText(MENSAJES_TWO_PEGES_VALUE));
        assertTrue(mp.getPaginationBlock().getText().matches(MENSAJES_SECOND_PAGE_PAGINATION_BLOCK_TEXT));
        ElementsCollection allTheMessagesOnTheSecondPage = mp.getAllTheMessagesOnThePage();
        assertTrue(allTheMessagesOnTheSecondPage.size() >= 1);
        mp.getPaginationPreviusPage().click();
        ElementsCollection allTheMessagesOnTheFirstPageSecondTime = mp.getAllTheMessagesOnThePage();
        assertEquals(String.valueOf(allTheMessagesOnTheFirstPageSecondTime.size()), MENSAJES_MAX_MENSAJES_NUMBER);
        mp.getPaginationCurrentPageValue().shouldBe(visible, exactText(MENSAJES_ONE_PEGE_VALUE));
        assertTrue(mp.getPaginationBlock().getText().matches(MENSAJES_FIRST_PAGE_PAGINATION_BLOCK_TEXT));
    }

}