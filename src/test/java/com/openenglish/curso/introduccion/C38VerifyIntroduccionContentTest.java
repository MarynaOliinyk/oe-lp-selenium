package com.openenglish.curso.introduccion;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.IntroductionPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_DROP_BLOCK_CLASSES_EN_VIVO_LINK;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_DROP_BLOCK_HEADER_TEXT;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_DROP_BLOCK_LESSON_LINK;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_DROP_BLOCK_MESSAGE;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Introduction.INTRODUSSION_LESSON_AND_NUMBER;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static org.testng.Assert.assertTrue;

public class C38VerifyIntroduccionContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private IntroductionPage introductionPage = new IntroductionPage();

    @Test
    public void verifyIntroduccionContentTestS1() {
        loginWithCorrectCredentialsAndPageIntroductionIsOpen();
        introductionPage.getDropBlock().click();
        introductionPage.getDropBlockHeaderText().should(visible, text(INTRODUSSION_DROP_BLOCK_HEADER_TEXT));
        assertTrue(introductionPage.getDropBlockMessage().getText().matches(INTRODUSSION_DROP_BLOCK_MESSAGE));
        assertTrue(page.findElementByJS(introductionPage.getDropBlockLessonLinkID()).getAttribute(introductionPage.getAttributeForLink()).contains(INTRODUSSION_DROP_BLOCK_LESSON_LINK));
        assertTrue(page.findElementByJS(introductionPage.getDropBlockClasesEnVivoLinkID()).getAttribute(introductionPage.getAttributeForLink()).contains(INTRODUSSION_DROP_BLOCK_CLASSES_EN_VIVO_LINK));
        introductionPage.getPrevButton().should(visible);
        introductionPage.getNextButton().should(visible);
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-319
        introductionPage.getLeftLessonsImage().should(visible);
        introductionPage.getRightLessonsImage().should(visible);
        introductionPage.getCentreLessonsImage().should(visible);
        assertTrue(introductionPage.getLessonAndNumber().should(visible).getText().matches(INTRODUSSION_LESSON_AND_NUMBER));
    }

    private void loginWithCorrectCredentialsAndPageIntroductionIsOpen() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getIntrodussionLink().click();
        introductionPage.getHeaderText().shouldBe(visible).shouldHave(text(INTRODUSSION_HEADER_TEXT));
    }
}
