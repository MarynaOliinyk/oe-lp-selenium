package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenEnglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class C132VerifyApellidoFieldTestAtTheStandardForm extends TestBase {

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(oeUrl);
        OpenEnglishPage oePage = new OpenEnglishPage();
        oePage.bannerVisibility();
        oePage.getAppelidoFieldNotification().shouldNotBe(visible);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        oePage.getAppelidoField().sendKeys(randonNumbers(Integer.parseInt(numberLength)));
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        oePage.getAppelidoField().clear();

        oePage.getAppelidoField().sendKeys(specialCharacters);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        oePage.getAppelidoField().clear();

        oePage.getAppelidoField().sendKeys(randCharacters(Integer.parseInt(charQuantity)));
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(lessThenEightyCharacters));
    }

}
