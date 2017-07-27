package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.openenglish.core.TestData.General.oeUrl;
import static com.openenglish.core.TestData.Register.charQuantityNombre;
import static com.openenglish.core.TestData.Register.comienzaAhora;
import static com.openenglish.core.TestData.Register.fieldShouldBeCompleted;
import static com.openenglish.core.TestData.Register.inCorrectValue;
import static com.openenglish.core.TestData.Register.lessThenFortyCharacters;
import static com.openenglish.core.TestData.Register.numberLength;
import static com.openenglish.core.TestData.Register.specialCharacters;

public class C3843VerifyNombreFieldTestAtThePopUpFormTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void nombreFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterPage regForm = new RegisterPage();
        switchTo().frame(regForm.getPopUpIdentifier());
        regForm.getNombreFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().waitUntil(visible, 3000).shouldHave(text(fieldShouldBeCompleted));

        regForm.getNombreField().sendKeys(page.randonNumbers(Integer.parseInt(numberLength)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(specialCharacters);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(page.randCharacters(Integer.parseInt(charQuantityNombre)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(lessThenFortyCharacters));
    }

}
