package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AvisoTest extends TestBase {
    @Test
    public void avisoSectionTest() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getBanner().shouldBe(visible);
        loginPage.getContinueButton().click();
        loginPage.getBanner().shouldBe(not(visible));
        loginPage.getBannerTitle().click();
        loginPage.getBanner().shouldBe(visible);
    }
}
