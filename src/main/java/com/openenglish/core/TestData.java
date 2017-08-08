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
                USER_NAME_WITH_NOTES = getProperty("login.user.name.without.notes"),
                EMAIL_WITH_NOTES = getProperty("login.correct.email.without.notes"),
                PASSWORD_WITH_NOTES = getProperty("login.correct.password.without.notes");
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
                COUNTRY = getProperty("register.country"),
                MOBILE_SECTION_ONE = getProperty("register.mobile.section.one"),
                MOBILE_SECTION_TWO = getProperty("register.mobile.section.two"),
                MOBILE_SECTION_THREE = getProperty("register.mobile.section.three"),
                AGE = getProperty("register.age"),
                THANKS_POPUP_TEXT = getProperty("register.thanks.popup.text"),
                TITLE = getProperty("register.title"),
                WARNING_MESSAGE = getProperty("register.warning.message");
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
                USER_NICK_NAME_WITH_NOTES = getProperty("inicio.nick.user.name.without.notes"),
                PREFERENCIAS_BUTTON_TEXT = getProperty("inicio.preferencias.link.text");
    }

    public static class LiveClasses {
        public static final String LIVE_CLASSES_HEADER_TEXT = getProperty("liveclasses.header.text"),
                LIVE_CLASSES_DROP_BLOCK_MESSAGE = getProperty("liveclasses.dropblock.message"),
                LIVE_CLASSES_DROP_BLOCK_HEADER_TEXT = getProperty("liveclasses.dropblock.header.text"),
                LIVE_CLASSES_DROP_BLOCK_LESSON_LINK = getProperty("liveclasses.dropblock.lesson.link"),
                LIVE_CLASSES_DROP_BLOCK_IMMERSION_LINK = getProperty("liveclasses.dropblock.immersionlink"),
                LIVE_CLASSES_TITLE_TEXT = getProperty("liveclasses.title.text"),
                LIVE_CLASSES_CONTENT_TEXT = getProperty("liveclasses.content.text");

    }

    public static class Immersion {
        public static final String IMMERSION_HEADER_TEXT = getProperty("immersion.header.text");
    }

    public static class Introduction {
        public static final String INTRODUSSION_HEADER_TEXT = getProperty("introduction.header.text");
    }

    public static class Lessons {
        public static final String LESSONS_TEXT = getProperty("lessons.text"),
                REMINDER_TITLE = getProperty("lessons.reminder.title.text"),
                REMINDER_BODY = getProperty("lessons.reminder.body.text"),
                REMINDER_LESSONS_LINK = getProperty("lessons.reminder.lessons.link.text"),
                REMINDER_PRACTICA_LINK = getProperty("lessons.reminder.practica.link.text"),
                REMINDER_LIVECLASSES_LINK = getProperty("lessons.reminder.liveclasses.link.text"),
                BEGIN_LESSON_BUTTON = getProperty("lessons.reminder.begin.button.text"),
                MENU_TITLE_TEXT = getProperty("lessons.menu.title.text"),
                MENU_PROGRESS_TEXT = getProperty("lessons.menu.progress.text"),
                MENU_LINKBOX_TEXT = getProperty("lessons.menu.dropdown.text");
    }

    public static class TalkNow {
        public static final String TALK_NOW_HEADER_TEXT = getProperty("talknow.header.text");
    }

    public static class TestYourSystem {
        public static final String TEST_YOUR_SYSTEM_HEADER_TEXT = getProperty("testyoursystem.header.text");
    }

    public static class ParticipantsGuide {
        public static final String CONTAINS_PDF_FILE = getProperty("contains.pdf.file");
    }

    public static class Meeting {
        public static final String MEETING_TEST_TEXT = getProperty("meeting.header.text");
    }

    public static class Notifications {
        public static final String NOTIFICATIONS_URL_END_WITH_TEXT = getProperty("notifications.page.url.endwith");
    }

    public static class Profile {
        public static final String PROFILE_HEADER_TEXT = getProperty("profile.header.text"),
                PROFILE_VER_EL_INDICE_DEL_CURSO_LINK = getProperty("profile.verelindice.del.curso.link"),
                PROFILE_VER_EL_INDICE_DEL_CURSO_TEXT = getProperty("profile.verelindice.del.curso.text"),
                PROFILE_LESSONS_HEADER_TEXT = getProperty("profile.lessons.header.text"),
                PROFILE_TOMAR_PRUEBA_DE_NIVEL_BUTTON = getProperty("profile.tomar.prueba.de.nivel.button.text"),
                PROFILE_ESTADISTICAS_HEADER_TEXT = getProperty("profile.estadisticas.header.text"),
                PROFILE_NIVEL_ACTUAL_COLUMN = getProperty("profile.nivel.actual.column"),
                PROFILE_ULTIMO_NIVEL_COMPLETADO_COLUMN = getProperty("profile.ultimo.nivel.completado.column"),
                PROFILE_PRUEBA_DE_NIVEL_COLUMN = getProperty("profile.prueba.de.nivel.column"),
                PROFILE_ULTIMO_INGRESO_COLUMN = getProperty("profile.ultimo.ingreso.column"),
                PROFILE_PRUEBA_DE_NIVEL_BUTTON = getProperty("profile.prueba.de.nivel.button"),
                PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE = getProperty("profile.message.over.actual.certificate");
    }

    public static class TeacherFeedback {
        public static final String TEACHER_FEEDBACK_HEADER_TEXT = getProperty("teacherfeedback.header.text"),
                TEACHER_FEEDBACK_VER_EL_INDICE_DEL_CURSO_TEXT = getProperty("teacherfeedback.verelindice.del.curso.text"),
                TEACHER_FEEDBACK_FECHA_COLUMN = getProperty("teacherfeedback.fecha.column"),
                TEACHER_FEEDBACK_SUGERENCIA_SOLICITADA_COLUMN = getProperty("teacherfeedback.sugerencia.solicitada.column"),
                TEACHER_FEEDBACK_RESPUESTA_DEL_PROFESOR_COLUMN = getProperty("teacherfeedback.respuesta.del.profesor.column"),
                TEACHER_FEEDBACK_TEACHERS_NAME = getProperty("teacherfeedback.teachers.name"),
                TEACHER_FEEDBACK_POP_UP_HEADER_TEXT = getProperty("teacherfeedback.popup.header.text"),
                TEACHER_FEEDBACK_POP_UP_HEADER_TEXT_AFTER_SAD = getProperty("teacherfeedback.popup.header.text.sad"),
                TEACHER_FEEDBACK_POP_UP_MESSAGE = getProperty("teacherfeedback.popup.message");
    }

    public static class History {
        public static final String HISTORY_HEADER_TEXT = getProperty("history.header.text"),
                HISTORY_HEADER_LINK_TEXT = getProperty("history.header.link.text"),
                HISTORY_BORRAR_TODO_TEXT = getProperty("history.borrartodo.text"),
                HISTORY_TABLE_HEADER_FECHA_TEXT = getProperty("history.table.header.fecha.text"),
                HISTORY_TABLE_HEADER_TIPO_TEXT = getProperty("history.table.header.tipo.text"),
                HISTORY_TABLE_HEADER_TITULO_TEXT = getProperty("history.table.header.titulo.text"),
                HISTORY_TABLE_HEADER_DESCRIPCION_TEXT = getProperty("history.table.header.descripcion.text"),
                HISTORY_TABLE_HEADER_RESULTS_TEXT = getProperty("history.table.header.results.text"),
                HISTORY_TABLE_RESULTS_REPRODUCIR_TEXT = getProperty("history.table.results.reproducir.text"),
                HISTORY_URL_ENDS_WITH = getProperty("history.url.endsWith"),
                HISTORY_TIPO_TEXT = getProperty("history.table.tipo.practice.text");
    }

    public static class MyNotebook {
        public static final String MY_NOTEBOOK_HEADER_TEXT = getProperty("mynotebook.header.text"),
                MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_TEXT = getProperty("mynotebook.verelindice.del.curso.text"),
                MY_NOTEBOOK_VER_EL_INDICE_DEL_CURSO_LINK = getProperty("mynotebook.verelindice.del.curso.link"),
                MY_NOTEBOOKTEXT_IF_NOT_NOTES = getProperty("mynotebook.text.if.not.notes");
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

    public static class Comenzar {
        public static final String THANKS_TEXT = getProperty("comenzar.thanks.text");
    }

    public static class CourseIndex {
        public static final String COURSE_INDEX_HEADER_TEXT = getProperty("courseindex.header.text"),
                COURSE_INDEX_FILTER_TEXT = getProperty("courseindex.filter.text");
    }
}
