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


public class IncorrectEmailTest extends TestBase {
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    ;
    private String resetPasswordFormTitle = getInstance().getProperty("reset.password.form.title");
    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String toolTipText = getInstance().getProperty("recovery.toolTip.text");

    @Test
    public void resetPasswordForIncorrectEmailTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getPasswordReset().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.enterEmailAndSubmit(unregisteredEmail);
        recoveryPage.getTooltipText().shouldBe(visible).shouldHave(text(toolTipText));

    }
}
