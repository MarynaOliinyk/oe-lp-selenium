package com.openenglish.core;

import static com.openenglish.util.PropertiesCache.getProperty;

public class TestData {

    public static class Selenide {
        public static final long TIMEOUT = Long.parseLong(getProperty("selenide.timeout")),
                WAIT_UNTIL = Long.parseLong(getProperty("selenide.wait.until"));
    }

    public static class General {
        public static final String OE_URL = getProperty("base.oe.url"),
                                   LP_URL = getProperty("base.lp.url");
    }

    public static class Login {
        public static final String LOGIN_TOOLTIP_PASSWORD = getProperty("login.tooltip.text.for.password"),
                LOGIN_TOOLTIP_SECURITY_CODE = getProperty("login.tooltip.invalid.security.text"),
                INVALID_SECURITY_CODE = getProperty("login.invalid.security.code"),
                POP_UP_INVALID_SECURITY_CODE = getProperty("login.popup.invalid.security.code"),
                USER_NAME = getProperty("login.user.name"),
                REGISTERED_EMAIL = getProperty("login.correct.email"),
                CORRECT_PASSWORD = getProperty("login.correct.password"),
                UNREGISTERED_EMAIL = getProperty("login.unregistered.email"),
                INVALID_PASSWORD = getProperty("login.invalid.password"),
                SECURITY_PLACE_HOLDER_TEXT = getProperty("login.security.placeholder"),
                PASSWORD_TEXT = getProperty("login.password.text");
    }

    public static class Recovery {
        public static final String EMAIL_WITHOUT_A_TSYMBOL = getProperty("recovery.email.without@"),
                EMAIL_WITHOUT_DOT_COM = getProperty("recovery.email.without.com"),
                NOT_VALID_EMAIL_TEXT = getProperty("recovery.tooltip.not.valid.email"),
                RECOVERY_TOOLTIP_EMAIL = getProperty("recovery.tooltip.text"),
                RECOVERY_PASSWORD_FORM_TITLE = getProperty("recovery.password.form.title"),
                RECOVERY_PASSWORD_FAQ = getProperty("recovery.password.faq"),
                RECOVERY_PASSWORD_SING_UP_TEXT = getProperty("recovery.password.sing.up"),
                REGISTRATE_TEXT = getProperty("recovery.link.text");
    }

    public static class Register {
        public static final String NOT_VALID_EMAIL_TEXT_FOR_REGISTRATION = getProperty("register.field.email.acceptense.message"),
                FIELD_SHOULD_BE_COMPLETED = getProperty("register.obligatory.field.message"),
                IN_CORRECT_VALUE = getProperty("register.incorrect.field.value.message"),
                LESS_THEN_EIGHTY_CHARACTERS = getProperty("register.field.surname.lenth.acceptense.message"),
                LESS_THEN_FORTY_CHARACTERS = getProperty("register.field.name.lenthg.acceptense.message"),
                CHAR_QUANTITY_NOMBRE = getProperty("register.char.quantity.name"),
                CHAR_QUANTITY_APPELIDO = getProperty("register.char.quantity.surname"),
                NUMBER_LENGTH = getProperty("register.number.length"),
                SPECIAL_CHARACTERS = getProperty("register.special.characters"),
                COMIENZA_AHORA = getProperty("register.comienza.ahora.button.text"),
                FIRST_NAME = getProperty("register.first.name"),
                LAST_NAME = getProperty("register.last.name"),
                MOBILE_SECTION_ONE = getProperty("register.mobile.section.one"),
                MOBILE_SECTION_TWO = getProperty("register.mobile.section.two"),
                MOBILE_SECTION_THREE = getProperty("register.mobile.section.three"),
                AGE = getProperty("register.age"),
                THANKS_TEXT = getProperty("register.thanks.text"),
                TITLE = getProperty("register.title");
    }

    public static class FAQ {
        public static final String FAQ_HEADER_TEXT = getProperty("faq.header.text");
    }

    public static class FAQS {
        public static final String FAQS_TEXT = getProperty("faqs.text");
    }

    public static class Inicio {
        public static final String INICIO_LINK = getProperty("inicio.link.text"),
                MENSAJES_BUTTON_TEXT = getProperty("inicio.mensajes.link.text"),
                USER_NICK_NAME = getProperty("inicio.nick.user.name"),
                SALIR_BUTTON_TEXT = getProperty("inicio.salir.link.text"),
                PREFERENCIAS_BUTTON_TEXT = getProperty("inicio.preferencias.link.text");
    }

    public static class LiveClasses {
        public static final String LIVE_CLASSES_HEADER_TEXT = getProperty("liveclasses.header.text");
    }

    public static class Immersion {
        public static final String IMMERSION_HEADER_TEXT = getProperty("immersion.header.text");
    }

    public static class Introduction {
        public static final String INTRODUSSION_HEADER_TEXT = getProperty("introduction.header.text");
    }

    public static class Lessons {
        public static final String LESSONS_TEXT = getProperty("lessons.text");
    }

    public static class TalkNow {
        public static final String TALK_NOW_HEADER_TEXT = getProperty("talknow.header.text");
    }

    public static class TestYourSystem {
        public static final String TEST_YOUR_SYSTEM_HEADER_TEXT = getProperty("testyoursystem.header.text");
    }

    public static class ParticipantsGuidePage {
        public static final String CONTAINS_PDF_FILE = getProperty("contains.pdf.file");
    }

    public static class Meeting {
        public static final String MEETING_TEST_TEXT = getProperty("meeting.header.text");
    }

    public static class Notifications {
        public static final String NOTIFICATIONS_URL_END_WITH_TEXT = getProperty("notifications.page.url.endwith");
    }

    public static class Profile {
        public static final String PROFILE_HEADER_TEXT = getProperty("profile.header.text");
    }

    public static class TeacherFeedback {
        public static final String TEACHER_FEEDBACK_HEADER_TEXT = getProperty("teacherfeedback.header.text"),
                TEACHER_FEEDBACK_VER_EL_INDICE_DEL_CURSO_LINK = getProperty("teacherfeedback.verelindice.del.curso.link"),
                TEACHER_FEEDBACK_FECHA_COLUMN = getProperty("teacherfeedback.fecha.column"),
                TEACHER_FEEDBACK_SUGERENCIA_SOLICITADA_COLUMN = getProperty("teacherfeedback.sugerencia.solicitada.column"),
                TEACHER_FEEDBACK_RESPUESTA_DEL_PROFESOR_COLUMN = getProperty("teacherfeedback.respuesta.del.profesor.column"),
                TEACHER_FEEDBACK_TEACHERS_NAME = getProperty("teacherfeedback.teachers.name");


    }

    public static class History {
        public static final String HISTORY_HEADER_TEXT = getProperty("history.header.text");
    }

    public static class MyNotebook {
        public static final String MY_NOTEBOOK_HEADER_TEXT = getProperty("mynotebook.header.text");
    }

    public static class Preferences {
        public static final String MI_PERFIL_TAB_TEXT = getProperty("preferences.miperfil.tab.text"),
                PREFERENCES_URL_END_WITH_TEXT = getProperty("preferences.page.url.endwith");
    }

    public static class TempMail {
        public static final String TEMP_MAIL_URL = getProperty("temp.mail.url"),
                                   TEMP_MAIL_TITLE = getProperty("temp.mail.title"),
                                   TEMP_MAIL_MESSAGE_TITLE = getProperty("temp.mail.message.title");
        public static final long TEMP_MAIL_WAIT = Long.parseLong(getProperty("temp.mail.wait"));
    }
}
