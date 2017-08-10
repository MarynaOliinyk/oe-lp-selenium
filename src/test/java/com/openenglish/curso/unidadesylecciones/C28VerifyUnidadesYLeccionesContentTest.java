package com.openenglish.curso.unidadesylecciones;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.LessonsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Lessons.ASK_TEACHER_HEADER_CLASS;
import static com.openenglish.core.TestData.Lessons.ASK_TEACHER_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.ASK_TEACHER_SUBMIT_TEXT;
import static com.openenglish.core.TestData.Lessons.BEGIN_LESSON_BUTTON;
import static com.openenglish.core.TestData.Lessons.LESSONS_TEXT;
import static com.openenglish.core.TestData.Lessons.MENU_MONSTRAR_TEXT;
import static com.openenglish.core.TestData.Lessons.MENU_PROGRESS_TEXT;
import static com.openenglish.core.TestData.Lessons.MENU_TITLE_TEXT;
import static com.openenglish.core.TestData.Lessons.MY_NOTES_GUARDAR_TEXT;
import static com.openenglish.core.TestData.Lessons.MY_NOTES_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.MY_NOTES_LIST_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.REMINDER_BODY;
import static com.openenglish.core.TestData.Lessons.REMINDER_LESSONS_LINK;
import static com.openenglish.core.TestData.Lessons.REMINDER_LIVECLASSES_LINK;
import static com.openenglish.core.TestData.Lessons.REMINDER_PRACTICA_LINK;
import static com.openenglish.core.TestData.Lessons.REMINDER_TITLE;
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
        assertEquals(lessonsPage.getReminderTabTitle().getText(), REMINDER_TITLE);
        lessonsPage.getReminderTabBody().shouldBe(visible);
        assertTrue(lessonsPage.getReminderTabBody().getText().matches(REMINDER_BODY));
        lessonsPage.getReminderTabLessonsLink().shouldBe(visible);
        //TODO check if there must be a LECCIONES link or Índice del Curso
        assertEquals(lessonsPage.getReminderTabLessonsLink().getText(), REMINDER_LESSONS_LINK);
        lessonsPage.getReminderTabPracticaLink().shouldBe(visible);
        assertEquals(lessonsPage.getReminderTabPracticaLink().getText(), REMINDER_PRACTICA_LINK);
        lessonsPage.getReminderTabLiveClassesLink().shouldBe(visible);
        assertEquals(lessonsPage.getReminderTabLiveClassesLink().getText(), REMINDER_LIVECLASSES_LINK);
        switchTo().frame(lessonsPage.getLessonIFrame());
        lessonsPage.getLessonContentBlock().shouldBe(visible);
        lessonsPage.getBeginLessonButton().shouldBe(visible);
        assertEquals(lessonsPage.getBeginLessonButton().getText(), BEGIN_LESSON_BUTTON);

        switchTo().defaultContent();
        lessonsPage.getLessonMenu().shouldBe(visible);
        lessonsPage.getLessonMenuTitle().shouldBe(visible);
        assertTrue(lessonsPage.getLessonMenuTitle().getText().matches(MENU_TITLE_TEXT));

        lessonsPage.getLessonMenuProgress().shouldBe(visible);
        assertTrue(lessonsPage.getLessonMenuProgress().getText().matches(MENU_PROGRESS_TEXT));

        lessonsPage.getLessonMostrarMenu().shouldBe(visible);
        //TODO check if there must be a MEnu link or mostrar menú
        assertEquals(lessonsPage.getLessonMostrarMenu().getText(), MENU_MONSTRAR_TEXT);
    }

    @Test
    public void questionsNotesSectionTest() {
        loginExecutingC2AndExecutingC101Scenario2();
        scrollDown();
        lessonsPage.getAskTeacherTabHeader().should(exist).shouldBe(visible).
                shouldHave(attribute("class")).shouldHave(exactText(ASK_TEACHER_HEADER_CLASS));
        lessonsPage.getAskTeacherTabHeader().shouldHave(exactText(ASK_TEACHER_HEADER_TEXT));
        lessonsPage.getAskTeacherTabInstructions().should(exist).shouldBe(visible).shouldNotBe(empty);
        lessonsPage.getAskTeacherTabStoryBlock().should(exist, visible, empty);
        lessonsPage.getAskTeacherTabSubmitButton().should(exist, visible, exactText(ASK_TEACHER_SUBMIT_TEXT));
        lessonsPage.getMyNotesTabHeader().click();
        lessonsPage.getMyNotesTabHeader().should(exist, visible, exactText(MY_NOTES_HEADER_TEXT));
        lessonsPage.getMyNotesTabTextBlock().should(exist, visible).shouldNotBe(empty);
        lessonsPage.getMyNotesTabNotesListHeader().should(exist, visible, exactText(MY_NOTES_LIST_HEADER_TEXT)).
                shouldNotBe(empty);
        lessonsPage.getMyNotesTabGuardarNotaButton().should(exist, visible, exactText(MY_NOTES_GUARDAR_TEXT));
    }

    private void loginExecutingC2AndExecutingC101Scenario2() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        lessonsPage.getText().should(visible, text(LESSONS_TEXT));
    }

}
