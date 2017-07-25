package com.openenglish.menu;


import com.codeborne.selenide.WebDriverRunner;
import com.openenglish.core.TestBase;
import com.openenglish.pages.HowToVideosPage;
import com.openenglish.pages.TalkNowPage;
import com.openenglish.pages.TestYourSystemPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C102VerifyAyudaMenuLinksTest extends TestBase {

    @BeforeMethod
    public void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAyudaDropDown().hover();
    }

    @Test
    public void verifyContactenosTestS1() {
        inicioPage.getContactenos().click();
        TalkNowPage talkNowPage = new TalkNowPage();
        talkNowPage.getHeaderText().shouldHave(text(talkNowHeaderText));

    }

    @Test
    public void verifyVideosTutorialesTestS2() {
        inicioPage.getVideosTutoriales().click();
        HowToVideosPage howToVideosPage = new HowToVideosPage();
        howToVideosPage.getImage().isDisplayed();

    }

    @Test
    public void verifyVerificaTuSistemaTestS3() {
        inicioPage.getVerificaTuSistema().click();
        TestYourSystemPage testYourSystemPage = new TestYourSystemPage();
        testYourSystemPage.getHeaderText().shouldHave(text(testYourSystemHeaderText));

    }

    @Test
    public void verifyAdobeConnectGuiaRapidaTestS4() {
        inicioPage.getAdobeConnectGuiaRapida().click();
        WebDriverRunner.url().contains(containsPdfFile);

    }
}
