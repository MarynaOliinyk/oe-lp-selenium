package com.openenglish.login;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;

public class С9FailToLoginSeveralTimestTest extends TestBase {

    @Test
    public void logInRequiresSecurityTest() {
        positiveLogIn();
        logOut();
        loginPage.logIn(registeredEmail, userNickName);
        loginPage.logIn(registeredEmail, userNickName);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
    }
}
