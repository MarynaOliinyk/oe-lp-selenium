package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class LoginTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String inicioLink = getInstance().getProperty("home.link.text");
    private String userName = getInstance().getProperty("user.name");

    @Test
    public void loginWithCorrectCredentialsTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                 .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
    }
}
