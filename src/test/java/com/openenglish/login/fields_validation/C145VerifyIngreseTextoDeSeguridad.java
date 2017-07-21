package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C145VerifyIngreseTextoDeSeguridad extends TestBase {

    @Test
    public void submitInvalidPasswordTest() {
        positiveLogIn();
        logOut();
        logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
        loginPage.logIn(email, password);
        loginPage.getSecurityField().sendKeys(invalidSecurityCode);
        loginPage.getLoginButton().click();
        loginPage.getPopUpTextAfterIncorrectCode().shouldBe(visible).shouldHave(text(popUpInvalidSecurityCode));
        loginPage.getPopUpCloseAfterIncorrectCode().shouldBe(visible).click();
        loginPage.getTooltipText().shouldHave(text(loginTooltipSecurityCode));
    }

    private void logInAndCheckText(String validEmail, String incorrectPassword, String tooltipTexts) {
        loginPage.logIn(validEmail, incorrectPassword);
        loginPage.getTooltipText().shouldBe(visible).shouldHave(text(tooltipTexts));
    }
}

