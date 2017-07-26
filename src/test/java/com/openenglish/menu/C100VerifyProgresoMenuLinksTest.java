package com.openenglish.menu;

import com.openenglish.core.TestBase;
import com.openenglish.pages.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C100VerifyProgresoMenuLinksTest extends TestBase {
    @BeforeMethod
    public void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        loginPage.cookieBannerVisibility();
        loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        loginPage.logIn(email, correctPassword);
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userName));
        inicioPage.getProgresoLink().click();
    }

    @Test
    public void progressPageIsOpenedTestS1() {
        inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible).shouldHave(text(profileHeaderText));
    }
}
