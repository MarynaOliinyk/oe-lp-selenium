package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;

public class C359IntroduccionVideoTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void introduccionVideoTest() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
    }
}


