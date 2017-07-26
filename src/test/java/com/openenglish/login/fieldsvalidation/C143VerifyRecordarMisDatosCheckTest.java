package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;


public class C143VerifyRecordarMisDatosCheckTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    //TODO BUG LPTRIAGE-170
    @Test
    public void rememberEnteredDataTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getRememberLogin().click();
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getEmail().shouldHave(value(registeredEmail));
//        page.loginPage.getPassword().shouldHave(value(password));
    }

}
