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
import static com.openenglish.core.TestData.FAQ.faqHeaderText;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.userNickName;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Meeting.meetingTestText;
import static com.openenglish.core.TestData.ParticipantsGuidePage.containsPdfFile;
import static com.openenglish.core.TestData.TalkNow.talkNowHeaderText;
import static com.openenglish.core.TestData.TestYourSystem.testYourSystemHeaderText;
import static org.testng.Assert.assertTrue;

public class C102VerifyAyudaMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    private void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userNickName));
        page.inicioPage.getAyudaDropDown().hover();
    }

    @Test
    public void verifyContactenosTestS1() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getContactenos().click();
        TalkNowPage talkNowPage = new TalkNowPage();
        talkNowPage.getHeaderText().shouldHave(text(talkNowHeaderText));

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
        testYourSystemPage.getHeaderText().shouldHave(text(testYourSystemHeaderText));

    }

    @Test
    public void verifyAdobeConnectGuiaRapidaTestS4() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getAdobeConnectGuiaRapida().click();
        switchTo().window(1);
        ParticipantsGuidePage participantsGuidePage = new ParticipantsGuidePage();
        assertTrue(participantsGuidePage.getPageTitle().getAttribute("src").contains(containsPdfFile));

    }

    @Test
    public void verifyVerifiqueSuConfiguracionTestS5() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getVerifiqueSuConfiguracion().click();
        MeetingPage meetingPage = new MeetingPage();
        switchTo().window(1);
        meetingPage.getText().shouldHave(text(meetingTestText));
    }

    @Test
    public void verifyPreguntasFrecuentesTestS6() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getPreguntasFrecuentes().click();
        FAQPage faqPage = new FAQPage();
        faqPage.getHeaderText().shouldHave(text(faqHeaderText));
    }

}
