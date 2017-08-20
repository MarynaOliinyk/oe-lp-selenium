package com.openenglish.ayuda.videosTutoriales;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HowToVideosPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.STYLE;
import static com.openenglish.core.AttributeValue.DISPLAY_BLOCK;
import static com.openenglish.core.AttributeValue.DISPLAY_NONE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C44VerifyVideosTest extends DriverBase {

        private AbstractPage page = new AbstractPage();
        private HowToVideosPage howToVideosPage = new HowToVideosPage();

        @Test
        public void verifyVideosTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getVideosTutoriales().click();
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-246
        howToVideosPage.getImage().should(visible);
        howToVideosPage.getVideoContent().scrollTo().should(visible);
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-322
        howToVideosPage.getVideo().should(visible).click();
        howToVideosPage.getPopUpVideo().should(visible);
//        howToVideosPage.getPopUpControlPanel().hover().waitUntil(visible,3000);
//        howToVideosPage.getPlayButtonOnPopUp().waitUntil(visible,3000).click();
        page.jsCSSClick("div[class='play-btn']");
        howToVideosPage.getPlayButtonOnPopUp().should(attribute(STYLE, DISPLAY_NONE));
        howToVideosPage.getPauseButtonPopUp().should(attribute(STYLE, DISPLAY_BLOCK)).click();
        howToVideosPage.getPlayButtonOnPopUp().should(visible, attribute(STYLE, DISPLAY_BLOCK));
        howToVideosPage.getForwardButtonPopUp().should(visible).click();
        howToVideosPage.getBackwardButtonPopUp().should(visible).click();

    }
}