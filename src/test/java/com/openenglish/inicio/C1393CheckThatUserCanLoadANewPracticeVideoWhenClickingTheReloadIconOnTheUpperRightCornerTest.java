package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Selenide.waitUntil;
import static org.testng.Assert.assertFalse;

public class C1393CheckThatUserCanLoadANewPracticeVideoWhenClickingTheReloadIconOnTheUpperRightCornerTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatUserCanLoadANewPracticeVideoWhenClickingTheReloadIconOnTheUpperRightCornerTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(registeredEmail, correctPassword);

        String firstImageUrlText = getPracticeVideoText();
        String firstImageTopic = getPracticeVideoTopicText();
        page.inicioPage.getReloadPracticeVideoButton().shouldBe(visible).click();
        page.inicioPage.getTopicPracticeVideo().waitUntil(not(matchesText(firstImageTopic)),  waitUntil);

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
