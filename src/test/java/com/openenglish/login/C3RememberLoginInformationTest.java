package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C3RememberLoginInformationTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void rememberLoginInformationTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getRememberLogin().should(exist).click();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        //TODO BUG LPTRIAGE-302 https://openenglish.jira.com/browse/LPTRIAGE-302
//        page.loginPage.getEmail().shouldHave(value(REGISTERED_EMAIL));
    }
}
