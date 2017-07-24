package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class C132VerifyApellidoFieldTestAtTheStandardFormTest extends TestBase {

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterPage regForm = new RegisterPage();
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

        regForm.getAppelidoField().sendKeys(randCharacters(Integer.parseInt(charQuantityAppelido)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(lessThenEightyCharacters));
    }

}
