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
                USER_NAME_WITHOUT_NOTES = getProperty("login.user.name.without.notes"),
                EMAIL_WITHOUT_NOTES = getProperty("login.correct.email.without.notes"),
                PASSWORD_WITHOUT_NOTES = getProperty("login.correct.password.without.notes");
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
                MOBILE_SECTION_ONE_INCORRECT = getProperty("register.mobile.section.one.incorrect"),
                MOBILE_AREA_CODES_MESSAGE = getProperty("register.mobile.area.codes.message"),
                MOBILE_AREA_CODES_PATTERN = getProperty("register.mobile.area.codes.pattern"),
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
                INICIO_HEADER_TEXT = getProperty("inicio.header.text"),
                INICIO_COMENZAR_TEXT = getProperty("inicio.comenzar.text.on.video"),
                INICIO_MENSAJES_BUTTON_TEXT = getProperty("inicio.mensajes.link.text"),
                INICIO_USER_NICK_NAME = getProperty("inicio.nick.user.name"),
                INICIO_SALIR_BUTTON_TEXT = getProperty("inicio.salir.link.text"),
                INICIO_PREFERENCIAS_BUTTON_TEXT = getProperty("inicio.preferencias.link.text");
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
        public static final String INTRODUSSION_HEADER_TEXT = getProperty("introduction.header.text"),
                INTRODUSSION_DROP_BLOCK_MESSAGE = getProperty("introduction.dropblock.message"),
                INTRODUSSION_DROP_BLOCK_HEADER_TEXT = getProperty("introduction.dropblock.header.text"),
                INTRODUSSION_DROP_BLOCK_LESSON_LINK = getProperty("introduction.dropblock.lesson.link"),
                INTRODUSSION_DROP_BLOCK_CLASSES_EN_VIVO_LINK = getProperty("introduction.dropblock.classesenvivo.link"),
                INTRODUSSION_LESSON = getProperty("introduction.lesson"),
                INTRODUSSION_LESSON_AND_NUMBER = getProperty("introduction.lesson.and.number"),
                INTRODUSSION_DESCRIPTION_OF_EACH_LESSON = getProperty("introduccion.description.of.each.lesson"),
                INTRODUSSION_DESCRIPTION_CENTRE_LESSON = getProperty("introduccion.description.centre.lesson"),
                INTRODUSSION_COMENZAR_BUTTON = getProperty("introduccion.comenzar.button.text");
    }

    public static class Lessons {
        public static final String LESSONS_PAGE_TITLE = getProperty("lessons.page.header.title.text"),
                LESSONS_PAGE_HEADER_TITLE = getProperty("lessons.page.header.text"),
                LESSONS_TEXT = getProperty("lessons.text"),
                LESSONS_REMINDER_TITLE = getProperty("lessons.reminder.title.text"),
                LESSONS_REMINDER_BODY = getProperty("lessons.reminder.body.text"),
                LESSONS_REMINDER_LESSONS_LINK = getProperty("lessons.reminder.lessons.link.text"),
                LESSONS_REMINDER_PRACTICA_LINK = getProperty("lessons.reminder.practica.link.text"),
                LESSONS_REMINDER_LIVECLASSES_LINK = getProperty("lessons.reminder.liveclasses.link.text"),
                LESSONS_BEGIN_LESSON_BUTTON = getProperty("lessons.reminder.begin.button.text"),
                LESSONS_MENU_TITLE_TEXT = getProperty("lessons.menu.title.text"),
                LESSONS_MENU_PROGRESS_TEXT = getProperty("lessons.menu.progress.text"),
                LESSONS_MENU_MONSTRAR_TEXT = getProperty("lessons.menu.monstrar.text"),
                LESSONS_MENU_OCULTAR_TEXT = getProperty("lessons.menu.ocultar.text"),
                LESSONS_CONTINUAR_LESSON_TEXT = getProperty("lessons.continuar.lesson.link.text"),
                LESSONS_MENU_TEXT = getProperty("lessons.menu.header.text"),
                LESSONS_ASK_TEACHER_HEADER_CLASS = getProperty("lessons.ask.teacher.header.class"),
                LESSONS_ASK_TEACHER_HEADER_TEXT = getProperty("lessons.ask.teacher.header.text"),
                LESSONS_ASK_TEACHER_SUBMIT_TEXT = getProperty("lessons.ask.teacher.submit.button.text"),
                LESSONS_ALLERT_HEADER_TEXT = getProperty("lessons.ask.teacher.allert.header.text"),
                LESSONS_ALLERT_BODY_TEXT = getProperty("lessons.ask.teacher.allert.body.text"),
                LESSONS_ALLERT_CERRAR_TEXT = getProperty("lessons.ask.teacher.cerrar.button.text"),
                LESSONS_MY_NOTES_HEADER_TEXT = getProperty("lessons.mis.notes.header.text"),
                LESSONS_MY_NOTES_LIST_HEADER_TEXT = getProperty("lessons.mis.notes.list.header.text"),
                LESSONS_MY_NOTES_GUARDAR_TEXT = getProperty("lessons.mis.notes.guardar.nota.button.text"),
                LESSONS_INDICE_DEL_CURSO_URL = getProperty("lessons.indice.del.curso.url"),
                LESSONS_SOME_TEXT_FOR_TEST = getProperty("base.sentence.for.some.text.test"),
                LESSONS_LO_LOGRO_TITLE_TEXT = getProperty("lessons.popup.lo.logro.title.text"),
                LESSONS_LO_LOGRO_SUS_LOGROS_TEXT = getProperty("lessons.popup.lo.logro.comparta.sus.logros.text"),
                LESSONS_LO_LOGRO_TWITTER_BUTTON_URL = getProperty("lessons.popup.lo.logro.twitter.button.url"),
                LESSONS_LO_LOGRO_FACEBOOK_BUTTON_URL = getProperty("lessons.popup.lo.logro.facebook.button.url"),
                LESSONS_LO_LOGRO_GOOGLE_BUTTON_URL = getProperty("lessons.popup.lo.logro.google.button.url"),
                LESSONS_LO_LOGRO_PROXIMA_BUTTON = getProperty("lessons.popup.lo.logro.proxima.button.text"),
                LESSONS_TEXT_FOR_SPECIFIC_LESSON = getProperty("lessons.specific.text");
    }

    public static class TalkNow {
        public static final String TALK_NOW_HEADER_TEXT = getProperty("talknow.header.text"),
                TALK_NOW_ASESOR_TEXT = getProperty("talknow.asesor.text"),
                TALK_NOW_ASESOR_HOVER_TEXT = getProperty("talknow.asesor.img.hover.text"),
                TALK_NOW_PROFESOR_TEXT = getProperty("talknow.profesor.text"),
                TALK_NOW_PROFESOR_HOVER_TEXT = getProperty("talknow.profesor.img.hover.text"),
                TALK_NOW_LIVEAGENT_ONLINE_TEXT = getProperty("talknow.liveagent.online.message.text"),
                TALK_NOW_LIVEAGENT_OFFLINE_TEXT = getProperty("talknow.liveagent.offline.message.text"),
                TALK_NOW_LIVEAGENT_PHONE = getProperty("talknow.liveagent.phone.nember"),
                TALK_NOW_ENVIAR_UNA_PREGUNTA_TEXT = getProperty("talknow.enviar.una.pregunta.link.text"),
                TALK_NOW_PREGUNTE_A_UN_PROFESOR_TEXT = getProperty("talknow.popup.pregunta.title.text"),
                TALK_NOW_PREGUNTE_POPUP_INSTRUCTIONS_TEXT = getProperty("talknow.popup.pregunta.instructions.text"),
                TALK_NOW_PREGUNTE_POPUP_MESSAGE_PLACEHOLDER_TEXT = getProperty("talknow.popup.pregunta.message.placeholder.text");
    }

    public static class TestYourSystem {
        public static final String TEST_YOUR_SYSTEM_HEADER_TEXT = getProperty("testyoursystem.header.text"),
                TEST_YOUR_SYSTEM_REQUIREMENTS_SYSTEM_TEXT = getProperty("testyoursystem.system.requirements.text"),
                TEST_YOUR_SYSTEM_REQUIREMENTS_BROWSER_TEXT = getProperty("testyoursystem.browser.requirements.text"),
                TEST_YOUR_SYSTEM_OTHER_REQUIREMENTS_TEXT = getProperty("testyoursystem.other.requirements.text"),
                TEST_YOUR_SYSTEM_VERIFICA_TU_SISTEMA_BUTTON_TEXT = getProperty("testyoursystem.verifica.tu.sistema.button.text");
    }

    public static class ParticipantsGuide {
        public static final String PARTICIPANT_GUIDE_NAMES_PDF_FILE = getProperty("participantsGuide.names.pdf.file"),
                PARTICIPANT_GUIDE_LINK = getProperty("participantsGuide.link");
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
                PROFILE_MESSAGE_OVER_ACTUAL_CERTIFICATE = getProperty("profile.message.over.actual.certificate"),
                PROFILE_ACTUAL_MONTH = getProperty("profile.actual.month"),
                PROFILE_PREVIOUS_MONTH = getProperty("profile.previous.month"),
                PROFILE_POP_UP_HEADER_TEXT = getProperty("profile.popup.header.text"),
                PROFILE_POP_UP_CANCEL_BUTTON_TEXT = getProperty("profile.popup.cancel.button.text"),
                PROFILE_POP_UP_CONTINUE_BUTTON_TEXT = getProperty("profile.popup.continue.button.text"),
                PROFILE_OVER_SEMANA_TEXT = getProperty("profile.over.semana.text");
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

    public static class HowToVideos {
        public static final String HOW_TO_VIDEOS_VIDEOS_TITLE_TEXT = getProperty("howtovideos.videos.title.text"),
                HOW_TO_VIDEOS_VIDEOS_DESCRIPTION_TEXT = getProperty("howtovideos.videos.description.text");
    }

    public static class Preferences {
        public static final String MI_PERFIL_TAB_TEXT = getProperty("preferences.miperfil.tab.text"),
                PREFERENCES_URL_END_WITH_TEXT = getProperty("preferences.page.url.endwith"),
                OBLIGATORIO_TEXT = getProperty("preferences.miperfil.obligatorio.notification.text"),
                NO_ES_NOMBRE_VALIDO_TEXT = getProperty("preferences.miperfil.no.es.nombre.valido.notification.text"),
                SPECIAL_SYMBOLS = getProperty("preferences.miperfil.special.symbols.test");
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

    public static class MensajesPage {
        public static final String SIN_LEER = getProperty("mensajes.sin.leer.text"),
                FECHA_HORA = getProperty("mensajes.fecha.hora.text"),
                ENVIADO_POR = getProperty("mensajes.enviado.por.text"),
                AVISO = getProperty("mensajes.aviso.text");
    }

}
