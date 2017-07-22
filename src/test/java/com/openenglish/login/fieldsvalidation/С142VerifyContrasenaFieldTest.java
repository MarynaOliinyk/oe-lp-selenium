package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


public class С142VerifyContrasenaFieldTest extends TestBase {

    @Test
    public void submitInvalidPasswordTest() {
        positiveLogIn();
        logOut();
        logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));

    }

    private void logInAndCheckText(String validEmail, String incorrectPassword, String tooltipTexts) {
        loginPage.logIn(validEmail, incorrectPassword);
        loginPage.getTooltipText().shouldBe(visible).shouldHave(text(tooltipTexts));
    }
}
