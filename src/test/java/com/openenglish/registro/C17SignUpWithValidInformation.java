package com.openenglish.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.Comenzar;
import com.openenglish.pages.RegisterPage;
import com.openenglish.pages.TempMail;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.Comenzar.THANKS_TEXT;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.AGE;
import static com.openenglish.core.TestData.Register.COUNTRY;
import static com.openenglish.core.TestData.Register.FIRST_NAME;
import static com.openenglish.core.TestData.Register.LAST_NAME;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_ONE;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_THREE;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_TWO;
import static com.openenglish.core.TestData.Register.TITLE;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_MESSAGE_TITLE;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_TITLE;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_URL;
import static com.openenglish.core.TestData.TempMail.TEMP_MAIL_WAIT;
import static com.openenglish.pages.AbstractPage.openInNewTab;

public class C17SignUpWithValidInformation extends DriverBase {

    @Test
    public void signUpWithValidInformationTest() {
        open(TEMP_MAIL_URL);
        TempMail tempMail = new TempMail();
        String mail = tempMail.getTempMail().val();
        openInNewTab(OE_URL);
        switchTo().window(TITLE);
        RegisterPage regForm = new RegisterPage();
        regForm.getPopUpCloseButton().should(exist).click();
        regForm.fillAndSubmitRegistration(FIRST_NAME, LAST_NAME, mail, COUNTRY, MOBILE_SECTION_ONE, MOBILE_SECTION_TWO, MOBILE_SECTION_THREE, AGE);
        Comenzar comenzar = new Comenzar();
        comenzar.getThanksText().should(text(THANKS_TEXT));
        switchTo().window(TEMP_MAIL_TITLE);
        tempMail.getReceivedMail().waitUntil(exist, TEMP_MAIL_WAIT).should(text(TEMP_MAIL_MESSAGE_TITLE));
    }
}
