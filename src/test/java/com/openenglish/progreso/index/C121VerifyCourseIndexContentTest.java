package com.openenglish.progreso.index;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.CourseIndexPage;
import com.openenglish.pages.MyNotebookPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.CourseIndex.COURSE_INDEX_FILTER_TEXT;
import static com.openenglish.core.TestData.CourseIndex.COURSE_INDEX_HEADER_TEXT;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_HEADER_TEXT;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT;
import static org.testng.Assert.assertTrue;

public class C121VerifyCourseIndexContentTest extends DriverBase{
    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyCourseIndexContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserName().shouldHave(text(USER_NAME));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().should(visible,text(MY_NOTEBOOK_HEADER_TEXT + " " + USER_NAME));
        assertTrue(myNotebookPage.getVerElIndiceDelCursoLink().should(text(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT)).getAttribute("href")
                .contains(MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK));
        myNotebookPage.getVerElIndiceDelCursoLink().click();
        CourseIndexPage courseIndexPage = new CourseIndexPage();
        courseIndexPage.getHeaderText().should(visible,text(COURSE_INDEX_HEADER_TEXT));
        courseIndexPage.getFilterText().should(visible,text(COURSE_INDEX_FILTER_TEXT));
        courseIndexPage.getLessonContent().should(visible);
        courseIndexPage.getPreviousArrowButton().should(visible);
        courseIndexPage.getNextArrowButton().should(visible);
        courseIndexPage.getLevelsHolder().should(visible);
        courseIndexPage.getContentOfEachLevel().should(visible);
    }

}
