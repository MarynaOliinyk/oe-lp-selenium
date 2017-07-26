package com.openenglish.menu;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ImmersionPage;
import com.openenglish.pages.IntroductionPage;
import com.openenglish.pages.LessonsPage;
import com.openenglish.pages.LiveClassesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Immersion.immersionHeaderText;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Introduction.introdussionHeaderText;
import static com.openenglish.core.TestData.Lessons.lessonsText;
import static com.openenglish.core.TestData.LiveClasses.liveClassesHeaderText;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;

public class C101VerifyCursoMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void liveClassesPageIsOpenedTestS1() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getClasesEnVivoButton().click();
        LiveClassesPage liveClassesPage = new LiveClassesPage();
        liveClassesPage.getHeaderText().shouldBe(visible).shouldHave(text(liveClassesHeaderText));

    }

    @Test
    public void lessonPageIsOpenedTestS2() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        LessonsPage lessonsPage = new LessonsPage();
        lessonsPage.getText().should(visible).shouldHave(text(lessonsText));

    }

    @Test
    public void immersionPageIsOpenedTestS3() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getPracticaLink().click();
        ImmersionPage immersionPage = new ImmersionPage();
        immersionPage.getHeaderText().shouldBe(visible).shouldHave(text(immersionHeaderText));

    }

    @Test
    public void introdussionPageIsOpenedTestS4() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getIntrodussionLink().click();
        IntroductionPage introductionPage = new IntroductionPage();
        introductionPage.getHeaderText().shouldBe(visible).shouldHave(text(introdussionHeaderText));
    }

    private void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                      .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userName));
        page.inicioPage.getCursoButton().hover();
    }
}
