package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.unregisteredEmail;
import static com.openenglish.core.TestData.Recovery.emailWithoutATsymbol;
import static com.openenglish.core.TestData.Recovery.emailWithoutDotCom;

public class C141VerifyCorreoElectronicoFieldTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void submitUnregisteredEmailTest() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.verifyEmail(unregisteredEmail, correctPassword);
        page.loginPage.verifyEmail(emailWithoutATsymbol, correctPassword);
        page.loginPage.verifyEmail(emailWithoutDotCom, correctPassword);
    }


}
