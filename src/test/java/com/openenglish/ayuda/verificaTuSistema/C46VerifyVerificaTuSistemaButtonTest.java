package com.openenglish.ayuda.verificaTuSistema;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TestYourSystemPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C46VerifyVerificaTuSistemaButtonTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private TestYourSystemPage testYourSystemPage = new TestYourSystemPage();

    @Test
    public void verifyVerificaTuSistemaButtonTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getVerificaTuSistema().click();
        // TODO [QAA-65]C102 Verify Ayuda menu links (Scenario 3) (https://openenglish.jira.com/browse/NSB-168)
//        testYourSystemPage.getHeaderText().shouldHave(text(TEST_YOUR_SYSTEM_HEADER_TEXT));
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-325
    }
}
