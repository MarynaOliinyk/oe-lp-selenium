package com.openenglish.ayuda.adobeconnectguiarapida;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ParticipantsGuidePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.Attribute.SRC;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.ParticipantsGuide.PARTICIPANT_GUIDE_LINK;
import static com.openenglish.core.TestData.ParticipantsGuide.PARTICIPANT_GUIDE_NAMES_PDF_FILE;
import static org.testng.Assert.assertTrue;

public class C48VerifyLinksAndContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private ParticipantsGuidePage participantsGuidePage = new ParticipantsGuidePage();

    @Test
    public void verifyLinksAndContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getAdobeConnectGuiaRapida().followLink();
        switchTo().window(1);
        assertTrue(participantsGuidePage.getPageTitle().getAttribute(SRC).contains(PARTICIPANT_GUIDE_NAMES_PDF_FILE));
        assertTrue(url().contains(PARTICIPANT_GUIDE_LINK));
    }
}
