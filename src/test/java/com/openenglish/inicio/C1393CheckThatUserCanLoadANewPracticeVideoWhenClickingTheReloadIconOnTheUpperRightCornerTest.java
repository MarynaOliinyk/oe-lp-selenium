package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Selenide.WAIT_UNTIL;
import static org.testng.Assert.assertFalse;

public class C1393CheckThatUserCanLoadANewPracticeVideoWhenClickingTheReloadIconOnTheUpperRightCornerTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatUserCanLoadANewPracticeVideoWhenClickingTheReloadIconOnTheUpperRightCornerTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        String firstImageUrlText = getPracticeVideoText();
        String firstImageTopic = getPracticeVideoTopicText();
        page.inicioPage.getReloadPracticeVideoButton().shouldBe(visible).click();
        page.inicioPage.getTopicPracticeVideo().waitUntil(not(matchesText(firstImageTopic)), WAIT_UNTIL);

        String secondImageUrlText = getPracticeVideoText();
        String secondImageTopic = getPracticeVideoTopicText();
        assertFalse(firstImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertFalse(firstImageTopic.toLowerCase().equals(secondImageTopic.toLowerCase()));
    }

    private String getPracticeVideoText(){
        return $(page.inicioPage.getAllThePracticeVideoImgs()).shouldBe(visible).getAttribute("src");
    }

    private String getPracticeVideoTopicText(){
        return page.inicioPage.getTopicPracticeVideo().shouldBe(visible).getText();
    }

}
