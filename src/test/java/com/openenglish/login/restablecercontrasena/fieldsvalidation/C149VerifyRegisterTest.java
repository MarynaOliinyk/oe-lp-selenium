package com.openenglish.login.restablecercontrasena.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class C149VerifyRegisterTest extends TestBase {

    @Test
    public void redirectedToRegisterPageTest() {
        positiveLogIn();
        logOut();
        loginPage.getSignUp().click();
        RegisterPage regForm = new RegisterPage();
        regForm.getRegisterForm().shouldBe(visible);
    }
}
