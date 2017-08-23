package com.openenglish.curso.unidadesylecciones;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.LessonsPage;
import com.openenglish.pages.MyNotebookPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_PAGE_TITLE;
import static com.openenglish.core.TestData.Lessons.MY_NOTES_GUARDAR_TEXT;
import static com.openenglish.core.TestData.Lessons.SOME_TEXT_FOR_TEST;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.pages.AbstractPage.scrollDown;

public class C33MisNotasNotesAreSavedCorrectlyTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private LessonsPage lessonsPage = new LessonsPage();

    @Test
    public void lessonAreaSectionTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        lessonsPage.getNameOfThePage().should(visible, text(LESSONS_PAGE_TITLE));

        scrollDown();
        lessonsPage.getMyNotesTab().click();
        scrollDown();

        lessonsPage.getMyNotesTabWholeBlock().should(exist, visible, not(empty));
        lessonsPage.getMyNotesTabGuardarNotaDisabledButton().should(exist, visible);
        String stringToSave = SOME_TEXT_FOR_TEST + " " + page.randomNumber(10);
        lessonsPage.getMyNotesTabTextInputBlock().should(exist, visible).clear();
        lessonsPage.getMyNotesTabTextInputBlock().sendKeys(stringToSave);
        lessonsPage.getMyNotesTabGuardarNotaVisibleButton().should(exist, visible, exactText(MY_NOTES_GUARDAR_TEXT)).click();
        lessonsPage.getMyNotesTabVerMiCuadernoDeNotasLink().should(exist, visible).click();

        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getDataMyNotebookTable().should(exist, visible, not(empty));
        myNotebookPage.getDateAndHourOfNoteCreationData().should(exist, visible, not(empty));
        myNotebookPage.getUnitAndLessonNumberData().should(exist, visible, not(empty));
        myNotebookPage.getLessonTitleData().should(exist, visible, not(empty));
        myNotebookPage.getNoteDescription().should(exist, visible, exactText(stringToSave));

        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        lessonsPage.getNameOfThePage().should(visible, text(LESSONS_PAGE_TITLE));

        scrollDown();
        lessonsPage.getMyNotesTab().click();
        scrollDown();

        lessonsPage.getMyNotesTabWholeBlock().should(exist, visible, not(empty));
        lessonsPage.getMyNotesTabGuardarNotaDisabledButton().should(exist, visible);
        String stringToSaveSecondOne = SOME_TEXT_FOR_TEST + " " + page.randomNumber(10);
        lessonsPage.getMyNotesTabTextInputBlock().should(exist, visible, value(stringToSave)).clear();
        lessonsPage.getMyNotesTabTextInputBlock().sendKeys(stringToSaveSecondOne);
        lessonsPage.getMyNotesTabGuardarNotaVisibleButton().should(exist, visible, exactText(MY_NOTES_GUARDAR_TEXT)).click();
        lessonsPage.getMyNotesTabVerMiCuadernoDeNotasLink().should(exist, visible).click();

        myNotebookPage.getDataMyNotebookTable().should(exist, visible, not(empty));
        myNotebookPage.getDateAndHourOfNoteCreationData().should(exist, visible, not(empty));
        myNotebookPage.getUnitAndLessonNumberData().should(exist, visible, not(empty));
        myNotebookPage.getLessonTitleData().should(exist, visible, not(empty));
        myNotebookPage.getNoteDescription().should(exist, visible, exactText(stringToSaveSecondOne));
    }
}
