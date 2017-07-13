package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class LoginTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");

    @Test
    public void loginWithCorrectCredentialsTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text("inicio"));
    }
}
