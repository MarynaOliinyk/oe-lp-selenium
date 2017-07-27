package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.mensajesButtonText;
import static com.openenglish.core.TestData.Inicio.preferenciasButtonText;
import static com.openenglish.core.TestData.Inicio.salirButtonText;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.Notifications.notificationsUrlEndWithText;
import static com.openenglish.core.TestData.Preferences.miPerfilTabText;
import static com.openenglish.core.TestData.Preferences.preferencesUrlEndWithText;
import static org.testng.Assert.assertTrue;

public class C103VerifyCuentaMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void cuentaMenuLinksVerificationScenario1Test() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userName));
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getMensajesCuentaSuboptionButton().shouldBe(visible).shouldHave(exactText(mensajesButtonText)).click();
        assertTrue(url().endsWith(notificationsUrlEndWithText));
    }

    @Test
    public void preferenciasCuentaMenuSuboptionVerificationScenario2Test() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userName));
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getPreferenciasCuentaSuboptionButton().shouldBe(visible).
                shouldHave(exactText(preferenciasButtonText)).click();
        page.preferencesPage.getMiPerfilTab().shouldBe(visible).shouldHave(exactText(miPerfilTabText));
        assertTrue(url().endsWith(preferencesUrlEndWithText));
    }

    @Test
    public void salirCuentaMenuSuboptionVerificationScenario3Test() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userName));
        page.inicioPage.getAccountMenu().hover();
        page.inicioPage.getCuentaSuboptions().shouldBe(visible);
        page.inicioPage.getLogOutLinkElement().shouldBe(visible).
                shouldHave(exactText(salirButtonText)).click();
        page.loginPage.getLoginForm().shouldBe(visible);
        page.inicioPage.getUserName().shouldNotHave(text(userName));
    }

}
