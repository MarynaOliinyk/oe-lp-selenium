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

public class C3302CheckThatUserCanLoadANewLessonWhenClickingTheReloadIconOnTheUpperRightCornerTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatUserCanLoadANewLessonWhenClickingTheReloadIconOnTheUpperRightCornerTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);

        String firstImageUrlText = getLessonsVideoText();
        String firstImageTopic = getLessonsVideoTopicText();
        page.inicioPage.getReloadLessonsVideoButton().shouldBe(visible).click();
        page.inicioPage.getTopicLessonsVideo().waitUntil(not(matchesText(firstImageTopic)), WAIT_UNTIL);

        String secondImageUrlText = getLessonsVideoText();
        String secondImageTopic = getLessonsVideoTopicText();
        assertFalse(firstImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertFalse(firstImageTopic.toLowerCase().equals(secondImageTopic.toLowerCase()));
    }

    private String getLessonsVideoText(){
        return $(page.inicioPage.getAllTheLessonsVideoImgs()).shouldBe(visible).getAttribute("src");
    }

    private String getLessonsVideoTopicText(){
        return page.inicioPage.getTopicLessonsVideo().shouldBe(visible).getText();
    }

}
