package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.unregisteredEmail;
import static com.openenglish.core.TestData.Recovery.emailWithoutATsymbol;
import static com.openenglish.core.TestData.Recovery.emailWithoutDotCom;
import static com.openenglish.core.TestData.Recovery.recoveryTooltipEmail;

public class C141VerifyCorreoElectronicoFieldTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void submitUnregisteredEmailTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        page.logOut();
        verifyEmail(unregisteredEmail, correctPassword);
        verifyEmail(emailWithoutATsymbol, correctPassword);
        verifyEmail(emailWithoutDotCom, correctPassword);
    }

    private void verifyEmail(String email, String password) {
        page.loginPage.getEmail().clear();
        page.loginPage.logIn(email, password);
        page.loginPage.getTooltipText().shouldBe(visible).shouldHave(text(recoveryTooltipEmail));
        back();
    }
}
