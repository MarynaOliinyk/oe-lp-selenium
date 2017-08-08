package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class C6VerifyInicioContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    // TODO bug LPTRIAGE-298 - No popUp is displayed in C6 Edit Verify "INICIO" content (https://openenglish.jira.com/browse/LPTRIAGE-298)
    @Test(enabled = false)
    public void verifyInicioPageContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText(INICIO_LINK));
        page.inicioPage.getUserNickName().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getHeadingElement().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(attribute("class", "container_12"));
        page.inicioPage.getPlanDeEstudioElement().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(attribute("class", "plan-text"));
        page.inicioPage.getPlanDeEstudioText().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText("Plan de estudio"));
        page.inicioPage.getUserInfoElement().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(attribute("class", "student-level"));
        page.inicioPage.getUserPhoto().shouldBe(visible)
                .shouldHave(attribute("class", "photo-frame"));
        page.inicioPage.getVideoBlock().shouldBe(visible).shouldNotBe(empty);
        page.inicioPage.getCarouselVideoBlock().shouldBe(visible).shouldNotBe(empty);
        page.inicioPage.getLessonVideoBlock().shouldBe(visible).shouldNotBe(empty);
        assertTrue($$ (page.inicioPage.getPracticeVideosBlocks()).size()>0);
        assertFalse($$ (page.inicioPage.getPracticeVideosBlocks()).isEmpty());
        assertTrue(page.inicioPage.verifyAtLeastOneElementTextIsEqual(
                $$(page.inicioPage.getVideoBlocksContainer()), ".//a", "comenzar"));
        $$(page.inicioPage.getVideoBlocksContainer()).get(page.randomNumber($$(page.inicioPage.getVideoBlocksContainer()).size()))
                .hover().click();

    }




}
