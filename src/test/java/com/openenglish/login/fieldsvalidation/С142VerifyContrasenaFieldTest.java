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
        loginPage.logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        loginPage.logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
    }


}
