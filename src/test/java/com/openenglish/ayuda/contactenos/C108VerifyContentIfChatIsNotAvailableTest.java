package com.openenglish.ayuda.contactenos;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.TalkNowPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.TalkNow.ENVIAR_UNA_PREGUNTA_TEXT;
import static com.openenglish.core.TestData.TalkNow.LIVEAGENT_OFFLINE_TEXT;
import static com.openenglish.core.TestData.TalkNow.LIVEAGENT_ONLINE_TEXT;
import static com.openenglish.core.TestData.TalkNow.LIVEAGENT_PHONE;

public class C108VerifyContentIfChatIsNotAvailableTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyContactenosContentTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        InicioPage ip = new InicioPage();
        ip.getAyudaDropDown().hover();
        ip.getContactenos().click();

        TalkNowPage tNP = new TalkNowPage();
        tNP.getAsesorImg().click();
        tNP.getProfesorImg().click();
        // TODO find out if it possible to automate chat turn off
//        tNP.getLiveagentOfflineButton().shouldBe(visible, exactText(LIVEAGENT_OFFLINE_TEXT));
        tNP.getLiveagentOnlineButton().shouldBe(visible, exactText(LIVEAGENT_ONLINE_TEXT));
        tNP.getLiveagentPhoneNumber().shouldBe(visible, text(LIVEAGENT_PHONE));
        tNP.getEnviarUnaPreguntaLink().shouldBe(visible, exactText(ENVIAR_UNA_PREGUNTA_TEXT));
    }

}
