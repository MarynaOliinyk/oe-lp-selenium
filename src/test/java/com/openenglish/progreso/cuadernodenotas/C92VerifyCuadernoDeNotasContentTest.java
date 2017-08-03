package com.openenglish.progreso.cuadernodenotas;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.MyNotebookPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.EMAIL_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.PASSWORD_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME_WITHOUT_NOTES;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOKTEXT_IF_NOT_NOTES;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_HEADER_TEXT;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT;
import static org.testng.Assert.assertTrue;

public class C92VerifyCuadernoDeNotasContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test(enabled = false)
    public void verifyCuadernoDeNotasContentTestS1() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(EMAIL_WITHOUT_NOTES, PASSWORD_WITHOUT_NOTES);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME_WITHOUT_NOTES));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().shouldBe(visible).shouldHave(text(MY_NOTEBOOK_HEADER_TEXT + " " + USER_NAME_WITHOUT_NOTES));
        assertTrue(myNotebookPage.getVerElIndiceDelCursoLink().should(text(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT)).getAttribute("href")
                .contains(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK));
        myNotebookPage.getTextIfNotNotes().should(visible, text(MY_NOTEBOOKTEXT_IF_NOT_NOTES));
    }

    @Test
    public void verifyCuadernoDeNotasContentTestS2() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().shouldBe(visible).shouldHave(text(MY_NOTEBOOK_HEADER_TEXT + " " + USER_NAME_WITHOUT_NOTES));
        assertTrue(myNotebookPage.getVerElIndiceDelCursoLink().should(text(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT)).getAttribute("href")
                .contains(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK));
        myNotebookPage.getPagination().should(visible);
        myNotebookPage.getNotes().should(visible);
        myNotebookPage.getFechaColumn().should(visible);
        myNotebookPage.getDateAndHourOfNoteCreationData().should(visible);
        myNotebookPage.getUnitAndLessonColumn().should(visible);
        myNotebookPage.getUnitAndLessonNumberData().should(visible);
        myNotebookPage.getTitleLessonColumn().should(visible);
        myNotebookPage.getLessonTitleData().should(visible);
        myNotebookPage.getNoteColumn().should(visible);
        myNotebookPage.getNoteDescription().should(visible);
    }
}
