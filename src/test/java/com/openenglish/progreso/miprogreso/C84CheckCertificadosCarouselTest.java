package com.openenglish.progreso.miprogreso;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ProfilePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Profile.PROFILE_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE;
import static org.testng.Assert.assertTrue;

public class C84CheckCertificadosCarouselTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkCertificadosCarouselTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible, text(PROFILE_HEADER_TEXT));
        profilePage.getCertificatesCarousel().scrollTo().should(visible);
        assertTrue(profilePage.getMessageOverActualCertificate().should(visible).getText().matches(PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE));
        profilePage.getPrevButton().should(visible).click();
        profilePage.getPrevCertificate().should(visible,empty);
        profilePage.getNextButton().should(visible).click();
        assertTrue(profilePage.getMessageOverActualCertificate().should(visible).getText().matches(PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE));
    }
}

