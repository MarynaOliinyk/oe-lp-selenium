package com.openenglish.core;

import static com.openenglish.util.PropertiesCache.getProperty;

public class TestData {

    public static class General {
        public static final String oeUrl = getProperty("base.oe.url");
        public static final String lpUrl = getProperty("base.lp.url");
    }

    public static class Login {
        public static final String loginTooltipPassword = getProperty("login.tooltip.text.for.password");
        public static final String loginTooltipSecurityCode = getProperty("login.tooltip.invalid.security.text");
        public static final String invalidSecurityCode = getProperty("login.invalid.security.code");
        public static final String popUpInvalidSecurityCode = getProperty("login.popup.invalid.security.code");
        public static final String userName = getProperty("login.user.name");
        public static final String registeredEmail = getProperty("login.correct.email");
        public static final String correctPassword = getProperty("login.correct.password");
        public static final String unregisteredEmail = getProperty("login.unregistered.email");
        public static final String invalidPassword = getProperty("login.invalid.password");
        public static final String securityPlaceHolderText = getProperty("login.security.placeholder");
    }

    public static class Recovery {
        public static final String emailWithoutATsymbol = getProperty("recovery.email.without@");
        public static final String emailWithoutDotCom = getProperty("recovery.email.without.com");
        public static final String notValidEmailText = getProperty("recovery.tooltip.not.valid.email");
        public static final String recoveryTooltipEmail = getProperty("recovery.tooltip.text");
        public static final String recoveryPasswordFormTitle = getProperty("recovery.password.form.title");
        public static final String recoveryPasswordFaq = getProperty("recovery.password.faq");
        public static final String recoveryPasswordSingUpText = getProperty("recovery.password.sing.up");
        public static final String registrateText = getProperty("recovery.link.text");
    }

    public static class Register {
        public static final String notValidEmailTextForRegistration = getProperty("register.field.email.acceptense.message");
        public static final String fieldShouldBeCompleted = getProperty("register.obligatory.field.message");
        public static final String inCorrectValue = getProperty("register.incorrect.field.value.message");
        public static final String lessThenEightyCharacters = getProperty("register.field.surname.lenth.acceptense.message");
        public static final String lessThenFortyCharacters = getProperty("register.field.name.lenthg.acceptense.message");
        public static final String charQuantityNombre = getProperty("register.char.quantity.name");
        public static final String charQuantityAppelido = getProperty("register.char.quantity.surname");
        public static final String numberLength = getProperty("register.number.length");
        public static final String specialCharacters = getProperty("register.special.characters");
        public static final String comienzaAhora = getProperty("register.comienza.ahora.button.text");
    }

    public static class FAQ {
        public static final String faqHeaderText = getProperty("faq.header.text");
    }

    public static class FAQS {
        public static final String faqsText = getProperty("faqs.text");
    }

    public static class Inicio {
        public static final String inicioLink = getProperty("inicio.link.text");
        public static final String mensajesButtonText = getProperty("inicio.mensajes.link.text");
        public static final String userNickName = getProperty("inicio.nick.user.name");
        public static final String salirButtonText = getProperty("inicio.salir.link.text");
        public static final String preferenciasButtonText = getProperty("inicio.preferencias.link.text");
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
        public static final String teacherFeedbackHeaderText = getProperty("teacherfeedback.header.text");
    }


    public static class History {
        public static final String historyHeaderText = getProperty("history.header.text");
    }

    public static class MyNotebook {
        public static final String myNotebookHeaderText = getProperty("mynotebook.header.text");
    }
    public static class Preferences {
        public static final String miPerfilTabText = getProperty("preferences.miperfil.tab.text");
        public static final String preferencesUrlEndWithText = getProperty("preferences.page.url.endwith");
    }

}
