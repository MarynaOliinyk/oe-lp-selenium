package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static org.testng.Assert.assertTrue;

public class C1391CheckThatThePracticeAndLessonsIconsAreLoadedWithNoIssuesTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatThePracticeAndLessonsIconsAreLoadedTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText(INICIO_LINK));
        page.inicioPage.getUserName().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(text(USER_NAME));
        assertTrue(page.inicioPage.visibilityOfListElements($$(page.inicioPage.getAllThePracticeVideoImgs())));
        assertTrue(page.inicioPage.visibilityOfListElements($$(page.inicioPage.getAllTheLessonsVideoImgs())));
        assertTrue(page.inicioPage.visibilityOfListElements($$(page.inicioPage.getAllTheLiveClassesVideoImgs())));
    }

}
