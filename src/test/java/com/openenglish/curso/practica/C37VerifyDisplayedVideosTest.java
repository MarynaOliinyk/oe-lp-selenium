package com.openenglish.curso.practica;

import com.codeborne.selenide.SelenideElement;
import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.ImmersionPage;
import com.openenglish.pages.VideoPopUpPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Immersion.IMMERSION_HEADER_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Selenide.WAIT_UNTIL;

public class C37VerifyDisplayedVideosTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifyDisplayedVideosTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getPracticaLink().click();

        ImmersionPage immersionPage = new ImmersionPage();
        immersionPage.getHeaderText().shouldBe(visible, text(IMMERSION_HEADER_TEXT));

        List<SelenideElement> videoBlocksList = immersionPage.getAllTheDisplayedVideoBlocks();
        videoBlocksList.forEach(element -> element.shouldBe(exist, visible, not(empty)));

        List<SelenideElement> videoBlocksTitlesList = immersionPage.getAllTheDisplayedVideoTitles();
        videoBlocksTitlesList.forEach(element -> element.shouldBe(exist, visible, not(empty)));

        List<SelenideElement> videoBlocksDescriptionsList = immersionPage.getAllTheDisplayedVideoDescriptions();
        videoBlocksDescriptionsList.forEach(element -> element.shouldBe(exist, visible, not(empty)));

        immersionPage.getVideoWithComenzarText().scrollTo().hover().click();

        VideoPopUpPage videoPopUp = new VideoPopUpPage();
        switchTo().frame(videoPopUp.getVideoIframe());
        videoPopUp.getVideoWindow().hover();
        videoPopUp.getPausaButton().waitUntil(visible, WAIT_UNTIL).click();
        videoPopUp.getReproducirButton().waitUntil(visible, WAIT_UNTIL);
    }
}
