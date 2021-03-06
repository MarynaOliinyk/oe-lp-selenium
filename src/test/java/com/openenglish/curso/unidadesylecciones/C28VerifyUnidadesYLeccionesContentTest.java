package com.openenglish.curso.unidadesylecciones;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.LessonsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.Attribute.CLASS;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_ASK_TEACHER_HEADER_CLASS;
import static com.openenglish.core.TestData.Lessons.LESSONS_ASK_TEACHER_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_ASK_TEACHER_SUBMIT_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_BEGIN_LESSON_BUTTON;
import static com.openenglish.core.TestData.Lessons.LESSONS_MENU_MONSTRAR_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_MENU_PROGRESS_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_MENU_TITLE_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_MY_NOTES_GUARDAR_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_MY_NOTES_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_MY_NOTES_LIST_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_REMINDER_BODY;
import static com.openenglish.core.TestData.Lessons.LESSONS_REMINDER_LESSONS_LINK;
import static com.openenglish.core.TestData.Lessons.LESSONS_REMINDER_LIVECLASSES_LINK;
import static com.openenglish.core.TestData.Lessons.LESSONS_REMINDER_PRACTICA_LINK;
import static com.openenglish.core.TestData.Lessons.LESSONS_REMINDER_TITLE;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.pages.AbstractPage.scrollDown;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C28VerifyUnidadesYLeccionesContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private LessonsPage lessonsPage = new LessonsPage();

    @Test
    public void lessonAreaSectionTest() {
        loginExecutingC2AndExecutingC101Scenario2();
        lessonsPage.getReminderTab().shouldBe(visible).hover();
        lessonsPage.getReminderTabTitle().shouldBe(visible);
        assertEquals(lessonsPage.getReminderTabTitle().getText(), LESSONS_REMINDER_TITLE);
        lessonsPage.getReminderTabBody().shouldBe(visible);
        assertTrue(lessonsPage.getReminderTabBody().getText().matches(LESSONS_REMINDER_BODY));
        lessonsPage.getReminderTabLessonsLink().shouldBe(visible);
        //TODO check if there must be a LECCIONES link or Índice del Curso
        assertEquals(lessonsPage.getReminderTabLessonsLink().getText(), LESSONS_REMINDER_LESSONS_LINK);
        lessonsPage.getReminderTabPracticaLink().shouldBe(visible);
        assertEquals(lessonsPage.getReminderTabPracticaLink().getText(), LESSONS_REMINDER_PRACTICA_LINK);
        lessonsPage.getReminderTabLiveClassesLink().shouldBe(visible);
        assertEquals(lessonsPage.getReminderTabLiveClassesLink().getText(), LESSONS_REMINDER_LIVECLASSES_LINK);
        switchTo().frame(lessonsPage.getLessonIFrame());
        lessonsPage.getLessonContentBlock().shouldBe(visible);
        lessonsPage.getBeginLessonButton().shouldBe(visible);
        assertEquals(lessonsPage.getBeginLessonButton().getText(), LESSONS_BEGIN_LESSON_BUTTON);

        switchTo().defaultContent();
        lessonsPage.getLessonMenu().shouldBe(visible);
        lessonsPage.getLessonMenuTitle().shouldBe(visible);
        assertTrue(lessonsPage.getLessonMenuTitle().getText().matches(LESSONS_MENU_TITLE_TEXT));

        lessonsPage.getLessonMenuProgress().shouldBe(visible);
        assertTrue(lessonsPage.getLessonMenuProgress().getText().matches(LESSONS_MENU_PROGRESS_TEXT));

        lessonsPage.getLessonMostrarMenu().shouldBe(visible);
        //TODO check if there must be a MEnu link or mostrar menú
        assertEquals(lessonsPage.getLessonMostrarMenu().getText(), LESSONS_MENU_MONSTRAR_TEXT);
    }

    @Test
    public void questionsNotesSectionTest() {
        loginExecutingC2AndExecutingC101Scenario2();
        scrollDown();
        lessonsPage.getAskTeacherTabHeader().should(exist, visible).
                shouldHave(attribute(CLASS, LESSONS_ASK_TEACHER_HEADER_CLASS));
        lessonsPage.getAskTeacherTabHeader().shouldHave(exactText(LESSONS_ASK_TEACHER_HEADER_TEXT));
        lessonsPage.getAskTeacherTabInstructions().should(exist).shouldBe(visible).shouldNotBe(empty);
        lessonsPage.getAskTeacherTabStoryBlock().should(exist, visible, empty);
        lessonsPage.getAskTeacherTabSubmitButton().should(exist, visible, exactText(LESSONS_ASK_TEACHER_SUBMIT_TEXT));
        scrollDown();
        lessonsPage.getMyNotesTab().click();
        lessonsPage.getMyNotesTab().should(exist, visible, exactText(LESSONS_MY_NOTES_HEADER_TEXT));
        lessonsPage.getMyNotesTabWholeBlock().should(exist, visible, not(empty));
        lessonsPage.getMyNotesTabNotesListHeader().should(exist, visible, exactText(LESSONS_MY_NOTES_LIST_HEADER_TEXT)).
                shouldNotBe(empty);
        lessonsPage.getMyNotesTabGuardarNotaDisabledButton().should(exist, visible, exactText(LESSONS_MY_NOTES_GUARDAR_TEXT));
    }

    private void loginExecutingC2AndExecutingC101Scenario2() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();
    }

}
