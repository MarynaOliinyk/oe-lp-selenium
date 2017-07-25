package com.openenglish.menu;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class C103VerifyCuentaMenuLinksTest extends TestBase {

    @Test
    public void cuentaMenuLinksVerificationScenario1Test() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAccountMenu().hover();
        inicioPage.getCuentaSuboptions().shouldBe(visible);
        inicioPage.getMensajesCuentaSuboptionButton().shouldBe(visible).shouldHave(exactText(mensajesButtonText)).click();
        assertTrue(url().endsWith(notificationsUrlEndWithText));
    }

    @Test
    public void preferenciasCuentaMenuSuboptionVerificationScenario2Test() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAccountMenu().hover();
        inicioPage.getCuentaSuboptions().shouldBe(visible);
        inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible).
                shouldHave(exactText(preferenciasButtonText)).click();
        preferencesPage.getMiPerfilTab().shouldBe(visible).shouldHave(exactText(miPerfilTabText));
        assertTrue(url().endsWith(preferencesUrlEndWithText));
    }

    @Test
    public void salirCuentaMenuSuboptionVerificationScenario3Test() {
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
