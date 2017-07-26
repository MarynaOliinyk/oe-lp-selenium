package com.openenglish.menu;

import com.openenglish.core.TestBase;
import com.openenglish.pages.ProfilePage;
import com.openenglish.pages.TeacherFeedbackPage;
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
        inicioPage.getUserName().shouldHave(text(userNickName));
        inicioPage.getProgresoLink().click();
    }

    @Test
    public void progressPageIsOpenedTestS1() {
        inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible).shouldHave(text(profileHeaderText));
    }

    @Test
    public  void  teacherFeedbackPageTestS2() {
        inicioPage.getSugerenciasDelProfesorLink().click();
        TeacherFeedbackPage teacherFeedbackPage = new TeacherFeedbackPage();
        teacherFeedbackPage.getSugerenciasParaUserHeaderText().shouldBe(visible).shouldHave(text(teacherFeedbackHeaderText+" "+userName));

    }

}
