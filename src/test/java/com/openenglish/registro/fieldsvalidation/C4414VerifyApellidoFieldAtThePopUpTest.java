package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Register.CHAR_QUANTITY_APPELIDO;
import static com.openenglish.core.TestData.Register.COMIENZA_AHORA;
import static com.openenglish.core.TestData.Register.FIELD_SHOULD_BE_COMPLETED;
import static com.openenglish.core.TestData.Register.IN_CORRECT_VALUE;
import static com.openenglish.core.TestData.Register.LESS_THEN_EIGHTY_CHARACTERS;
import static com.openenglish.core.TestData.Register.NUMBER_LENGTH;
import static com.openenglish.core.TestData.Register.SPECIAL_CHARACTERS;

public class C4414VerifyApellidoFieldAtThePopUpTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(OE_URL);
        RegisterPage regForm = new RegisterPage();

        switchTo().frame(regForm.getPopUpIdentifier());
        regForm.getAppelidoFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(FIELD_SHOULD_BE_COMPLETED));

        regForm.getAppelidoField().sendKeys(page.randomNumbers(Integer.parseInt(NUMBER_LENGTH)));
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(IN_CORRECT_VALUE));
        regForm.getAppelidoField().clear();

        regForm.getAppelidoField().sendKeys(SPECIAL_CHARACTERS);
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(IN_CORRECT_VALUE));
        regForm.getAppelidoField().clear();

        regForm.getAppelidoField().sendKeys(page.randCharacters(Integer.parseInt(CHAR_QUANTITY_APPELIDO)));
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(LESS_THEN_EIGHTY_CHARACTERS));
    }

}
