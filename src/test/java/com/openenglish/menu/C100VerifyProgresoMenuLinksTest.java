package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HistoryPage;
import com.openenglish.pages.MyNotebookPage;
import com.openenglish.pages.ProfilePage;
import com.openenglish.pages.TeacherFeedbackPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.History.historyHeaderText;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Inicio.userNickName;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.MyNotebook.myNotebookHeaderText;
import static com.openenglish.core.TestData.Profile.profileHeaderText;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackHeaderText;

public class C100VerifyProgresoMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();


    private void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        page.inicioPage.getUserName().shouldHave(text(userNickName));
        page.inicioPage.getProgresoLink().click();
    }

    @Test
    public void progressPageIsOpenedTestS1() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible).shouldHave(text(profileHeaderText));
    }

    @Test
    public void teacherFeedbackPageIsOpenedTestS2() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getSugerenciasDelProfesorLink().click();
        TeacherFeedbackPage teacherFeedbackPage = new TeacherFeedbackPage();
        teacherFeedbackPage.getHeaderText().shouldBe(visible).shouldHave(text(teacherFeedbackHeaderText + " " + userName));

    }

    @Test
    public void historyPageIsOpenedTestS3() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getRegistroLink().click();
        HistoryPage historyPage = new HistoryPage();
        historyPage.getHeaderBlock().shouldBe(visible).shouldHave(text(historyHeaderText + " " + userName));

    }

    @Test
    public void myNotebookPageIsOpenTestS4() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().shouldBe(visible).shouldHave(text(myNotebookHeaderText + " " + userName));

    }
}


