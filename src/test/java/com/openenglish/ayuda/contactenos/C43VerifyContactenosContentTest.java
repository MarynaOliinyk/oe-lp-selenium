package com.openenglish.ayuda.contactenos;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TalkNowPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_ASESOR_TEXT;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_HEADER_TEXT;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_PROFESOR_TEXT;

public class C43VerifyContactenosContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyContactenosContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        page.inicioPage.getAyudaDropDown().hover();
        page.inicioPage.getContactenos().click();

        TalkNowPage talkNowPage = new TalkNowPage();
        talkNowPage.getHeaderText().shouldHave(visible, exactText(TALK_NOW_HEADER_TEXT));
        talkNowPage.getAsesorText().shouldHave(visible, exactText(TALK_NOW_ASESOR_TEXT));
        talkNowPage.getAsesorImg().shouldBe(visible);
        talkNowPage.getProfesorText().shouldHave(visible, exactText(TALK_NOW_PROFESOR_TEXT));
        talkNowPage.getProfesorImg().shouldBe(visible);
    }
}
