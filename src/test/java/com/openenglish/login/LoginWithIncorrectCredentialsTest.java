package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class LoginWithIncorrectCredentialsTest extends TestBase {

    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String anyPassword = getInstance().getProperty("password");

    @Test
    public void loginWithUnregisteredEmailTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(unregisteredEmail, anyPassword);
        $ (loginPage.getTooltip()).should(exist);
    }

}
