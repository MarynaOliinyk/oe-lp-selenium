package com.openenglish.login;

import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class IntroduccionVideoTest {
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");

    @Test
    public void introduccionVideoTest(){
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);

    }
}
