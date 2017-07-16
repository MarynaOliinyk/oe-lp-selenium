package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class LoginWithIncorrectCredentialsTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String registeredEmail = getInstance().getProperty("email");
    private String correctPassword = getInstance().getProperty("password");
    private String wrongPassword = getInstance().getProperty("user.name");
    private String tooltipEmailText = getInstance().getProperty("tooltip.email");
    private String tooltipPasswordText = getInstance().getProperty("tooltip.password");
    private String tooltipSecurityCodeText = "Parece que hay un error en la contraseña. Por favor, inténtelo de nuevo.";

    @Test(priority = 1)
    public void loginWithUnregisteredEmailTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.logIn(unregisteredEmail, correctPassword);
        loginPage.getTooltip().should(exist);
        loginPage.getTooltipText().shouldHave(text(tooltipEmailText));
    }
    // TODO Check where it's a bug with security
    @Test(priority = 2)
    public void loginWithIncorrectPasswordTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.getTooltip().should(exist);
        loginPage.getTooltipText().shouldHave(text(tooltipPasswordText));
    }

    // TODO Check where it's a bug with security
    @Test(enabled = false)
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
        loginPage.getTooltipText().shouldHave(text(tooltipSecurityCodeText));
    }

}
