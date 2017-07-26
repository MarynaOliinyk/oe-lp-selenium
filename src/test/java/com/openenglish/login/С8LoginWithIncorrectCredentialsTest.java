package com.openenglish.login;

import com.openenglish.core.TestBase;
import java.io.IOException;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class С8LoginWithIncorrectCredentialsTest extends TestBase {

    @Test
    public void loginWithUnregisteredEmailTestS1() {
        positiveLogIn();
        logOut();
        loginPage.logIn(unregisteredEmail, correctPassword);
        loginPage.getTooltip().should(exist);
        loginPage.getTooltipText().shouldHave(text(recoveryTooltipEmail));
    }

    @Test
    public void loginWithIncorrectPasswordTestS2() {
        positiveLogIn();
        logOut();
        loginPage.logIn(registeredEmail, userNickName);
        loginPage.getTooltip().should(exist);
        loginPage.getTooltipText().shouldHave(text(loginTooltipPassword));
    }

    @Test
    public void loginWithIncorrectSecurityCodeTestS3() throws IOException {
        positiveLogIn();
        logOut();
        loginPage.logIn(registeredEmail, userNickName);
        loginPage.logIn(registeredEmail, userNickName);
        loginPage.getEmail().val(registeredEmail);
        loginPage.getPassword().val(correctPassword);
        loginPage.getSecurityField().sendKeys(userNickName);
        loginPage.getLoginButton().click();
        loginPage.getTooltip().should(exist);
        loginPage.getTooltipText().shouldHave(text(loginTooltipSecurityCode));
    }

}
