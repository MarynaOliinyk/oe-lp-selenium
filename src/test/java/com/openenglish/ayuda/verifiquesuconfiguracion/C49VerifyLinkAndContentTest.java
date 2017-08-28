package com.openenglish.ayuda.verifiquesuconfiguracion;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.MeetingPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Meeting.MEETING_ADOBE_CONNECT_HEADER_TEST_TEXT;
import static com.openenglish.core.TestData.Meeting.MEETING_TEST_TEXT;

public class C49VerifyLinkAndContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private MeetingPage meetingPage = new MeetingPage();

    @Test
    public void verifyLinkAndContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().click();
        page.inicioPage.getVerifiqueSuConfiguracion().click();
        switchTo().window(1);
        meetingPage.getText().should(text(MEETING_TEST_TEXT));
        meetingPage.getAdobeConnectHeaderTestText().should(text(MEETING_ADOBE_CONNECT_HEADER_TEST_TEXT));
        meetingPage.getAdobeConnectTest().should(visible);
    }
}
