package com.openenglish.menu;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C103VerifyCuentaMenuLinksScenario3Test extends TestBase {

    @Test
    public void salirCuentaMenuSuboptionVerificationTest() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAccountMenu().hover();
        inicioPage.getCuentaSuboptions().shouldBe(visible);
        inicioPage.getLogOutLink().shouldBe(visible).
                shouldHave(exactText(salirButtonText)).click();
        loginPage.getLoginForm().shouldBe(visible);
        inicioPage.getUserName().shouldNotHave(text(userName));
    }

}
