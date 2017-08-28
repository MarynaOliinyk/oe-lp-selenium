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
import static com.openenglish.core.Attribute.TYPE;
import static com.openenglish.core.AttributeValue.LoginPage.PASSWORD;
import static com.openenglish.core.TestData.General.LP_URL;
import static com.openenglish.core.TestData.Inicio.INICIO_LINK;
import static com.openenglish.core.TestData.Login.CORRECT_PASSWORD;
import static com.openenglish.core.TestData.Login.REGISTERED_EMAIL;
import static com.openenglish.core.TestData.Login.USER_NAME;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_FECHA_COLUMN;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_HEADER_TEXT;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_RESPUESTA_DEL_PROFESOR_COLUMN;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_SUGERENCIA_SOLICITADA_COLUMN;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_TEACHERS_NAME;
import static com.openenglish.core.TestData.TeacherFeedback.TEACHER_FEEDBACK_VER_EL_INDICE_DEL_CURSO_TEXT;


public class C86VerifySugerenciasDelProfesorContentTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void verifySugerenciasDelProfesorContentTest() {
        open(LP_URL);
        page.loginPage.cookieBannerVisibility();
        page.loginPage.getPassword().shouldBe(visible)
                .shouldHave(attribute(TYPE, PASSWORD));
        page.loginPage.logIn(REGISTERED_EMAIL, CORRECT_PASSWORD);
        page.inicioPage.getInicioLink().shouldHave(text(INICIO_LINK));
        page.inicioPage.getUserName().shouldHave(text(USER_NAME));
        page.inicioPage.getProgresoLink().click();
        page.inicioPage.getSugerenciasDelProfesorLink().click();
        TeacherFeedbackPage teacherFeedbackPage = new TeacherFeedbackPage();
        teacherFeedbackPage.getHeaderText().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_HEADER_TEXT + " " + USER_NAME));
        teacherFeedbackPage.getVerElIndiceDelCursoLink().shouldHave(text(TEACHER_FEEDBACK_VER_EL_INDICE_DEL_CURSO_TEXT));
        teacherFeedbackPage.getFechaColumn().shouldHave(text(TEACHER_FEEDBACK_FECHA_COLUMN));
        teacherFeedbackPage.getSugerenciaSolicitadaColumn().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_SUGERENCIA_SOLICITADA_COLUMN));
        teacherFeedbackPage.getRespuestaDelProfesorColumn().shouldBe(visible).shouldHave(text(TEACHER_FEEDBACK_RESPUESTA_DEL_PROFESOR_COLUMN));
        teacherFeedbackPage.getDayAndDateOfMessage().shouldBe(visible);
        teacherFeedbackPage.getTitleOfSentQuestion().shouldBe(exist);
        teacherFeedbackPage.getSubjectOfSentQuestion().shouldBe(exist);
        teacherFeedbackPage.getTeachersName().shouldHave(text(TEACHER_FEEDBACK_TEACHERS_NAME));
        teacherFeedbackPage.getTeachersMessage().shouldBe(exist);
        //TODO BUG QAA-211 https://openenglish.jira.com/browse/QAA-211
//        teacherFeedbackPage.getGoodRateFace().shouldBe(visible);
//        teacherFeedbackPage.getBadRateFace().shouldBe(visible);
    }
}
