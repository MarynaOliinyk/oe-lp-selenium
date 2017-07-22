package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

public class C146VerifyTieneProblemasDeIngresoPopUpTest extends TestBase{
//TODO Chat is not enabled
    @Test
    public void verifyTieneProblemasDeIngresoPopUpTest (){
        positiveLogIn();
        logOut();
        loginPage.logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        loginPage.logInAndCheckText(email, invalidPassword, loginTooltipPassword);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
        loginPage.getPopUpResetPassword().shouldBe(visible).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getChatButton().shouldBe(visible).click();
    }
}
