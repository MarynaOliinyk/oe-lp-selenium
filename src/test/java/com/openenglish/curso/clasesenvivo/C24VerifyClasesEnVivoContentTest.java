package com.openenglish.curso.clasesenvivo;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.LiveClassesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_CONTENT_TEXT;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_DROP_BLOCK_HEADER_TEXT;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_DROP_BLOCK_IMMERSION_LINK;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_DROP_BLOCK_LESSON_LINK;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_DROP_BLOCK_MESSAGE;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_HEADER_TEXT;
import static com.openenglish.core.TestData.LiveClasses.LIVE_CLASSES_TITLE_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static org.testng.Assert.assertTrue;

public class C24VerifyClasesEnVivoContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyClasesEnVivoContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getClasesEnVivoButton().click();
        //TODO BUG LPTRIAGE-307 https://openenglish.jira.com/browse/LPTRIAGE-307
        LiveClassesPage liveClassesPage = new LiveClassesPage();
        liveClassesPage.getHeaderText().shouldBe(visible).shouldHave(text(LIVE_CLASSES_HEADER_TEXT));
        liveClassesPage.getDropBlock().click();
        liveClassesPage.getDropBlockHeaderText().should(visible, text(LIVE_CLASSES_DROP_BLOCK_HEADER_TEXT));
        assertTrue(liveClassesPage.getDropBlockMessage().getText().matches(LIVE_CLASSES_DROP_BLOCK_MESSAGE));
        assertTrue(page.findElementByJS(liveClassesPage.getDropBlockLessonLinkID()).getAttribute(liveClassesPage.getAttribute()).contains(LIVE_CLASSES_DROP_BLOCK_LESSON_LINK));
        assertTrue(page.findElementByJS(liveClassesPage.getDropBlockImmersionLinkID()).getAttribute(liveClassesPage.getAttribute()).contains(LIVE_CLASSES_DROP_BLOCK_IMMERSION_LINK));
        liveClassesPage.getCarousel().should(visible);
        liveClassesPage.getTimer().should(enabled, exist);
        liveClassesPage.getTimesUpButton().should(exist, enabled);
        liveClassesPage.getLeftBanner().should(visible);
        liveClassesPage.getRightBanner().should(visible);
        liveClassesPage.getTitleText().should(text(LIVE_CLASSES_TITLE_TEXT));
        liveClassesPage.getContentText().should(text(LIVE_CLASSES_CONTENT_TEXT));
        liveClassesPage.getDates().should(visible);
        liveClassesPage.getImageOnVideo().should(visible);
    }
}