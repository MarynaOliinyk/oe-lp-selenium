package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.invalidPassword;
import static com.openenglish.core.TestData.Login.invalidSecurityCode;
import static com.openenglish.core.TestData.Login.loginTooltipPassword;
import static com.openenglish.core.TestData.Login.loginTooltipSecurityCode;
import static com.openenglish.core.TestData.Login.popUpInvalidSecurityCode;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.securityPlaceHolderText;

public class C145VerifyIngreseTextoDeSeguridadTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void submitInvalidPasswordTest() {
        open(lpUrl);
        page.logIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.logInAndCheckText(registeredEmail, invalidPassword, loginTooltipPassword);
        page.loginPage.logInAndCheckText(registeredEmail, invalidPassword, loginTooltipPassword);
        page.loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.loginPage.getSecurityField().sendKeys(invalidSecurityCode);
        page.loginPage.getLoginButton().click();
        page.loginPage.getPopUpTextAfterIncorrectCode().shouldBe(visible).shouldHave(text(popUpInvalidSecurityCode));
        page.loginPage.getPopUpCloseAfterIncorrectCode().shouldBe(visible).click();
        page.loginPage.getTooltipText().shouldHave(text(loginTooltipSecurityCode));
    }


}

