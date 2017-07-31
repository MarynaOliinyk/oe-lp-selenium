package com.openenglish.progreso.registro;


import com.codeborne.selenide.CollectionCondition;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HistoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.History.historyHeaderText;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.userNickName;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.sun.tools.doclint.Entity.or;
import static org.testng.Assert.assertTrue;

public class C91VerifyFiltersWorkCorrectlyTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyFiltersWorkCorrectlyTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserName().shouldHave(text(userNickName));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getRegistroLink().click();
        HistoryPage historyPage = new HistoryPage();
        historyPage.getHeaderText().shouldBe(visible).shouldHave(text(historyHeaderText + " " + userName));
        historyPage.getTypeButton().should(visible).click();
        historyPage.getTypeList().should(visible);
        String firstSelectedType = historyPage.getSelectFirstType().innerText();
        historyPage.getSelectFirstType().should(visible).click();
        historyPage.getBorrarTodoText().should(visible);
        assertTrue(historyPage.getSelectedTypeInHistory().stream().allMatch(selectedType -> selectedType.getText().equals(firstSelectedType)));
        historyPage.getSelectSecondType().should(visible).click();
        String secondSelectedType = historyPage.getSelectFirstType().getText();
        assertTrue(historyPage.getSelectedTypeInHistory().stream().allMatch(selectedType -> selectedType.getText().equals(firstSelectedType) || selectedType.getText().equals(secondSelectedType)));
        historyPage.getDeleteOneType().click();
        assertTrue(historyPage.getSelectedTypeInHistory().stream().allMatch(selectedType -> selectedType.getText().equals(firstSelectedType)));
        historyPage.getBorrarTodoText().click();
        historyPage.getRefinementsIsDeleted().shouldNot(visible);
        historyPage.getHistoryTable().should(visible);

    }
}
