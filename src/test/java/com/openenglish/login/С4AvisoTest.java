package com.openenglish.login;

import com.openenglish.core.TestBase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;

public class С4AvisoTest extends TestBase {
    @Test
    public void avisoSectionTest() {
        loginPage.getBanner().shouldBe(visible);
        loginPage.getContinueButton().click();
        loginPage.getBanner().shouldBe(not(visible));
        loginPage.getBannerTitle().click();
        loginPage.getBanner().shouldBe(visible);
    }
}
