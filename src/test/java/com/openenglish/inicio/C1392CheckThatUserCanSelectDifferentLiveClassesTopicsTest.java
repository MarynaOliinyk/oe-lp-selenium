package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.Attribute.SRC;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Selenide.WAIT_UNTIL;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class C1392CheckThatUserCanSelectDifferentLiveClassesTopicsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatThePracticeAndLessonsIconsAreLoadedTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        String firstImageUrlText = getLiveClassVideoText();
        String firstImageTopic = getLiveClassVideoTopicText();
        assertTrue(page.inicioPage.stringsComparator(firstImageUrlText, firstImageTopic));
        page.inicioPage.getGreaterThenSign().shouldBe(visible).click();
        page.inicioPage.getTopicLiveClassVideo().waitUntil(not(matchesText(firstImageTopic)), WAIT_UNTIL);

        String secondImageUrlText = getLiveClassVideoText();
        String secondImageTopic = getLiveClassVideoTopicText();
        assertFalse(firstImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertFalse(firstImageTopic.toLowerCase().equals(secondImageTopic.toLowerCase()));
        assertTrue(page.inicioPage.stringsComparator(secondImageUrlText, secondImageTopic));
        page.inicioPage.getLessThenSign().shouldBe(visible).click();
        page.inicioPage.getTopicLiveClassVideo().waitUntil(not(matchesText(secondImageTopic)), WAIT_UNTIL);

        String thirdImageUrlText = getLiveClassVideoText();
        String thirdImageTopic = getLiveClassVideoTopicText();
        assertFalse(thirdImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertTrue(firstImageUrlText.toLowerCase().equals(thirdImageUrlText.toLowerCase()));
        assertTrue(page.inicioPage.stringsComparator(thirdImageUrlText, thirdImageTopic));
    }

    private String getLiveClassVideoText() {
        return $(page.inicioPage.getAllTheLiveClassesVideoImgs()).getAttribute(SRC);
    }

    private String getLiveClassVideoTopicText() {
        return page.inicioPage.getTopicLiveClassVideo().getText();
    }
}