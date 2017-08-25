package com.openenglish.progreso.sugerenciasdelprofesor;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TeacherFeedbackPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_HEADER_TEXT;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_POP_UP_HEADER_TEXT;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_POP_UP_HEADER_TEXT_AFTER_SAD;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_POP_UP_MESSAGE;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_TEACHERS_NAME;
import static org.testng.Assert.assertTrue;

public class C88VerifySuggestionsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test(enabled = false)
    public void verifySuggestionsTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserName().shouldHave(text(USER_NAME));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getSugerenciasDelProfesorLink().click();
        TeacherFeedbackPage teacherFeedbackPage = new TeacherFeedbackPage();
        teacherFeedbackPage.getHeaderText().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_HEADER_TEXT + " " + USER_NAME));
        teacherFeedbackPage.getSuggestionLink().shouldBe(visible).click();
        assertTrue(teacherFeedbackPage.getPopUp().isDisplayed());
        teacherFeedbackPage.getPopUpHeaderText().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_POP_UP_HEADER_TEXT));
        teacherFeedbackPage.getPopUpImage().shouldBe(visible);
        teacherFeedbackPage.getTeachersName().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_TEACHERS_NAME));
        teacherFeedbackPage.getTeachersResponseText().shouldBe(visible);
        teacherFeedbackPage.getClosePopUp().shouldBe(visible).click();
        //TODO BUG QAA-211 https://openenglish.jira.com/browse/QAA-211
        teacherFeedbackPage.getGoodRateFace().shouldBe(visible).click();
        teacherFeedbackPage.getGoodRateFace().shouldHave(attribute("class", "happy no-rated"));
        teacherFeedbackPage.getBadRateFace().shouldBe(visible).click();
        teacherFeedbackPage.getPopUpAfterSadFace().shouldBe(visible);
        teacherFeedbackPage.getPopUpHeaderTextAfterSadFace().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_POP_UP_HEADER_TEXT_AFTER_SAD));
        teacherFeedbackPage.getEnviarButtonOnPopUpIsDisabled().shouldHave(attribute("class", "orange-btn submit-btn disabled"));
        teacherFeedbackPage.getCheckboxOnPopUp().shouldBe(visible).click();
        teacherFeedbackPage.getEnviarButtonOnPopUpVisible().shouldBe(visible).click();
        teacherFeedbackPage.getMessageOnPopUpSaveSuccsess().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_POP_UP_MESSAGE));
        teacherFeedbackPage.getExitButtonOnPopUp().shouldBe(visible).click();
        teacherFeedbackPage.getSuggestionLink().shouldBe(visible);
        teacherFeedbackPage.getGoodRateFace().shouldHave(attribute("class", "happy no-rated"));

    }
}
