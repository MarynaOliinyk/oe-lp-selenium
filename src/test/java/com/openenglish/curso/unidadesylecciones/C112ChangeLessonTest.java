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
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Lessons.LESSONS_MENU_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_TEXT;
import static com.openenglish.core.TestData.Lessons.MENU_OCULTAR_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.pages.AbstractPage.scrollDown;
import static com.openenglish.pages.AbstractPage.scrollUp;
import static org.testng.Assert.assertNotEquals;

public class C112ChangeLessonTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private LessonsPage lessonsPage = new LessonsPage();

    @Test
    public void lessonAreaSectionTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        lessonsPage.getText().should(visible, text(LESSONS_TEXT));

        switchTo().frame(lessonsPage.getLessonIFrame());
        String defaultLessonName = lessonsPage.getLessonNameHeader().shouldBe(visible).getText().toLowerCase();

        switchTo().defaultContent();
        scrollDown();
        lessonsPage.getLessonMostrarMenu().click();
        scrollUp();
        lessonsPage.getLessonsMenuHeader().shouldHave(exactText(LESSONS_MENU_TEXT));
        lessonsPage.getLessonOcultarMenu().shouldHave(exactText(MENU_OCULTAR_TEXT));
        String lessonNameToSelect = lessonsPage.getLessonsFirstNotActiveLesson().shouldBe(visible).getText().toLowerCase();
        assertNotEquals(defaultLessonName, lessonNameToSelect);
        lessonsPage.getLessonsFirstNotActiveLesson().click();

        lessonsPage.getText().should(visible, text(LESSONS_TEXT));
        switchTo().frame(lessonsPage.getLessonIFrame().shouldBe(visible));
        lessonsPage.getLessonNameHeader().shouldHave(visible, text(lessonNameToSelect));
        lessonsPage.getLessonContentHeader().shouldHave(exist, visible, not(empty));
    }

}
