package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class FailToLoginSeveralTimestTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String wrongPassword = getInstance().getProperty("user.name");
    private String registeredEmail = getInstance().getProperty("email");
    private String securityPlaceHolderText = getInstance().getProperty("security.placeholder");

    @Test
    public void logInRequiresSecurityTest(){
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
    }
}
