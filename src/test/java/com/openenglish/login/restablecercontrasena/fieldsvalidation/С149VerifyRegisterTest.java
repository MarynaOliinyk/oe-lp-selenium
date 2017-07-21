package com.openenglish.login.restablecercontrasena.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenEnglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class С149VerifyRegisterTest extends TestBase {

    @Test
    public void redirectedToRegisterPageTest() {
        positiveLogIn();
        logOut();
        loginPage.getSignUp().click();
        OpenEnglishPage openEnglishPage = new OpenEnglishPage();
        openEnglishPage.getRegisterForm().shouldBe(visible);
    }
}
