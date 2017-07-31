package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import java.io.IOException;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.USER_NICK_NAME;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.LOGIN_TOOLTIP_PASSWORD;
import static com.openenglish.core.TestData.Login.LOGIN_TOOLTIP_SECURITY_CODE;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.UNREGISTERED_EMAIL;
import static com.openenglish.core.TestData.Recovery.RECOVERY_TOOLTIP_EMAIL;

public class C8LoginWithIncorrectCredentialsTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void loginWithUnregisteredEmailTestS1() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logIn(UNREGISTERED_EMAIL, CORRECT_PASSWORD);
        page.loginPage.getTooltip().should(exist);
        page.loginPage.getTooltipText().shouldHave(text(RECOVERY_TOOLTIP_EMAIL));
    }

    @Test
    public void loginWithIncorrectPasswordTestS2() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logIn(REGISTERED_EMAIL, USER_NICK_NAME);
        page.loginPage.getTooltip().should(exist);
        page.loginPage.getTooltipText().shouldHave(text(LOGIN_TOOLTIP_PASSWORD));
    }

    @Test
    public void loginWithIncorrectSecurityCodeTestS3() throws IOException {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logIn(REGISTERED_EMAIL, USER_NICK_NAME);
        page.loginPage.logIn(REGISTERED_EMAIL, USER_NICK_NAME);
        page.loginPage.getEmail().val(REGISTERED_EMAIL);
        page.loginPage.getPassword().val(CORRECT_PASSWORD);
        page.loginPage.getSecurityField().sendKeys(USER_NICK_NAME);
        page.loginPage.getLoginButton().click();
        page.loginPage.getTooltip().should(exist);
        page.loginPage.getTooltipText().shouldHave(text(LOGIN_TOOLTIP_SECURITY_CODE));
    }

}
