package com.openenglish.ayuda.contactenos;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.TalkNowPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.CLASS;
import static com.openenglish.core.Attribute.PLACEHOLDER;
import static com.openenglish.core.Attribute.Value.TalkNowPage.ORANGE_BTN;
import static com.openenglish.core.Attribute.Value.TalkNowPage.ORANGE_BTN_CLOSE;
import static com.openenglish.core.Attribute.Value.TalkNowPage.ORANGE_BTN_DISABLED;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Lessons.LESSONS_ALLERT_CERRAR_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_ALLERT_HEADER_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_ASK_TEACHER_SUBMIT_TEXT;
import static com.openenglish.core.TestData.Lessons.LESSONS_SOME_TEXT_FOR_TEST;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_ENVIAR_UNA_PREGUNTA_TEXT;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_PREGUNTE_A_UN_PROFESOR_TEXT;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_PREGUNTE_POPUP_INSTRUCTIONS_TEXT;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_PREGUNTE_POPUP_MESSAGE_PLACEHOLDER_TEXT;
import static com.openenglish.core.TestData.TalkNow.TALK_NOW_HEADER_TEXT;

public class C109VerifyEnviarUnaPreguntaContentTextTest extends DriverBase {

    @Test
    public void verifyEnviarUnaPreguntaContentTextTest() {
        open(LP_URL);
        LoginPage lp = new LoginPage();
        lp.cookieBannerVisibility();
        lp.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        InicioPage ip = new InicioPage();
        ip.getAyudaDropDown().hover();
        ip.getContactenos().click();

        TalkNowPage talkNowPage = new TalkNowPage();
        talkNowPage.getEnviarUnaPreguntaLink().shouldBe(visible, exactText(TALK_NOW_ENVIAR_UNA_PREGUNTA_TEXT)).click();
        talkNowPage.getPopupPreguntaTitle().shouldBe(visible, exactText(TALK_NOW_PREGUNTE_A_UN_PROFESOR_TEXT));
        talkNowPage.getPopupPreguntaInstructionsText().shouldBe(visible, exactText(TALK_NOW_PREGUNTE_POPUP_INSTRUCTIONS_TEXT));
        talkNowPage.getPopupPreguntaMessageBlock().shouldBe(visible, empty,
                attribute(PLACEHOLDER, TALK_NOW_PREGUNTE_POPUP_MESSAGE_PLACEHOLDER_TEXT));
        talkNowPage.getPopupPreguntaEnviarButton().shouldBe(visible, exactText(LESSONS_ASK_TEACHER_SUBMIT_TEXT),
                attribute(CLASS, ORANGE_BTN_DISABLED));
        talkNowPage.getPopupPreguntaMessageBlock().sendKeys(LESSONS_SOME_TEXT_FOR_TEST);
        talkNowPage.getPopupPreguntaEnviarButton().shouldBe(attribute(CLASS, ORANGE_BTN)).click();
        talkNowPage.getPopupGraciasTitle().shouldBe(visible, exactText(LESSONS_ALLERT_HEADER_TEXT));
        talkNowPage.getPopupGraciasMessageBlock().shouldBe(visible, exactText(TALK_NOW_PREGUNTE_POPUP_INSTRUCTIONS_TEXT));
        talkNowPage.getPopupGraciasCerrarButton().shouldBe(visible, exactText(LESSONS_ALLERT_CERRAR_TEXT),
                attribute(CLASS, ORANGE_BTN_CLOSE)).click();
        talkNowPage.getHeaderText().shouldHave(text(TALK_NOW_HEADER_TEXT));
    }

}
