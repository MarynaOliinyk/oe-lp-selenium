package com.openenglish.login.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.PLACEHOLDER;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.INVALID_PASSWORD;
import static com.openenglish.core.TestData.Login.INVALID_SECURITY_CODE;
import static com.openenglish.core.TestData.Login.LOGIN_TOOLTIP_PASSWORD;
import static com.openenglish.core.TestData.Login.LOGIN_TOOLTIP_SECURITY_CODE;
import static com.openenglish.core.TestData.Login.POP_UP_INVALID_SECURITY_CODE;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.SECURITY_PLACE_HOLDER_TEXT;

public class C145VerifyIngreseTextoDeSeguridadTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void submitInvalidPasswordTest() {
        open(LP_URL);
        page.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.logOut();
        page.loginPage.logInAndCheckText(REGISTERED_EMAIL, INVALID_PASSWORD, LOGIN_TOOLTIP_PASSWORD);
        page.loginPage.logInAndCheckText(REGISTERED_EMAIL, INVALID_PASSWORD, LOGIN_TOOLTIP_PASSWORD);
        page.loginPage.getSecurityField().shouldHave(attribute(PLACEHOLDER, SECURITY_PLACE_HOLDER_TEXT));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.loginPage.getSecurityField().sendKeys(INVALID_SECURITY_CODE);
        page.loginPage.getLoginButton().click();
        page.loginPage.getPopUpTextAfterIncorrectCode().shouldBe(visible).shouldHave(text(POP_UP_INVALID_SECURITY_CODE));
        page.loginPage.getPopUpCloseAfterIncorrectCode().shouldBe(visible).click();
        page.loginPage.getTooltipText().shouldHave(text(LOGIN_TOOLTIP_SECURITY_CODE));
    }


}

