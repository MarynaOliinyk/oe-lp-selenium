package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.FAQPage;
import com.openenglish.pages.HowToVideosPage;
import com.openenglish.pages.MeetingPage;
import com.openenglish.pages.ParticipantsGuidePage;
import com.openenglish.pages.TalkNowPage;
import com.openenglish.pages.TestYourSystemPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.FAQ.FAQ_HEADER_TEXT;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Meeting.MEETING_TEST_TEXT;
import static com.openenglish.core.TestData.ParticipantsGuide.CONTAINS_PDF_FILE;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_HEADER_TEXT;
import static com.openenglish.core.TestData.TestYourSystem.TEST_YOUR_SYSTEM_HEADER_TEXT;
import static org.testng.Assert.assertTrue;

public class C102VerifyAyudaMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    private void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserName().shouldHave(text(USER_NICK_NAME));
        page.inicioPage.getAyudaDropDown().hover();
    }

    @Test
    public void verifyContactenosTestS1() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getContactenos().click();
        TalkNowPage talkNowPage = new TalkNowPage();
        talkNowPage.getHeaderText().shouldHave(text(TALK_NOW_HEADER_TEXT));

    }

    @Test
    public void verifyVideosTutorialesTestS2() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getVideosTutoriales().click();
        HowToVideosPage howToVideosPage = new HowToVideosPage();
        howToVideosPage.getImage().shouldBe(visible);

    }

    @Test
    public void verifyVerificaTuSistemaTestS3() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getVerificaTuSistema().click();
        TestYourSystemPage testYourSystemPage = new TestYourSystemPage();
        testYourSystemPage.getHeaderText().shouldHave(text(TEST_YOUR_SYSTEM_HEADER_TEXT));

    }

    @Test
    public void verifyAdobeConnectGuiaRapidaTestS4() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getAdobeConnectGuiaRapida().click();
        switchTo().window(1);
        ParticipantsGuidePage participantsGuidePage = new ParticipantsGuidePage();
        assertTrue(participantsGuidePage.getPageTitle().getAttribute("src").contains(CONTAINS_PDF_FILE));

    }

    @Test
    public void verifyVerifiqueSuConfiguracionTestS5() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getVerifiqueSuConfiguracion().click();
        MeetingPage meetingPage = new MeetingPage();
        switchTo().window(1);
        meetingPage.getText().shouldHave(text(MEETING_TEST_TEXT));
    }

    @Test
    public void verifyPreguntasFrecuentesTestS6() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getPreguntasFrecuentes().click();
        FAQPage faqPage = new FAQPage();
        faqPage.getHeaderText().shouldHave(text(FAQ_HEADER_TEXT));
    }

}
