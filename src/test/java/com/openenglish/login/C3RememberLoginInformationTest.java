package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;

public class C3RememberLoginInformationTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void rememberLoginInformationTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getRememberLogin().should(exist).click();
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getEmail().shouldHave(value(registeredEmail));
    }
}
