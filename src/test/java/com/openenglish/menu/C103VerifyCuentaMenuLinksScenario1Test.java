package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.mensajesButtonText;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.Notifications.notificationsUrlEndWithText;
import static org.testng.Assert.assertTrue;

public class C103VerifyCuentaMenuLinksScenario1Test extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void mensajesCuentaMenuSuboptionVerificationTest() {
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(exactText(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAccountMenu().hover();
        inicioPage.getCuentaSuboptions().shouldBe(visible);
        inicioPage.getMensajesCuentaSuboptionButton().shouldBe(visible).shouldHave(exactText(mensajesButtonText)).click();
        assertTrue(url().endsWith(notificationsUrlEndWithText));
    }

}
