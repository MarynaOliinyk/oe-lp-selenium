package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.OpenenglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

/**
 * Created by so on 7/19/17.
 */
public class VerifyRegisterTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");

    @Test
    public void redirectedToRegisterPageTest (){
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getSignUp().click();
        OpenenglishPage openenglishPage = new OpenenglishPage();
        openenglishPage.getRegisterForm().shouldBe(visible);
    }
}
