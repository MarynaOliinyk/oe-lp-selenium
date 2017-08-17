package com.openenglish.curso.introduccion;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.IntroductionPage;
import com.openenglish.pages.LessonsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_COMENZAR_BUTTON;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_DESCRIPTION_CENTRE_LESSON;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_LESSON;
import static com.openenglish.core.TestData.Lessons.LESSONS_PAGE_HEADER_TITLE;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C39VerifyCarouselLessonsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private IntroductionPage introductionPage = new IntroductionPage();

    @Test
    public void verifyCarouselLessonsTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getIntrodussionLink().click();
        introductionPage.getHeaderText().shouldBe(visible).should(text(INTRODUSSION_HEADER_TEXT));
        introductionPage.getLessonThirdOnCarousel().should(visible.text(INTRODUSSION_LESSON + " 3"));
        introductionPage.getLessonFourthOnCarousel().should(visible, text(INTRODUSSION_LESSON + " 4"));
        introductionPage.getLessonTwelfthOnCarousel().should(visible, text(INTRODUSSION_LESSON + " 12"));
        introductionPage.getNextButton().should(visible).click();
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-320
        introductionPage.getLessonFourthOnCarousel().should(visible, text(INTRODUSSION_LESSON + " 4"));
        introductionPage.getLessonFifthOnCarousel().should(visible, text(INTRODUSSION_LESSON + " 5"));
        introductionPage.getLessonThirdOnCarousel().should(visible, text(INTRODUSSION_LESSON + " 3"));
        introductionPage.getLessonCentreHolder().hover();
        introductionPage.getDescriptionCentreLesson().should(visible, text(INTRODUSSION_DESCRIPTION_CENTRE_LESSON));
        introductionPage.getNameAndNumberCenterLesson().should(visible, text(INTRODUSSION_LESSON + " 4"));
        introductionPage.getComenzarButtonCentreLesson().should(visible, text(INTRODUSSION_COMENZAR_BUTTON)).click();
        LessonsPage lessonsPage = new LessonsPage();
        lessonsPage.getNameOfThePage().should(text(LESSONS_PAGE_HEADER_TITLE)).hover();
        lessonsPage.getLessonContentHeader().waitWhile(text(INTRODUSSION_DESCRIPTION_CENTRE_LESSON), 1000);
    }
}