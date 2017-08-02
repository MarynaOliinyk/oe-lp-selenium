package com.openenglish.registro;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.TITLE;
import static org.testng.AssertJUnit.assertTrue;

public class C163PopUpCanBeClosedTest extends DriverBase {

    @Test
    public void popUpCanBeClosedTest() {
        open(OE_URL);
        RegisterPage regForm = new RegisterPage();
        regForm.getPopUpCloseButton().should(exist).click();
        assertTrue(title().equals(TITLE));
    }
}
