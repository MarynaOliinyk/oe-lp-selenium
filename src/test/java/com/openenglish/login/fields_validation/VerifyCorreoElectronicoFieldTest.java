package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class VerifyCorreoElectronicoFieldTest extends TestBase {
    private String emailWithoutATsymbol = getInstance().getProperty("recovery.email.without@");
    private String emailWithoutDotCom = getInstance().getProperty("recovery.email.without.com");
    private String unregisteredEmail = getInstance().getProperty("unregistered.email");
    private String toolTipText = getInstance().getProperty("recovery.tooltip.text");
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private LoginPage loginPage = new LoginPage();

    @Test
    public void submitUnregisteredEmailTest() {
        open("/");
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        verifyEmail(unregisteredEmail, password);
        verifyEmail(emailWithoutATsymbol, password);
        verifyEmail(emailWithoutDotCom, password);

    }

    private void verifyEmail(String email, String password) {
        loginPage.getEmail().clear();
        loginPage.logIn(email, password);
        loginPage.getTooltipText().shouldBe(visible).shouldHave(text(toolTipText));
        back();
    }
}
