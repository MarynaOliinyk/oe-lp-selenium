package com.openenglish.menu;


import com.openenglish.core.TestBase;
import com.openenglish.pages.ImmersionPage;
import com.openenglish.pages.IntroductionPage;
import com.openenglish.pages.LessonsPage;
import com.openenglish.pages.LiveClassesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C101VerifyCursoMenuLinksTest extends TestBase {

    @BeforeMethod
    public void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getCursoButton().hover();
    }

    @Test
    public void liveClassesPageIsOpenedTestS1() {
        inicioPage.getClasesEnVivoButton().click();
        LiveClassesPage liveClassesPage = new LiveClassesPage();
        liveClassesPage.getHeaderText().shouldBe(visible).shouldHave(text(liveClassesHeaderText));

    }

    @Test
    public void lessonPageIsOpenedTestS2() {
        inicioPage.getUnidadesYLeccionesButton().click();
        LessonsPage lessonsPage = new LessonsPage();
        lessonsPage.getText().should(visible).shouldHave(text(lessonsText));

    }

    @Test
    public void immersionPageIsOpenedTestS3() {
        inicioPage.getPracticaLink().click();
        ImmersionPage immersionPage = new ImmersionPage();
        immersionPage.getHeaderText().shouldBe(visible).shouldHave(text(immersionHeaderText));

    }

    @Test
    public void introdussionPageIsOpenedTestS4() {
        inicioPage.getIntrodussionLink().click();
        IntroductionPage introductionPage = new IntroductionPage();
        introductionPage.getHeaderText().shouldBe(visible).shouldHave(text(introdussionHeaderText));

    }
}
