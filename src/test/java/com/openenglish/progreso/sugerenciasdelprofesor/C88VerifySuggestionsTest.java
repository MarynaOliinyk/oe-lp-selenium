package com.openenglish.progreso.sugerenciasdelprofesor;


import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TeacherFeedbackPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackHeaderText;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackTeachersName;
import static com.openenglish.core.TestData.TeacherFeedback.teacherfeedbackPopUpHeaderText;
import static com.openenglish.core.TestData.TeacherFeedback.teacherfeedbackPopUpHeaderTextAfterSad;
import static com.openenglish.core.TestData.TeacherFeedback.teacherfeedbackPopUpMessage;
import static org.testng.Assert.assertTrue;

public class C88VerifySuggestionsTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifySuggestionsTest() {
        open(lpUrl);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                      .shouldHave(attribute("type", "password"));
        page.loginPage.logIn(registeredEmail, correctPassword);
        page.inicioPage.getInicioLink().shouldHave(text(inicioLink));
        //TODO BUG NSB-65  https://openenglish.jira.com/browse/NSB-65
//        page.inicioPage.getUserName().shouldHave(text(userNickName));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getSugerenciasDelProfesorLink().click();
        TeacherFeedbackPage teacherFeedbackPage = new TeacherFeedbackPage();
        teacherFeedbackPage.getHeaderText().shouldBe(visible).shouldHave(text(teacherFeedbackHeaderText + " " + userName));
        teacherFeedbackPage.getSuggestionLink().shouldBe(visible).click();
        assertTrue(teacherFeedbackPage.getPopUp().isDisplayed());
        teacherFeedbackPage.getPopUpHeaderText().shouldBe(visible).shouldHave(text(teacherfeedbackPopUpHeaderText));
        teacherFeedbackPage.getPopUpImage().shouldBe(visible);
        teacherFeedbackPage.getTeachersName().shouldBe(visible).shouldHave(text(teacherFeedbackTeachersName));
        teacherFeedbackPage.getTeachersResponseText().shouldBe(visible);
        teacherFeedbackPage.getClosePopUp().shouldBe(visible).click();
        teacherFeedbackPage.getGoodRateFace().shouldBe(visible).click();
        teacherFeedbackPage.getGoodRateFace().shouldHave(attribute("class", "happy no-rated"));
        teacherFeedbackPage.getBadRateFace().shouldBe(visible).click();
        teacherFeedbackPage.getPopUpAfterSadFace().shouldBe(visible);
        teacherFeedbackPage.getPopUpHeaderTextAfterSadFace().shouldBe(visible).shouldHave(text(teacherfeedbackPopUpHeaderTextAfterSad));
        teacherFeedbackPage.getEnviarButtonOnPopUpIsDisabled().shouldHave(attribute("class", "orange-btn submit-btn disabled"));
        teacherFeedbackPage.getCheckboxOnPopUp().shouldBe(visible).click();
        teacherFeedbackPage.getEnviarButtonOnPopUpVisible().shouldBe(visible).click();
        teacherFeedbackPage.getMessageOnPopUpSaveSuccsess().shouldBe(visible).shouldHave(text(teacherfeedbackPopUpMessage));
        teacherFeedbackPage.getExitButtonOnPopUp().shouldBe(visible).click();
        teacherFeedbackPage.getSuggestionLink().shouldBe(visible);
        teacherFeedbackPage.getGoodRateFace().shouldHave(attribute("class", "happy no-rated"));

    }
}
