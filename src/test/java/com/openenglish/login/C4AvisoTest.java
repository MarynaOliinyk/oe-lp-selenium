package com.openenglish.login;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;

public class C4AvisoTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void avisoSectionTest() {
        open(LP_URL);
        page.loginPage.getBanner().shouldBe(visible);
        page.loginPage.getContinueButton().click();
        page.loginPage.getBanner().shouldBe(not(visible));
        page.loginPage.getBannerTitle().click();
        page.loginPage.getBanner().shouldBe(visible);
    }
}
