package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RegisterFormPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class C132VerifyApellidoFieldTestAtTheStandardForm extends TestBase {

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterFormPage regForm = new RegisterFormPage();
        regForm.bannerVisibility();
        regForm.getAppelidoFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        regForm.getAppelidoField().sendKeys(randonNumbers(Integer.parseInt(numberLength)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getAppelidoField().clear();

        regForm.getAppelidoField().sendKeys(specialCharacters);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getAppelidoField().clear();

        regForm.getAppelidoField().sendKeys(randCharacters(Integer.parseInt(charQuantity)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(lessThenEightyCharacters));
    }

}
