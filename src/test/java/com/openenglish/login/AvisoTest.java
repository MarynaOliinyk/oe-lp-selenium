package com.openenglish.login;

import com.openenglish.core.TestBase;
import com.openenglish.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class AvisoTest extends TestBase {

    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");

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
