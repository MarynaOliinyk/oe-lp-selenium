package com.openenglish.ayuda.videostutoriales;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HowToVideosPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.STYLE;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static org.testng.Assert.assertTrue;

public class C44VerifyVideosTest extends DriverBase {

        private AbstractPage page = new AbstractPage();
        private HowToVideosPage howToVideosPage = new HowToVideosPage();

        @Test
        public void verifyVideosTest() throws InterruptedException {
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
                Thread.sleep(3000);
                executeJavaScript("document.getElementById('video').play();");
                Thread.sleep(3000);
                executeJavaScript("document.getElementById('video').pause();");
                Thread.sleep(3000);

                String backwardVideoBefore[] = howToVideosPage.getBufferVideo().getAttribute(STYLE).split("[\\ %]");
                WebElement backButton = howToVideosPage.getBackwardButtonPopUp().getWrappedElement();
                executeJavaScript("return arguments[0].click();", backButton);
                Thread.sleep(3000);
                String backwardVideoAfter[] = howToVideosPage.getBufferVideo().getAttribute(STYLE).split("[\\ %]");
                double valueBeforeBack = Double.parseDouble(backwardVideoBefore[1]);
                double valueAfterBack = Double.parseDouble(backwardVideoAfter[1]);
                assertTrue(valueBeforeBack > valueAfterBack);
                String forwardVideoBefore[] = howToVideosPage.getBufferVideo().getAttribute(STYLE).split("[\\ %]");
                WebElement forwardButton = howToVideosPage.getForwardButtonPopUp().getWrappedElement();
                executeJavaScript("return arguments[0].click();", forwardButton);
                Thread.sleep(3000);
                String forwardVideoAfter[] = howToVideosPage.getBufferVideo().getAttribute(STYLE).split("[\\ %]");
                double valueBeforeForward = Double.parseDouble(forwardVideoBefore[1]);
                double valueAfterForward = Double.parseDouble(forwardVideoAfter[1]);
                assertTrue(valueBeforeForward < valueAfterForward);
        }
}