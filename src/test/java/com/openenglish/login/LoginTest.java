package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.OpenenglishPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.openenglish.util.PropertiesCache.getInstance;

public class LoginTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String inicioLink = getInstance().getProperty("home.link.text");
    private String userName = getInstance().getProperty("user.name");
    private String resetPasswordFormTitle = getInstance().getProperty("reset.password.form.title");

    @Test
    public void loginWithCorrectCredentialsTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getPassword()
                 .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
    }

    @Test
    public void verifyLinksScenario1Test() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getCloseCookieBannerChevron().click();
        $ (loginPage.getQuestionIcon().hover().shouldHave(attribute
                ("class","fa fa-question-circle remember-help")));
    }

    @Test
    public void verifyLinksScenario2Test() {
        open("/");
        LoginPage loginPage = new LoginPage();
        RecoveryPage recoveryPage = new RecoveryPage();
        loginPage.getPassword()
                .shouldHave(attribute("type", "password"));
        loginPage.getCloseCookieBannerChevron().click();
        loginPage.getPasswordReset().click();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().isDisplayed();
    }

    @Test
    public void verifyLinksScenario3Test() {
        open("/");
        LoginPage loginPage = new LoginPage();
        OpenenglishPage openenglishPage = new OpenenglishPage();
        loginPage.getPassword()
                .shouldHave(attribute("type", "password"));
        loginPage.getCloseCookieBannerChevron().click();
        loginPage.getSignUp().click();
        openenglishPage.getRegisterForm().isDisplayed();
    }

}
