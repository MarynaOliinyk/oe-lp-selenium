package com.openenglish.ayuda.verificatusistema;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TestYourSystemPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.TestYourSystem.TEST_YOUR_SYSTEM_OTHER_REQUIREMENTS_TEXT;
import static com.openenglish.core.TestData.TestYourSystem.TEST_YOUR_SYSTEM_REQUIREMENTS_BROWSER_TEXT;
import static com.openenglish.core.TestData.TestYourSystem.TEST_YOUR_SYSTEM_REQUIREMENTS_SYSTEM_TEXT;
import static com.openenglish.core.TestData.TestYourSystem.TEST_YOUR_SYSTEM_VERIFICA_TU_SISTEMA_BUTTON_TEXT;

public class C45VerifyVerificaTuSistemaContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private TestYourSystemPage testYourSystemPage = new TestYourSystemPage();

    @Test
    public void verifyVerificaTuSistemaContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getVerificaTuSistema().click();
        // TODO [QAA-65]C102 Verify Ayuda menu links (Scenario 3) (https://openenglish.jira.com/browse/NSB-168)
//        testYourSystemPage.getHeaderText().shouldHave(text(TEST_YOUR_SYSTEM_HEADER_TEXT));
        testYourSystemPage.getSystemRequirements().should(visible, text(TEST_YOUR_SYSTEM_REQUIREMENTS_SYSTEM_TEXT));
        testYourSystemPage.getBrowserRequirements().should(visible, text(TEST_YOUR_SYSTEM_REQUIREMENTS_BROWSER_TEXT));
        testYourSystemPage.getVerificarTuSistemaButton().should(visible,text(TEST_YOUR_SYSTEM_VERIFICA_TU_SISTEMA_BUTTON_TEXT));
        testYourSystemPage.getOtherRequirements().should(visible,text(TEST_YOUR_SYSTEM_OTHER_REQUIREMENTS_TEXT));
    }
}
