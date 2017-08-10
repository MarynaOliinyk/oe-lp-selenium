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
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Lessons.ALLERT_BODY_TEXT;
import static com.openenglish.core.TestData.Lessons.ALLERT_CERRAR_TEXT;
import static com.openenglish.core.TestData.Lessons.ALLERT_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.ASK_TEACHER_SUBMIT_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_PAGE_TITLE;
import static com.openenglish.core.TestData.Lessons.SOME_TEXT_FOR_TEST;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.pages.AbstractPage.scrollDown;

public class C32EnviarUnaPreguntaAUnProfesorSendsMessageTest extends DriverBase {

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

        lessonsPage.getAskTeacherTabHeader().click();
        lessonsPage.getAskTeacherTabStoryBlock().should(exist, visible, empty).sendKeys(SOME_TEXT_FOR_TEST);
        lessonsPage.getEnviarButton().shouldBe(exist, visible, exactText(ASK_TEACHER_SUBMIT_TEXT)).click();

        lessonsPage.getAllertBlock().shouldBe(exist, visible);
        lessonsPage.getAllertHeader().shouldBe(exist, visible, exactText(ALLERT_HEADER_TEXT));
        lessonsPage.getAllertBody().shouldBe(exist, visible, exactText(ALLERT_BODY_TEXT));
        lessonsPage.getAllertCerrarButton().shouldBe(exist, visible, exactText(ALLERT_CERRAR_TEXT)).click();
        lessonsPage.getNameOfThePage().should(visible, text(LESSONS_PAGE_TITLE));
        lessonsPage.getAskTeacherTabStoryBlock().shouldBe(exist, visible, empty);
    }
}
