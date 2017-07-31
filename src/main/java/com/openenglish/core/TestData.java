package com.openenglish.core;

import static com.openenglish.util.PropertiesCache.getProperty;

public class TestData {

    public static class Selenide {
        public static final long timeout = Long.parseLong(getProperty("selenide.timeout")),
                waitUntil = Long.parseLong(getProperty("selenide.wait.until"));
    }

    public static class General {
        public static final String oeUrl = getProperty("base.oe.url"),
                                   lpUrl = getProperty("base.lp.url");
    }

    public static class Login {
        public static final String loginTooltipPassword = getProperty("login.tooltip.text.for.password"),
                loginTooltipSecurityCode = getProperty("login.tooltip.invalid.security.text"),
                invalidSecurityCode = getProperty("login.invalid.security.code"),
                popUpInvalidSecurityCode = getProperty("login.popup.invalid.security.code"),
                userName = getProperty("login.user.name"),
                registeredEmail = getProperty("login.correct.email"),
                correctPassword = getProperty("login.correct.password"),
                unregisteredEmail = getProperty("login.unregistered.email"),
                invalidPassword = getProperty("login.invalid.password"),
                securityPlaceHolderText = getProperty("login.security.placeholder");
    }

    public static class Recovery {
        public static final String emailWithoutATsymbol = getProperty("recovery.email.without@"),
                emailWithoutDotCom = getProperty("recovery.email.without.com"),
                notValidEmailText = getProperty("recovery.tooltip.not.valid.email"),
                recoveryTooltipEmail = getProperty("recovery.tooltip.text"),
                recoveryPasswordFormTitle = getProperty("recovery.password.form.title"),
                recoveryPasswordFaq = getProperty("recovery.password.faq"),
                recoveryPasswordSingUpText = getProperty("recovery.password.sing.up"),
                registrateText = getProperty("recovery.link.text");
    }

    public static class Register {
        public static final String notValidEmailTextForRegistration = getProperty("register.field.email.acceptense.message"),
                fieldShouldBeCompleted = getProperty("register.obligatory.field.message"),
                inCorrectValue = getProperty("register.incorrect.field.value.message"),
                lessThenEightyCharacters = getProperty("register.field.surname.lenth.acceptense.message"),
                lessThenFortyCharacters = getProperty("register.field.name.lenthg.acceptense.message"),
                charQuantityNombre = getProperty("register.char.quantity.name"),
                charQuantityAppelido = getProperty("register.char.quantity.surname"),
                numberLength = getProperty("register.number.length"),
                specialCharacters = getProperty("register.special.characters"),
                comienzaAhora = getProperty("register.comienza.ahora.button.text"),
                registrateText = getProperty("register.link.text"),
                firstName = getProperty("register.first.name"),
                lastName = getProperty("register.last.name"),
                mobileSectionOne = getProperty("register.mobile.section.one"),
                mobileSectionTwo = getProperty("register.mobile.section.two"),
                mobileSectionThree = getProperty("register.mobile.section.three"),
                age = getProperty("register.age"),
                thanksText = getProperty("register.thanks.text"),
                title = getProperty("register.title");
    }

    public static class FAQ {
        public static final String faqHeaderText = getProperty("faq.header.text");
    }

    public static class FAQS {
        public static final String faqsText = getProperty("faqs.text");
    }

    public static class Inicio {
        public static final String inicioLink = getProperty("inicio.link.text"),
                mensajesButtonText = getProperty("inicio.mensajes.link.text"),
                userNickName = getProperty("inicio.nick.user.name"),
                salirButtonText = getProperty("inicio.salir.link.text"),
                preferenciasButtonText = getProperty("inicio.preferencias.link.text");
    }

    public static class LiveClasses {
        public static final String liveClassesHeaderText = getProperty("liveclasses.header.text");
    }

    public static class Immersion {
        public static final String immersionHeaderText = getProperty("immersion.header.text");
    }

    public static class Introduction {
        public static final String introdussionHeaderText = getProperty("introduction.header.text");
    }

    public static class Lessons {
        public static final String lessonsText = getProperty("lessons.text");
    }

    public static class TalkNow {
        public static final String talkNowHeaderText = getProperty("talknow.header.text");
    }

    public static class TestYourSystem {
        public static final String testYourSystemHeaderText = getProperty("testyoursystem.header.text");
    }

    public static class ParticipantsGuidePage {
        public static final String containsPdfFile = getProperty("contains.pdf.file");
    }

    public static class Meeting {
        public static final String meetingTestText = getProperty("meeting.header.text");
    }

    public static class Notifications {
        public static final String notificationsUrlEndWithText = getProperty("notifications.page.url.endwith");
    }

    public static class Profile {
        public static final String profileHeaderText = getProperty("profile.header.text");
    }

    public static class TeacherFeedback {
        public static final String teacherFeedbackHeaderText = getProperty("teacherfeedback.header.text"),
                teacherFeedbackVerElIndiceDelCursoLink = getProperty("teacherfeedback.verelindice.del.curso.link"),
                teacherFeedbackFechaColumn = getProperty("teacherfeedback.fecha.column"),
                teacherFeedbackSugerenciaSolicitadaColumn = getProperty("teacherfeedback.sugerencia.solicitada.column"),
                teacherFeedbackRespuestaDelProfesorColumn = getProperty("teacherfeedback.respuesta.del.profesor.column"),
                teacherFeedbackTeachersName = getProperty("teacherfeedback.teachers.name");


    }

    public static class History {
        public static final String historyHeaderText = getProperty("history.header.text"),
                historyHeaderLinkText = getProperty("history.header.link.text"),
                historyTableHeaderFechaText = getProperty("history.table.header.fecha.text"),
                historyTableHeaderTipoText = getProperty("history.table.header.tipo.text"),
                historyTableHeaderTituloText = getProperty("history.table.header.titulo.text"),
                historyTableHeaderDescripcionText = getProperty("history.table.header.descripcion.text"),
                historyTableHeaderResultsText = getProperty("history.table.header.results.text"),
                historyUrlEndsWith = getProperty("history.url.endsWith");
    }

    public static class MyNotebook {
        public static final String myNotebookHeaderText = getProperty("mynotebook.header.text");
    }

    public static class Preferences {
        public static final String miPerfilTabText = getProperty("preferences.miperfil.tab.text"),
                preferencesUrlEndWithText = getProperty("preferences.page.url.endwith");
    }

    public static class TempMail {
        public static final String tempMailUrl = getProperty("temp.mail.url"),
                                   tempMailTitle = getProperty("temp.mail.title"),
                                   tempMailMessageTitle = getProperty("temp.mail.message.title");
        public static final long tempMailWait = Long.parseLong(getProperty("temp.mail.wait"));
    }
}
