package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;

public class С141VerifyCorreoElectronicoFieldTest extends TestBase {

    @Test
    public void submitUnregisteredEmailTest() {
        positiveLogIn();
        logOut();
        verifyEmail(unregisteredEmail, correctPassword);
        verifyEmail(emailWithoutATsymbol, correctPassword);
        verifyEmail(emailWithoutDotCom, correctPassword);

    }

    private void verifyEmail(String email, String password) {
        loginPage.getEmail().clear();
        loginPage.logIn(email, password);
        loginPage.getTooltipText().shouldBe(visible).shouldHave(text(recoveryTooltipEmail));
        back();
    }
}
