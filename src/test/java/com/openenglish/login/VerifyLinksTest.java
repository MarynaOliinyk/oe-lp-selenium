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

    @Test
    public void verifyTooltipIsPresentTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.cookieBannerVisibility();
        loginPage.getQuestionIcon().hover();
        loginPage.getTooltip().should(exist);
    }

    @Test
    public void verifyResetPasswordPageIsOpenTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getPassword()
                 .shouldHave(attribute("type", "password"));
        loginPage.cookieBannerVisibility();
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

}
