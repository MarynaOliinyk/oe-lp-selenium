package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RegisterFormPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class C3843VerifyNombreFieldTestAtThePopUpForm extends TestBase {

    @Test
    public void nombreFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterFormPage regForm = new RegisterFormPage();
        switchTo().frame(regForm.getPopUpIdentifier());
        regForm.getNombreFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().waitUntil(visible, 3000).shouldHave(text(fieldShouldBeCompleted));

        regForm.getNombreField().sendKeys(randonNumbers(Integer.parseInt(numberLength)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(specialCharacters);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(randCharacters(Integer.parseInt(charQuantity)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(lessThenFortyCharacters));
    }

}
