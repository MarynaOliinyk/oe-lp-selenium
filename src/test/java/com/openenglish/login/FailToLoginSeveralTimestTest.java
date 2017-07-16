package com.openenglish.login;

import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class FailToLoginSeveralTimestTest {
    private String wrongPassword = getInstance().getProperty("user.name");
    private String registeredEmail = getInstance().getProperty("email");
    private String securityPlaceHolderText = getInstance().getProperty("security.placeholder");

    @Test
    public void logInRequiresSecurityTest(){
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.getSecurityField().shouldHave(text(securityPlaceHolderText));
    }
}
