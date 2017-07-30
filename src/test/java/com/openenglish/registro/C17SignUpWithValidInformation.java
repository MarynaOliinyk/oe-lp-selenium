package com.openenglish.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.RegisterPage;
import com.openenglish.pages.TempMail;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.oeUrl;
import static com.openenglish.core.TestData.Register.age;
import static com.openenglish.core.TestData.Register.firstName;
import static com.openenglish.core.TestData.Register.lastName;
import static com.openenglish.core.TestData.Register.mobileSectionOne;
import static com.openenglish.core.TestData.Register.mobileSectionThree;
import static com.openenglish.core.TestData.Register.mobileSectionTwo;
import static com.openenglish.core.TestData.Register.thanksText;
import static com.openenglish.core.TestData.Register.title;
import static com.openenglish.core.TestData.TempMail.tempMailMessageTitle;
import static com.openenglish.core.TestData.TempMail.tempMailTitle;
import static com.openenglish.core.TestData.TempMail.tempMailUrl;
import static com.openenglish.core.TestData.TempMail.tempMailWait;
import static com.openenglish.pages.AbstractPage.openInNewTab;

public class C17SignUpWithValidInformation extends DriverBase {

    @Test
    public void signUpWithValidInformationTest() {
        open(tempMailUrl);
        TempMail tempMail = new TempMail();
        String mail = tempMail.getTempMail().val();
        openInNewTab(oeUrl);
        switchTo().window(title);
        RegisterPage regForm = new RegisterPage();
        switchTo().frame(regForm.getPopUpIdentifier());
        regForm.fillAndSubmitRegistration(firstName, lastName, mail, mobileSectionOne, mobileSectionTwo, mobileSectionThree, age);
        regForm.getThanksText().shouldHave(text(thanksText));
        switchTo().window(tempMailTitle);
        tempMail.getReceivedMail().waitUntil(exist, tempMailWait).should(text(tempMailMessageTitle));
    }
}
