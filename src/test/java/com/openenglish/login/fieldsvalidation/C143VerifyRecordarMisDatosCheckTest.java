package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;


public class C143VerifyRecordarMisDatosCheckTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    //TODO BUG LPTRIAGE-170
    @Test
    public void rememberEnteredDataTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getRememberLogin().click();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.getEmail().shouldHave(value(REGISTERED_EMAIL));
//        page.loginPage.getPassword().shouldHave(value(password));
    }

}
