package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.oeUrl;
import static com.openenglish.core.TestData.Register.charQuantityAppelido;
import static com.openenglish.core.TestData.Register.comienzaAhora;
import static com.openenglish.core.TestData.Register.fieldShouldBeCompleted;
import static com.openenglish.core.TestData.Register.inCorrectValue;
import static com.openenglish.core.TestData.Register.lessThenEightyCharacters;
import static com.openenglish.core.TestData.Register.numberLength;
import static com.openenglish.core.TestData.Register.specialCharacters;

public class C132VerifyApellidoFieldTestAtTheStandardFormTest extends DriverBase {

    private AbstractPage page = new AbstractPage();

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterPage regForm = new RegisterPage();
        regForm.bannerVisibility();
        regForm.getAppelidoFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        regForm.getAppelidoField().sendKeys(page.randonNumbers(Integer.parseInt(numberLength)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getAppelidoField().clear();

        regForm.getAppelidoField().sendKeys(specialCharacters);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        regForm.getAppelidoField().clear();

        regForm.getAppelidoField().sendKeys(page.randCharacters(Integer.parseInt(charQuantityAppelido)));
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(lessThenEightyCharacters));
    }

}
