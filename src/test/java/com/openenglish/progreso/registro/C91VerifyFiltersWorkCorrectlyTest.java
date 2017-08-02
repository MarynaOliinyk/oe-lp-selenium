package com.openenglish.progreso.registro;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HistoryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.History.HISTORY_BORRAR_TODO_TEXT;
import static com.openenglish.core.TestData.History.HISTORY_HEADER_TEXT;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static org.testng.Assert.assertTrue;

public class C91VerifyFiltersWorkCorrectlyTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyFiltersWorkCorrectlyTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getRegistroLink().click();
        HistoryPage historyPage = new HistoryPage();
        historyPage.getHeaderBlock().shouldBe(visible).shouldHave(text(HISTORY_HEADER_TEXT + " " + USER_NAME));
        historyPage.getTypeButton().should(visible).click();
        historyPage.getTypeList().should(visible);
        String firstSelectedType = historyPage.getFirstPracticeType().innerText();
        historyPage.getFirstPracticeType().should(visible).click();
        historyPage.getBorrarTodoText().should(visible, text(HISTORY_BORRAR_TODO_TEXT));
        assertTrue(historyPage.getSelectedTypeInHistory().stream().allMatch(selectedType -> selectedType.getText().equals(firstSelectedType)));
        String secondSelectedType = historyPage.getSecondUnitAsessmentType().getText();
        historyPage.getSecondUnitAsessmentType().should(visible).click();
        assertTrue(historyPage.getSelectedTypeInHistory().stream().allMatch(selectedType -> selectedType.getText().equals(firstSelectedType) || selectedType.getText().equals(secondSelectedType)));
        historyPage.getDeleteOneType().click();
        assertTrue(historyPage.getSelectedTypeInHistory().stream().allMatch(selectedType -> selectedType.getText().equals(firstSelectedType)));
        historyPage.getBorrarTodoText().click();
        historyPage.getRefinementsIsDeleted().shouldNot(visible);
        historyPage.getHistoryTable().should(visible);
    }
}