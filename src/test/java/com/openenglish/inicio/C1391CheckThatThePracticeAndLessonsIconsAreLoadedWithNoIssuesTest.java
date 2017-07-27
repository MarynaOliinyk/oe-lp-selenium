package com.openenglish.inicio;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;

public class C1391CheckThatThePracticeAndLessonsIconsAreLoadedWithNoIssuesTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void checkThatThePracticeAndLessonsIconsAreLoadedTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(exactText(inicioLink));
        page.inicioPage.getUserName().shouldBe(visible).shouldNotBe(empty)
                .shouldHave(text(userName));
    }

}
