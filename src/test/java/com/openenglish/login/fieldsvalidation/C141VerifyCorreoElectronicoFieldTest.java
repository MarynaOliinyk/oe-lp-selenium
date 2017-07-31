package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.UNREGISTERED_EMAIL;
import static com.openenglish.core.TestData.Recovery.EMAIL_WITHOUT_A_TSYMBOL;
import static com.openenglish.core.TestData.Recovery.EMAIL_WITHOUT_DOT_COM;

public class C141VerifyCorreoElectronicoFieldTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void submitUnregisteredEmailTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.verifyEmail(UNREGISTERED_EMAIL, CORRECT_PASSWORD);
        page.loginPage.verifyEmail(EMAIL_WITHOUT_A_TSYMBOL, CORRECT_PASSWORD);
        page.loginPage.verifyEmail(EMAIL_WITHOUT_DOT_COM, CORRECT_PASSWORD);
    }


}
