package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.OpenenglishPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class VerifyLinksTest extends TestBase {

    private String resetPasswordFormTitle = getInstance().getProperty("reset.password.form.title");
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String wrongPassword = getInstance().getProperty("user.name");
    private String registeredEmail = getInstance().getProperty("email");

    @Test
    public void verifyTooltipIsPresentTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.getQuestionIcon().hover();
        loginPage.getTooltip().should(visible);
    }

    @Test
    public void verifyResetPasswordPageIsOpenTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().should(exist).hover();
        inicioPage.getLogOutLink().click();
        loginPage.getPassword()
                .shouldHave(attribute("type", "password"));
        loginPage.getPasswordReset().click();

        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }

    @Test
    public void verifyRegisterFormIsOpenTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getPassword()
                .shouldHave(attribute("type", "password"));
        loginPage.cookieBannerVisibility();
        loginPage.getSignUp().click();
        OpenenglishPage openenglishPage = new OpenenglishPage();
        openenglishPage.getRegisterForm().shouldBe(visible);
    }

    @Test
    public void recoveryPasswordTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().should(visible).hover();
        inicioPage.getLogOutLink().click();
        loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }

    //TODO Bug with chat (Chat page is opened in a new window.)
    @Test
    public void chatPageIsOpenTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.logIn(registeredEmail, wrongPassword);
        loginPage.getPassword().should(visible).val(wrongPassword);
        loginPage.getLoginButton().should(visible).click();
        loginPage.getPassword().should(exist).sendKeys(wrongPassword);
        loginPage.getLoginButton().should(visible).click();
        loginPage.getSecurityField().sendKeys(wrongPassword);
        loginPage.getPassword().should(visible).val(wrongPassword);
        loginPage.getLoginButton().click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChat().shouldBe(visible).click();
    }
}
