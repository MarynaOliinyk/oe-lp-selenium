package com.openenglish.login.fields_validation;


import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class C144VerifyReestablecerContrasenaTest extends TestBase {

    @Test
    public void verifyReestablecerContrasenaTest (){
        positiveLogIn();
        logOut();
        loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getRequestFormTitle().shouldHave(text(resetPasswordFormTitle));
        recoveryPage.getEmail().shouldBe(visible);
    }
}
