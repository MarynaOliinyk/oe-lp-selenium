package com.openenglish.login.restablecercontrasena.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C149VerifyRegisterTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void redirectedToRegisterPageTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.getSignUp().click();
        RegisterPage regForm = new RegisterPage();
        regForm.getRegisterForm().shouldBe(visible);
    }
}
