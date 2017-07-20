package com.openenglish.login.reset_password;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;


public class VerifyEmailFieldTest extends TestBase {

    private String emailWithoutATsymbol = getInstance().getProperty("recovery.email.without@");
    private String emailWithoutDotCom = getInstance().getProperty("recovery.email.without.com");
    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String toolTipText = getInstance().getProperty("recovery.tooltip.text");
    private String notValidEmailText = getInstance().getProperty("recovery.tooltip.not.valid.email");
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");


    @Test
    public void enterUnregisteredEmailTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getPasswordReset().shouldBe(visible).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.enterEmailAndSubmit(unregisteredEmail);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(toolTipText));
        recoveryPage.getEmail().clear();
        recoveryPage.getEmail().sendKeys(emailWithoutATsymbol);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(notValidEmailText));
        recoveryPage.getEmail().clear();
        recoveryPage.getEmail().sendKeys(emailWithoutDotCom);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(notValidEmailText));

    }
}
