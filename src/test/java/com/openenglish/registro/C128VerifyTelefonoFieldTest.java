package com.openenglish.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.MOBILE_AREA_CODES_MESSAGE;
import static com.openenglish.core.TestData.Register.MOBILE_AREA_CODES_PATTERN;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_ONE_INCORRECT;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_THREE;
import static com.openenglish.core.TestData.Register.MOBILE_SECTION_TWO;
import static org.testng.AssertJUnit.assertTrue;

public class C128VerifyTelefonoFieldTest extends DriverBase {
    @Test
    public void verifyTelefonoFieldTest() {
        open(OE_URL);
        RegisterPage regForm = new RegisterPage();
        switchTo().frame(regForm.getPopUpIdentifier());
        assertTrue(regForm.getCellularButton().getAttribute("class").contains("active"));
        regForm.getFijoButton().should(visible);
        regForm.getMobileSectionOne().val(MOBILE_SECTION_ONE_INCORRECT);
        regForm.getMobileSectionTwo().val(MOBILE_SECTION_TWO);
        regForm.getMobileSectionThree().val(MOBILE_SECTION_THREE);
        regForm.getComienzaAhoraButton().click();
        regForm.getMobileAreaCodes().should(text(MOBILE_AREA_CODES_MESSAGE)).click();
        assertTrue(regForm.getFormatosPermitidos().stream().allMatch(format ->
                format.should(visible).getText().matches(MOBILE_AREA_CODES_PATTERN)));
        //TODO https://openenglish.jira.com/browse/LPTRIAGE-314
//        regForm.getPopUpCloseButton().click();
//        regForm.getMobileSectionOne().should(text(NUMBER_LENGTH));
//        regForm.getMobileSectionTwo().should(text(MOBILE_SECTION_TWO));
//        regForm.getMobileSectionThree().should(text(MOBILE_SECTION_THREE));
    }
}
