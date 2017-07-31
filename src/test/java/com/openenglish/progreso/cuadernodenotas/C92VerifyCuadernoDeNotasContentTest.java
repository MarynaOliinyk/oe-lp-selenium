package com.openenglish.progreso.cuadernodenotas;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.MyNotebookPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.EMAIL_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.PASSWORD_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.USER_NAME_WITHOUT_NOTES;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.MyNotebook.myNotebookHeaderText;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOKTEXT_IF_NOT_NOTES;
import static org.testng.Assert.assertTrue;

public class C92VerifyCuadernoDeNotasContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyCuadernoDeNotasContentTestS1() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(EMAIL_WITHOUT_NOTES, PASSWORD_WITHOUT_NOTES);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserName().shouldHave(text(USER_NICK_NAME_WITHOUT_NOTES));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().shouldBe(visible).shouldHave(text(myNotebookHeaderText + " " + USER_NAME_WITHOUT_NOTES));
        assertTrue(myNotebookPage.getVerElIndiceDelCursoLink().should(text(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT)).getAttribute("href")
                .contains(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK));
        myNotebookPage.getTextIfNotNotes().should(visible, text(MY_NOTEBOOKTEXT_IF_NOT_NOTES));

    }

    @Test
    public void verifyCuadernoDeNotasContentTestS2() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserName().shouldHave(text(userNickName));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().shouldBe(visible).shouldHave(text(myNotebookHeaderText + " " + userName));
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
