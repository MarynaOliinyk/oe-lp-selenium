package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;


public class VerifyContrasenaFieldTest extends TestBase {
    private String invalidPassword = getInstance().getProperty("invalid.password");
    private String toolTipText = getInstance().getProperty("login.tooltip.text.for.password");
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String securityPlaceHolderText = getInstance().getProperty("security.placeholder");
    private LoginPage loginPage = new LoginPage();

    @Test
    public void submitInvalidPasswordTest() {
        open("/");
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        logInAndCheckText(email, invalidPassword, toolTipText);
        logInAndCheckText(email, invalidPassword, toolTipText);
        loginPage.getSecurityField().shouldHave(attribute("placeholder", securityPlaceHolderText));

    }

    public void logInAndCheckText(String validEmail, String incorrectPassword, String tooltipTexts) {
        loginPage.logIn(validEmail, incorrectPassword);
        loginPage.getTooltipText().shouldBe(visible).shouldHave(text(tooltipTexts));
    }
}
