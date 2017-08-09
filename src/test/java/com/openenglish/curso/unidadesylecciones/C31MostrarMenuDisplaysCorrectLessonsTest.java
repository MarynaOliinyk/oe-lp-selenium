package com.openenglish.curso.unidadesylecciones;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.IndiceDelCursoPage;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LessonsPage;
import com.openenglish.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Lessons.CONTINUAR_LESSON_TEXT;
import static com.openenglish.core.TestData.Lessons.INDICE_DEL_CURSO_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_MENU_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_TEXT;
import static com.openenglish.core.TestData.Lessons.MENU_MONSTRAR_TEXT;
import static com.openenglish.core.TestData.Lessons.MENU_OCULTAR_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Selenide.WAIT_UNTIL;
import static com.openenglish.pages.AbstractPage.openInNewTab;
import static org.testng.Assert.assertTrue;

public class C31MostrarMenuDisplaysCorrectLessonsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void correctLessonsDisplaysTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserNickName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();

        LessonsPage lessonsPage = new LessonsPage();
        lessonsPage.getText().should(visible).shouldHave(text(LESSONS_TEXT));
        page.scroll();
        lessonsPage.getLessonMostrarMenu().shouldHave(exactText(MENU_MONSTRAR_TEXT));
        lessonsPage.getLessonMostrarMenu().click();

        lessonsPage.getContinuarLeccionLink().shouldHave(exactText(CONTINUAR_LESSON_TEXT));
        lessonsPage.getLessonsMenuHeader().waitUntil(not(empty), WAIT_UNTIL);
        lessonsPage.getLessonsMenuHeader().shouldHave(exactText(LESSONS_MENU_TEXT));
        lessonsPage.getLessonOcultarMenu().shouldHave(exactText(MENU_OCULTAR_TEXT));
        List<String> lessonsListFromOcultar = listCreation(lessonsPage.getAllTheLessonsFromOcultarMenu());

        openInNewTab(INDICE_DEL_CURSO_URL);
        IndiceDelCursoPage indicePage = new IndiceDelCursoPage();
        switchTo().window(1);
        indicePage.getUnitOneLevelOne().click();
        $(indicePage.getAllTheLessonsFromUnitOneLevelOne()).waitUntil(visible, WAIT_UNTIL);
        List<String> lessonsListFromIndicePage = listCreation(indicePage.getAllTheLessonsFromUnitOneLevelOne());

        switchTo().window(0);
        assertTrue(lessonsListFromOcultar.containsAll(lessonsListFromIndicePage));
        lessonsPage.getLessonOcultarMenu().click();
        lessonsPage.getLessonOcultarMenu().waitUntil(not(visible), WAIT_UNTIL);
        lessonsPage.getLessonMostrarMenu().shouldHave(exactText(MENU_MONSTRAR_TEXT));


    }

    private List<String> listCreation(By pathToSearch) {
        List<String> lessonsList = new ArrayList<>();
        $$(pathToSearch).forEach(element -> lessonsList.add(element.getText().toLowerCase()));
        return lessonsList;
    }

}
