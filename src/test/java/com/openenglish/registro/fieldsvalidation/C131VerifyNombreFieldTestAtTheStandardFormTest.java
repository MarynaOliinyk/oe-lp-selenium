package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class C131VerifyNombreFieldTestAtTheStandardFormTest extends TestBase {

    @Test
    public void nombreFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterPage regForm = new RegisterPage();
        regForm.bannerVisibility();
        regForm.getNombreFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        regForm.getNombreField().sendKeys(randonNumbers(Integer.parseInt(numberLength)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(specialCharacters);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getNombreField().clear();

        regForm.getNombreField().sendKeys(randCharacters(Integer.parseInt(charQuantityNombre)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getNombreFieldNotification().shouldBe(visible).shouldHave(text(lessThenFortyCharacters));
    }

}
