package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C359IntroduccionVideoTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void introduccionVideoTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
    }
}


