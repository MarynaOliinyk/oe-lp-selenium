package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.Attributes.src;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Selenide.waitUntil;
import static org.testng.Assert.assertFalse;

public class C3302CheckThatUserCanLoadANewLessonWhenClickingTheReloadIconOnTheUpperRightCornerTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatUserCanLoadANewLessonWhenClickingTheReloadIconOnTheUpperRightCornerTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(registeredEmail, correctPassword);

        String firstImageUrlText = getLessonsVideoText();
        String firstImageTopic = getLessonsVideoTopicText();
        page.inicioPage.getReloadLessonsVideoButton().shouldBe(visible).click();
        page.inicioPage.getTopicLessonsVideo().waitUntil(not(matchesText(firstImageTopic)),  waitUntil);

        String secondImageUrlText = getLessonsVideoText();
        String secondImageTopic = getLessonsVideoTopicText();
        assertFalse(firstImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertFalse(firstImageTopic.toLowerCase().equals(secondImageTopic.toLowerCase()));
    }

    private String getLessonsVideoText(){
        return $(page.inicioPage.getAllTheLessonsVideoImgs()).shouldBe(visible).getAttribute(src);
    }

    private String getLessonsVideoTopicText(){
        return page.inicioPage.getTopicLessonsVideo().shouldBe(visible).getText();
    }

}
