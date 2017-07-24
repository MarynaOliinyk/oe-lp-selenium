package com.openenglish.menu;


import com.openenglish.core.TestBase;
import com.openenglish.pages.TalkNowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C102VerifyAyudaMenuLinksTest extends TestBase {

    @BeforeMethod
    public void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                 .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getAyudaDropDown().hover();
    }


    @Test
    public void verifyContactenosTestS1() {
        inicioPage.getContactenos().click();
        TalkNowPage talkNowPage = new TalkNowPage();
        talkNowPage.getHeaderText().shouldHave(text(talkNowHeaderText));

    }
}
