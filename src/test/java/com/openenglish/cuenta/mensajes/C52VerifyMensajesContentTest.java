package com.openenglish.cuenta.mensajes;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.MensajesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_AVISO;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_ENVIADO_POR;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_FECHA_HORA;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_MENSAJES_BUTTON_TEXT;
import static com.openenglish.core.TestData.Mensajes.MENSAJES_SIN_LEER;

public class C52VerifyMensajesContentTest extends DriverBase {

    @Test
    public void verifyMensajesContentTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getUserName().shouldBe(visible, text(USER_NAME));
        ip.getUserPhoto().shouldBe(visible).isImage();
        ip.getAccountMenu().hover();
        ip.getMensajesCuentaSuboptionButton().click();

        MensajesPage mp = new MensajesPage();
        mp.getPageTitle().shouldBe(visible, exactText(MENSAJES_MENSAJES_BUTTON_TEXT));
        mp.getSinLeer().shouldBe(visible, text(MENSAJES_SIN_LEER));
        mp.getAvisos().shouldBe(visible);
        mp.getFechaHoraColumnTitle().shouldBe(visible, exactText(MENSAJES_FECHA_HORA));
        mp.getTableFirstRowFirstColumnDate().shouldBe(visible, not(empty));
        mp.getTableFirstRowFirstColumnTime().shouldBe(visible, not(empty));
        mp.getEnviadoPorColumnTitle().shouldBe(visible, exactText(MENSAJES_ENVIADO_POR));
        mp.getEnviadoPhoto().shouldBe(visible);
        mp.getEnviadoUserName().shouldBe(visible, not(empty));
        mp.getAvisoColumnTitle().shouldBe(visible, exactText(MENSAJES_AVISO));
        mp.getAvisoMessageTitle().shouldBe(visible, not(empty)).hover();
        mp.getTableFirstRowDeleteIcon().should(exist).hover().shouldBe(visible);
        mp.getTotalPagesAmount().shouldBe(visible, not(empty));
    }

}
