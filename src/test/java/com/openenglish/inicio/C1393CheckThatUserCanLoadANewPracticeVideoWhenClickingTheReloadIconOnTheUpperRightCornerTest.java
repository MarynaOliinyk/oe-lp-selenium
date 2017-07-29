package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.Attributes.src;
import static com.openenglish.core.TestData.Attributes.type;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.waitForThreeSec;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.passwordText;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class C1393CheckThatUserCanLoadANewPracticeVideoWhenClickingTheReloadIconOnTheUpperRightCornerTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatUserCanLoadANewPracticeVideoWhenClickingTheReloadIconOnTheUpperRightCornerTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute(type, passwordText));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText(inicioLink));
//        page.inicioPage.getUserName().shouldBe(visible).shouldNotBe(empty)
//                .shouldHave(text(userName));







        String firstImageUrlText = getLiveClassVideoText();
        String firstImageTopic = getLiveClassVideoTopicText();
        assertTrue(page.inicioPage.stringsComparator(firstImageUrlText, firstImageTopic));
        page.inicioPage.getGreaterThenSign().shouldBe(visible).click();
        page.inicioPage.getTopicLiveClassVideo().waitUntil(not(matchesText(firstImageTopic)),  Integer.parseInt(waitForThreeSec));

        String secondImageUrlText = getLiveClassVideoText();
        String secondImageTopic = getLiveClassVideoTopicText();
        assertFalse(firstImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertFalse(firstImageTopic.toLowerCase().equals(secondImageTopic.toLowerCase()));
        assertTrue(page.inicioPage.stringsComparator(secondImageUrlText, secondImageTopic));
        page.inicioPage.getLessThenSign().shouldBe(visible).click();
        page.inicioPage.getTopicLiveClassVideo().waitUntil(not(matchesText(secondImageTopic)),  Integer.parseInt(waitForThreeSec));

        String thirdImageUrlText = getLiveClassVideoText();
        String thirdImageTopic = getLiveClassVideoTopicText();
        assertFalse(thirdImageUrlText.toLowerCase().equals(secondImageUrlText.toLowerCase()));
        assertTrue(firstImageUrlText.toLowerCase().equals(thirdImageUrlText.toLowerCase()));
        assertTrue(page.inicioPage.stringsComparator(thirdImageUrlText, thirdImageTopic));
    }

    private String getLiveClassVideoText(){
        return $(page.inicioPage.getAllTheLiveClassesVideoImgs()).getAttribute(src);
    }

    private String getLiveClassVideoTopicText(){
        return page.inicioPage.getTopicLiveClassVideo().getText();
    }



}
