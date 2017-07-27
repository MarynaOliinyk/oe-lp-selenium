package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.userNickName;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.securityPlaceHolderText;

public class C9FailToLoginSeveralTimestTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void logInRequiresSecurityTest() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logIn(registeredEmail, userNickName);
        page.loginPage.logIn(registeredEmail, userNickName);
        page.loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
    }
}
