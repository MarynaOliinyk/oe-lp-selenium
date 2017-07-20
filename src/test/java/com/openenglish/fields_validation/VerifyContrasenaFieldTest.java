package com.openenglish.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;


public class VerifyContrasenaFieldTest extends TestBase {

    private String invalidPassword= getInstance().getProperty("invalid.password");
    private String toolTipText = getInstance().getProperty("login.tooltip.text.for.password");
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");

    @Test
    public void submitInvalidPasswordTest () {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email,password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.logIn(email, invalidPassword);
        loginPage.getTooltipText().shouldBe(visible).shouldHave(text(toolTipText));


        }
}
