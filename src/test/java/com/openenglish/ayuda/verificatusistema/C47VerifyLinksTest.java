package com.openenglish.ayuda.verificatusistema;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TestYourSystemPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C47VerifyLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private TestYourSystemPage testYourSystemPage = new TestYourSystemPage();

    @Test
    public void verifyVerifyLinksTest() throws InterruptedException {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getVerificaTuSistema().click();
        // TODO https://openenglish.jira.com/browse/NSB-168
//        testYourSystemPage.getHeaderText().shouldHave(text(TEST_YOUR_SYSTEM_HEADER_TEXT));
        testYourSystemPage.getWindowsLinkOnOtros().should(visible).click();
        testYourSystemPage.getPopUpConfiguration().should(visible);
        testYourSystemPage.getClosePopupButton().should(visible).click();
        testYourSystemPage.getMacLinkOnOtros().should(visible).click();
        testYourSystemPage.getPopUpConfiguration().should(visible);
        testYourSystemPage.getClosePopupButton().should(visible).click();
        testYourSystemPage.getVerificacionDeEquipoLinkOnOtros().should(visible).click();
        Thread.sleep(3000);
        executeJavaScript("document.getElementById('video').play();");
        Thread.sleep(3000);
        executeJavaScript("document.getElementById('video').pause();");
        Thread.sleep(3000);
        testYourSystemPage.getClosePopupButton().should(visible).click();
        testYourSystemPage.getHeaderText().should(visible);
    }
}
