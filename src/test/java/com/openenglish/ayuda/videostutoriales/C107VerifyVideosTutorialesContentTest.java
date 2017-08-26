package com.openenglish.ayuda.videostutoriales;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HowToVideosPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.HowToVideos.HOW_TO_VIDEOS_VIDEOS_DESCRIPTION_TEXT;
import static com.openenglish.core.TestData.HowToVideos.HOW_TO_VIDEOS_VIDEOS_TITLE_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C107VerifyVideosTutorialesContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private HowToVideosPage howToVideosPage = new HowToVideosPage();

    @Test
    public void verifyVideosTutorialesContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getVideosTutoriales().click();
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-246
        howToVideosPage.getImage().should(visible);
        howToVideosPage.getVideoContent().scrollTo().should(visible);
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-322
        howToVideosPage.getTitleOnVideos().should(visible, text(HOW_TO_VIDEOS_VIDEOS_TITLE_TEXT));
        howToVideosPage.getDescriptionOnVideo().should(visible, text(HOW_TO_VIDEOS_VIDEOS_DESCRIPTION_TEXT));
    }
}
