package com.openenglish.login.restablecercontrasena;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class C10VerifyResetPasswordEmailIsSentTest extends TestBase{
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");

    @Test
    public void verifyResetPasswordEmailIsSentTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getRecoverLink().click();
    }
}
