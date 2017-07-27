package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import java.io.IOException;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.userNickName;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.loginTooltipPassword;
import static com.openenglish.core.TestData.Login.loginTooltipSecurityCode;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.unregisteredEmail;
import static com.openenglish.core.TestData.Recovery.recoveryTooltipEmail;

public class C8LoginWithIncorrectCredentialsTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void loginWithUnregisteredEmailTestS1() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logIn(unregisteredEmail, correctPassword);
        page.loginPage.getTooltip().should(exist);
        page.loginPage.getTooltipText().shouldHave(text(recoveryTooltipEmail));
    }

    @Test
    public void loginWithIncorrectPasswordTestS2() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logIn(registeredEmail, userNickName);
        page.loginPage.getTooltip().should(exist);
        page.loginPage.getTooltipText().shouldHave(text(loginTooltipPassword));
    }

    @Test
    public void loginWithIncorrectSecurityCodeTestS3() throws IOException {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logIn(registeredEmail, userNickName);
        page.loginPage.logIn(registeredEmail, userNickName);
        page.loginPage.getEmail().val(registeredEmail);
        page.loginPage.getPassword().val(correctPassword);
        page.loginPage.getSecurityField().sendKeys(userNickName);
        page.loginPage.getLoginButton().click();
        page.loginPage.getTooltip().should(exist);
        page.loginPage.getTooltipText().shouldHave(text(loginTooltipSecurityCode));
    }

}
