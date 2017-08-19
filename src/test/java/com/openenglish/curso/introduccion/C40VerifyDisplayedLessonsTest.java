package com.openenglish.curso.introduccion;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.IntroductionPage;
import com.openenglish.pages.LessonsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.CLASS;
import static com.openenglish.core.Attribute.Value.HOVER_MASK;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_COMENZAR_BUTTON;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_DESCRIPTION_OF_EACH_LESSON;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_LESSON_AND_NUMBER;
import static com.openenglish.core.TestData.Lessons.LESSONS_PAGE_HEADER_TITLE;
import static com.openenglish.core.TestData.Lessons.TEXT_FOR_SPECIFIC_LESSON;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static org.testng.Assert.assertTrue;

public class C40VerifyDisplayedLessonsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyCarouselLessonsTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getIntrodussionLink().click();
        IntroductionPage introductionPage = new IntroductionPage();
        introductionPage.getHeaderText().shouldBe(visible).should(text(INTRODUSSION_HEADER_TEXT));
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-319
        introductionPage.getImageOfEachLesson().should(visible);
        assertTrue(introductionPage.getNumberOfEachLesson().should(visible).getText().matches(INTRODUSSION_LESSON_AND_NUMBER));
        assertTrue(introductionPage.getDescriptionOfEachLesson().should(visible).getText().matches(INTRODUSSION_DESCRIPTION_OF_EACH_LESSON));
        introductionPage.getLessonHolder().should(appear).hover();
        introductionPage.getAnyLesson().should(attribute(CLASS, HOVER_MASK), visible, text(INTRODUSSION_COMENZAR_BUTTON)).click();
        LessonsPage lessonsPage = new LessonsPage();
        lessonsPage.getNameOfThePage().should(visible, text(LESSONS_PAGE_HEADER_TITLE));
        lessonsPage.getLessonMenuTitle().should(visible, text(TEXT_FOR_SPECIFIC_LESSON));
    }
}
