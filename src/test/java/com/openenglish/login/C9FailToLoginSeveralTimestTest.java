package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.SECURITY_PLACE_HOLDER_TEXT;

public class C9FailToLoginSeveralTimestTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void logInRequiresSecurityTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logIn(REGISTERED_EMAIL, INICIO_USER_NICK_NAME);
        page.loginPage.logIn(REGISTERED_EMAIL, INICIO_USER_NICK_NAME);
        page.loginPage.getSecurityField().shouldHave(attribute("placeholder", SECURITY_PLACE_HOLDER_TEXT));
    }
}
