package com.openenglish.progreso.sugerenciasdelprofesor;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.TeacherFeedbackPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Inicio.inicioLink;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Login.userName;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackFechaColumn;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackHeaderText;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackRespuestaDelProfesorColumn;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackSugerenciaSolicitadaColumn;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackTeachersName;
import static com.openenglish.core.TestData.TeacherFeedback.teacherFeedbackVerElIndiceDelCursoLink;


public class C86VerifySugerenciasDelProfesorContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void VerifySugerenciasDelProfesorContentTest() {
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
        teacherFeedbackPage.getVerElIndiceDelCursoLink().shouldHave(text(teacherFeedbackVerElIndiceDelCursoLink));
        teacherFeedbackPage.getFechaColumn().shouldHave(text(teacherFeedbackFechaColumn));
        teacherFeedbackPage.getSugerenciaSolicitadaColumn().shouldBe(visible).shouldHave(text(teacherFeedbackSugerenciaSolicitadaColumn));
        teacherFeedbackPage.getRespuestaDelProfesorColumn().shouldBe(visible).shouldHave(text(teacherFeedbackRespuestaDelProfesorColumn));
        teacherFeedbackPage.getDayAndDateOfMessage().shouldBe(visible);
        teacherFeedbackPage.getTitleOfSentQuestion().shouldBe(exist);
        teacherFeedbackPage.getSubjectOfSentQuestion().shouldBe(exist);
        teacherFeedbackPage.getTeachersName().shouldHave(text(teacherFeedbackTeachersName));
        teacherFeedbackPage.getTeachersMessage().shouldBe(exist);
        teacherFeedbackPage.getGoodRateFace().shouldBe(visible);
        teacherFeedbackPage.getBadRateFace().shouldBe(visible);

    }

}
