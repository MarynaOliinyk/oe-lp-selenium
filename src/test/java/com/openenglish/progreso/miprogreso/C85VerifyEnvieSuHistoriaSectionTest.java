package com.openenglish.progreso.miprogreso;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ProfilePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Profile.PROFILE_HEADER_TEXT;

public class C85VerifyEnvieSuHistoriaSectionTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyEnvieSuHistoriaSectionTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible, text(PROFILE_HEADER_TEXT));
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-315
    }
}