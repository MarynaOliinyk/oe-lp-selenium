package com.openenglish.menu;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.HistoryPage;
import com.openenglish.pages.MyNotebookPage;
import com.openenglish.pages.ProfilePage;
import com.openenglish.pages.TeacherFeedbackPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.History.HISTORY_HEADER_TEXT;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.MyNotebook.MY_NOTEBOOK_HEADER_TEXT;
import static com.openenglish.core.TestData.Profile.PROFILE_HEADER_TEXT;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_HEADER_TEXT;

public class C100VerifyProgresoMenuLinksTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    private void loginWithCorrectCredentialsAndPageInicioIsOpen() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getProgresoLink().click();
    }

    @Test
    public void progressPageIsOpenedTestS1() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getMiProgressoLink().click();
        ProfilePage profilePage = new ProfilePage();
        profilePage.getHeaderText().should(visible, text(PROFILE_HEADER_TEXT));
    }

    @Test
    public void teacherFeedbackPageIsOpenedTestS2() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getSugerenciasDelProfesorLink().click();
        TeacherFeedbackPage teacherFeedbackPage = new TeacherFeedbackPage();
        teacherFeedbackPage.getHeaderText().shouldBe(visible, text(TEACHER_FEEDBACK_HEADER_TEXT + " " + USER_NAME));

    }

    @Test
    public void historyPageIsOpenedTestS3() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getRegistroLink().click();
        HistoryPage historyPage = new HistoryPage();
        historyPage.getHeaderRegistroDeActividadesText().shouldBe(visible, text(HISTORY_HEADER_TEXT + " " + USER_NAME));

    }

    @Test
    public void myNotebookPageIsOpenTestS4() {
        loginWithCorrectCredentialsAndPageInicioIsOpen();
        page.inicioPage.getCuadernoDeNotasLink().click();
        MyNotebookPage myNotebookPage = new MyNotebookPage();
        myNotebookPage.getHeaderText().shouldBe(visible, text(MY_NOTEBOOK_HEADER_TEXT + " " + USER_NAME));

    }
}


