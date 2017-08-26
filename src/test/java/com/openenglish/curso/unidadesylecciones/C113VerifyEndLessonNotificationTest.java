package com.openenglish.curso.unidadesylecciones;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.LessonsPage;
import org.testng.annotations.Test;

import java.awt.*;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_BEGIN_LESSON_BUTTON;
import static com.openenglish.core.TestData.Lessons.LESSONS_PAGE_HEADER_TITLE;
import static com.openenglish.core.TestData.Lessons.LESSONS_LO_LOGRO_FACEBOOK_BUTTON_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_LO_LOGRO_GOOGLE_BUTTON_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_LO_LOGRO_PROXIMA_BUTTON;
import static com.openenglish.core.TestData.Lessons.LESSONS_LO_LOGRO_SUS_LOGROS_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_LO_LOGRO_TITLE_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_LO_LOGRO_TWITTER_BUTTON_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static org.testng.Assert.assertTrue;

public class C113VerifyEndLessonNotificationTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private LessonsPage lessonsPage = new LessonsPage();

    @Test
    public void lessonAreaSectionTest() throws InterruptedException, AWTException {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();

        switchTo().frame(lessonsPage.getLessonIFrame());
        lessonsPage.getBeginLessonButton().shouldBe(visible, exactText(LESSONS_BEGIN_LESSON_BUTTON)).click();
        lessonsPage.getLessonGreaterThenElement().shouldBe(exist, visible);
        executeJavaScript("window.parent.TCAPI.rate(5)");
        switchTo().defaultContent();
        lessonsPage.getPopUpLoLogroTitle().shouldBe(exist, visible, exactText(LESSONS_LO_LOGRO_TITLE_TEXT));
        lessonsPage.getPopUpLoLogroProfilePhoto().shouldBe(exist, visible);
        lessonsPage.getPopUpLoLogroUserName().shouldBe(exist, visible, not(empty));
        lessonsPage.getPopUpLoLogroLessonName().shouldBe(exist, visible, not(empty));
        lessonsPage.getPopUpLoLogroLessonDescription().shouldBe(exist, visible, not(empty));
        lessonsPage.getPopUpLoLogroCompartaSusLogros().shouldBe(exist, visible, exactText(LESSONS_LO_LOGRO_SUS_LOGROS_TEXT));
        lessonsPage.getPopUpLoLogroTwitterLogo().shouldBe(exist, visible).click();
        switchTo().window(1);
        assertTrue(url().contains(LESSONS_LO_LOGRO_TWITTER_BUTTON_URL));
        switchTo().window(0);
        lessonsPage.getPopUpLoLogroFacebookLogo().shouldBe(exist, visible).click();
        switchTo().window(2);
        System.out.println(url());
        assertTrue(url().contains(LESSONS_LO_LOGRO_FACEBOOK_BUTTON_URL));
        switchTo().window(0);
        lessonsPage.getPopUpLoLogroGoogleLogo().shouldBe(exist, visible).click();
        switchTo().window(3);
        assertTrue(url().contains(LESSONS_LO_LOGRO_GOOGLE_BUTTON_URL));
        switchTo().window(0);
        lessonsPage.getPopUpLoLogroProximaLessonButton().shouldBe(exist, visible, exactText(LESSONS_LO_LOGRO_PROXIMA_BUTTON)).click();
        lessonsPage.getNameOfThePage().shouldBe(exist, visible, exactText(LESSONS_PAGE_HEADER_TITLE)).click();
    }
}