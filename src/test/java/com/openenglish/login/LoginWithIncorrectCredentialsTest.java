package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class LoginWithIncorrectCredentialsTest extends TestBase {

    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String registeredEmail = getInstance().getProperty("email");
    private String correctPassword = getInstance().getProperty("password");
    private String wrongPassword = getInstance().getProperty("user.name");
    private String tooltipEmailText = getInstance().getProperty("tooltip.email");
    private String tooltipPasswordText = getInstance().getProperty("tooltip.password");
    private String tooltipSecurityCodeText = "Parece que hay un error en la contraseña. Por favor, inténtelo de nuevo.";

// TODO Uncomment text verification when their language will be predictable

    @Test
    public void loginWithUnregisteredEmailTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(unregisteredEmail, correctPassword);
        loginPage.getTooltip().should(exist);
//        loginPage.getTooltipText().shouldHave(text(tooltipEmailText));
    }

    @Test
    public void loginWithIncorrectPasswordTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.getTooltip().should(exist);
//        loginPage.getTooltipText().shouldHave(text(tooltipPasswordText));
    }

    @Test
    public void loginWithIncorrectSecurityCodeTest() throws IOException {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.getEmail().val(registeredEmail);
        loginPage.getPassword().val(correctPassword);
        loginPage.getSecurityField().sendKeys(wrongPassword);
        loginPage.getLoginButton().click();
        loginPage.getTooltip().should(exist);
//        loginPage.getTooltipText().shouldHave(text(tooltipSecurityCodeText));
    }

}
