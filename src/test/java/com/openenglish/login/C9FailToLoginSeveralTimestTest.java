package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.securityPlaceHolderText;
import static com.openenglish.core.TestData.Login.userName;

public class C9FailToLoginSeveralTimestTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void logInRequiresSecurityTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logIn(registeredEmail, userName);
        page.loginPage.logIn(registeredEmail, userName);
        page.loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
    }
}
