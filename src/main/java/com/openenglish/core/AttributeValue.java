package com.openenglish.core;

public class AttributeValue {
    public static class IntroductionPage {
        public static final String HOVER_MASK = "hover-mask";
    }

    public static class LoginPage {
        public static final String PASSWORD = "password";
    }

    public static class TalkNowPage {
        public static final String ORANGE_BTN = "orange-btn",
                ORANGE_BTN_DISABLED = ORANGE_BTN + " disabled",
                ORANGE_BTN_CLOSE = ORANGE_BTN + " close-btn";
    }

    public static class PreferencesPage {
        public static final String PREFERENCES_PAGE_DATE_PICKER = "date-picker hasDatepicker",
                PREFERENCES_PAGE_DATE_PICKER_VALID = "date-picker hasDatepicker field-valid",
                PREFERENCES_PAGE_OPTION_CHOOSE_VALUE ="option-choose",
                PREFERENCES_PAGE_PRESSED_VALUE ="pressed";
    }

    public static class TeacherFeedbackPage {
        public static final String HAPPY_NO_RATED = "happy no-rated",
                ORANGE_BTN_SUBMIT_BTN_DISABLED = "orange-btn submit-btn disabled";
    }
}
