package com.openenglish.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.RegisterPage;
import com.openenglish.pages.TempMailPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.AGE;
import static com.openenglish.core.TestData.Register.COUNTRY;
import static com.openenglish.core.TestData.Register.FIRST_NAME;
import static com.openenglish.core.TestData.Register.LAST_NAME;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_ONE;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_THREE;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_TWO;
import static com.openenglish.core.TestData.Register.THANKS_POPUP_TEXT;
import static com.openenglish.core.TestData.Register.TITLE;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_MESSAGE_TITLE;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_TITLE;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_URL;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_WAIT;
import static com.openenglish.pages.AbstractPage.openInNewTab;

public class C14PopUpSignUpWithValidInformationTest extends DriverBase {

    @Test
    public void signUpWithValidInformationTest() {
        open(TEMP_MAIL_URL);
        TempMailPage tempMail = new TempMailPage();
        String mail = tempMail.getTempMail().val();
        openInNewTab(OE_URL);
        switchTo().window(TITLE);
        RegisterPage regForm = new RegisterPage();
        switchTo().frame(regForm.getPopUpIdentifier());
        regForm.fillAndSubmitRegistration(FIRST_NAME, LAST_NAME, mail, COUNTRY, MOBILE_SECTION_ONE, MOBILE_SECTION_TWO, MOBILE_SECTION_THREE, AGE);
        regForm.getThanksPopUpText().shouldHave(text(THANKS_POPUP_TEXT));
        switchTo().window(TEMP_MAIL_TITLE);
        tempMail.getReceivedMail().waitUntil(exist, TEMP_MAIL_WAIT).should(text(TEMP_MAIL_MESSAGE_TITLE));

    }
}
