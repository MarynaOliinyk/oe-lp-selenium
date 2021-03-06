package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.TYPE;
import static com.openenglish.core.AttributeValue.LoginPage.PASSWORD;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_COMENZAR_TEXT;
import static com.openenglish.core.TestData.Inicio.INICIO_HEADER_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class C6VerifyInicioContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    // TODO bug LPTRIAGE-298 - No popUp is displayed in C6 Edit Verify "INICIO" content (https://openenglish.jira.com/browse/LPTRIAGE-298)
    @Test
    public void verifyInicioPageContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute(TYPE, PASSWORD));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getPlanDeEstudioText().should(visible, text(INICIO_HEADER_TEXT));
        // TODO bug LPTRIAGE-313 https://openenglish.jira.com/browse/LPTRIAGE-313
        page.inicioPage.getUserName().should(visible.text(USER_NAME));
        page.inicioPage.getUserPhoto().shouldBe(visible);
        page.inicioPage.getVideoBlock().shouldBe(visible).shouldNotBe(empty);
        page.inicioPage.getCarouselVideoBlock().shouldBe(visible).shouldNotBe(empty);
        page.inicioPage.getLessonVideoBlock().shouldBe(visible).shouldNotBe(empty);
        assertTrue($$(page.inicioPage.getPracticeVideosBlocks()).size() > 0);
        assertFalse($$(page.inicioPage.getPracticeVideosBlocks()).isEmpty());
        assertTrue(page.inicioPage.verifyAtLeastOneElementTextIsEqual(
                $$(page.inicioPage.getVideoBlocksContainer()), ".//a", INICIO_COMENZAR_TEXT));
        $$(page.inicioPage.getVideoBlocksContainer()).get(page.randomNumber($$(page.inicioPage.getVideoBlocksContainer()).size()))
                .hover().click();
        page.inicioPage.getComenzarButtonVideoBlock().should(visible).click();

    }
}
