package com.openenglish.cuenta.mensajes;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.MensajesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.MENSAJES_BUTTON_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;

public class C52VerifyMensajesContentText extends DriverBase {

    @Test
    public void verifyMensajesContentTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAccountMenu().hover();
        ip.getMensajesCuentaSuboptionButton().click();

        MensajesPage mp= new MensajesPage();
        mp.getPageTitle().shouldBe(visible, exactText(MENSAJES_BUTTON_TEXT));
        mp.getTableFirstRowFirstColumn().click();
        mp.getPopupBlock().shouldBe(visible);
        mp.getPopupCloseButton().shouldBe(visible).click();
        mp.getPopupBlock().shouldNotBe(visible);
    }
}
