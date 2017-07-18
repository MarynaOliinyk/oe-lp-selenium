package com.openenglish.reset_password;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

/**
 * Created by so on 7/18/17.
 */
public class IncorrectEmailTest extends TestBase{
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String inicioLink = getInstance().getProperty("home.link.text");
    private String userName = getInstance().getProperty("user.name");
    private String resetPasswordFormTitle = getInstance().getProperty( "reset.password.form.title");
    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String toolTipText = getInstance().getProperty("recovery.toolTip.text");


    @Test
    public void ResetPasswordForIncorrectEmailTest() {
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
        loginPage.getPassword()
                .shouldHave(attribute("type", "password"));
        loginPage.cookieBannerVisibility();
        loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
        recoveryPage.getEmail().sendKeys(unregisteredEmail);
        recoveryPage.getSubmit().click();
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(toolTipText));

    }
}
