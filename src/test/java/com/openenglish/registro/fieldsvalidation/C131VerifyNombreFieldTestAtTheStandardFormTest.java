package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.CHAR_QUANTITY_NOMBRE;
import static com.openenglish.core.TestData.Register.COMIENZA_AHORA;
import static com.openenglish.core.TestData.Register.FIELD_SHOULD_BE_COMPLETED;
import static com.openenglish.core.TestData.Register.IN_CORRECT_VALUE;
import static com.openenglish.core.TestData.Register.LESS_THEN_FORTY_CHARACTERS;
import static com.openenglish.core.TestData.Register.NUMBER_LENGTH;
import static com.openenglish.core.TestData.Register.SPECIAL_CHARACTERS;

public class C131VerifyNombreFieldTestAtTheStandardFormTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void nombreFieldNegativeFlowTest() {
        open(OE_URL);
        RegisterPage regForm = new RegisterPage();
        regForm.getPopUpCloseButton().should(exist).click();
        regForm.getNombreFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().should(visible,text(COMIENZA_AHORA)).click();
        regForm.getNombreFieldNotification().should(visible, text(FIELD_SHOULD_BE_COMPLETED));

        regForm.getNombreField().sendKeys(page.randonNumbers(Integer.parseInt(NUMBER_LENGTH)));
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getNombreFieldNotification().should(visible,text(IN_CORRECT_VALUE));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(SPECIAL_CHARACTERS);
        regForm.getComienzaAhoraButton().should(text(COMIENZA_AHORA)).click();
        regForm.getNombreFieldNotification().should(visible,text(IN_CORRECT_VALUE));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(page.randCharacters(Integer.parseInt(CHAR_QUANTITY_NOMBRE)));
        regForm.getComienzaAhoraButton().should(text(COMIENZA_AHORA)).click();
        regForm.getNombreFieldNotification().should(visible,text(LESS_THEN_FORTY_CHARACTERS));
    }

}
