package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.OpenenglishPage;
import com.openenglish.pages.RecoveryPage;
import com.sun.xml.internal.bind.v2.TODO;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class VerifyLinksTest extends TestBase {

    private String resetPasswordFormTitle = getInstance().getProperty("reset.password.form.title");

// TODO Uncomment text verification when their language will be predictable

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
        loginPage.getPassword()
                .shouldHave(attribute("type", "password"));
        loginPage.cookieBannerVisibility();
        loginPage.getPasswordReset().click();

        RecoveryPage recoveryPage = new RecoveryPage();
//        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
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
