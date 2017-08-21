package com.openenglish.ayuda.contactenos;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.TalkNowPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_HEADER_TEXT;

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
        tNP.getHeaderText().shouldHave(visible, exactText(TALK_NOW_HEADER_TEXT));
        tNP.getAsesorImg().click();
        tNP.getProfesorImg().click();
    }

}
