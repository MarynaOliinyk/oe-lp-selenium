package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ImmersionPage;
import com.openenglish.pages.IntroductionPage;
import com.openenglish.pages.LessonsPage;
import com.openenglish.pages.LiveClassesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Immersion.IMMERSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_TEXT;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_HEADER_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C101VerifyCursoMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void liveClassesPageIsOpenedTestS1() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getClasesEnVivoButton().click();
        LiveClassesPage liveClassesPage = new LiveClassesPage();
        liveClassesPage.getHeaderText().shouldBe(visible).shouldHave(text(LIVE_CLASSES_HEADER_TEXT));
    }

    @Test
    public void lessonPageIsOpenedTestS2() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        LessonsPage lessonsPage = new LessonsPage();
        lessonsPage.getText().should(visible).shouldHave(text(LESSONS_TEXT));
    }

    @Test
    public void immersionPageIsOpenedTestS3() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getPracticaLink().click();
        ImmersionPage immersionPage = new ImmersionPage();
        immersionPage.getHeaderText().shouldBe(visible).shouldHave(text(IMMERSION_HEADER_TEXT));
    }

    @Test
    public void introdussionPageIsOpenedTestS4() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getIntrodussionLink().click();
        IntroductionPage introductionPage = new IntroductionPage();
        introductionPage.getHeaderText().shouldBe(visible).shouldHave(text(INTRODUSSION_HEADER_TEXT));
    }

    private void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
    }
}
