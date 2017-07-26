package com.openenglish.menu;

import com.openenglish.core.TestBase;
import com.openenglish.pages.InicioPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class C98OpenEnglishLogoRedirectToInicioTest extends TestBase {

    @Test
    public void openEnglishLogoLinkTest() {
        positiveLogIn();
        InicioPage inicioPage = new InicioPage();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
        inicioPage.getProgresoLink().click();
        inicioPage.getOeLogo().shouldBe(visible).click();
        inicioPage.getInicioLink().shouldHave(text(inicioLink));
        inicioPage.getUserName().shouldHave(text(userNickName));
    }


}
