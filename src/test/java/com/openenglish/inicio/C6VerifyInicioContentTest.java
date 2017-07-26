package com.openenglish.inicio;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class C6VerifyInicioContentTest extends TestBase {

    @Test
    public void verifyInicioPageContentTest() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(text(userName));
        inicioPage.getHeadingElement().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(attribute("class", "container_12"));
        inicioPage.getPlanDeEstudioElement().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(attribute("class", "plan-text"));
        inicioPage.getPlanDeEstudioText().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText("Plan de estudio"));
        inicioPage.getUserInfoElement().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(attribute("class", "student-level"));
        inicioPage.getUserPhoto().shouldBe(visible)
                .shouldHave(attribute("class", "photo-frame"));
        inicioPage.getVideoBlock().shouldBe(visible).shouldNotBe(empty);
        inicioPage.getCarouselVideoBlock().shouldBe(visible).shouldNotBe(empty);
        inicioPage.getLessonVideoBlock().shouldBe(visible).shouldNotBe(empty);
        assertTrue($$ (inicioPage.getPracticeVideosBlocks()).size()>=0);
        assertFalse($$ (inicioPage.getPracticeVideosBlocks()).isEmpty());

// TODO finish it
    }

}
