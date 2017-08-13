package com.openenglish.curso.unidadesylecciones;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.LessonsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Lessons.BEGIN_LESSON_BUTTON;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.pages.AbstractPage.openInNewTab;

public class C113VerifyEndLessonNotificationTest extends DriverBase {

    private AbstractPage page = new AbstractPage();
    private LessonsPage lessonsPage = new LessonsPage();

    @Test
    public void lessonAreaSectionTest() throws InterruptedException {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getCursoButton().click();
        page.inicioPage.getUnidadesYLeccionesButton().click();
        
        switchTo().frame(lessonsPage.getLessonIFrame());
        lessonsPage.getBeginLessonButton().shouldBe(visible, text(BEGIN_LESSON_BUTTON)).click();
        Thread.sleep(3000);
        openInNewTab("TCAPI.rate(5)");
//        $("#lst-ib").val("qwertyuiop");
//        $("#lst-ib").sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, "j"));
//        $("#lst-ib").sendKeys(Keys.valueOf("TCAPI.rate(5)"));
//        $("#lst-ib").sendKeys(Keys.ENTER);

        page.inicioPage.getUnidadesYLeccionesButton().click();

    }
}