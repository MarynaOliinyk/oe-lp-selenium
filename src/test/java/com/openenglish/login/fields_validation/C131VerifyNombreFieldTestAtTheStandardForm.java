package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenEnglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class C131VerifyNombreFieldTestAtTheStandardForm extends TestBase {

    @Test
    public void nombreFieldNegativeFlowTest() {
        open(oeUrl);
        OpenEnglishPage oePage = new OpenEnglishPage();
        oePage.bannerVisibility();
        oePage.getNombreFieldNotification().shouldNotBe(visible);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getNombreFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        oePage.getNombreField().sendKeys(randonNumbers(Integer.parseInt(numberLength)));
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        oePage.getNombreField().clear();

        oePage.getNombreField().sendKeys(specialCharacters);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getNombreFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        oePage.getNombreField().clear();

        oePage.getNombreField().sendKeys(randCharacters(Integer.parseInt(charQuantity)));
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getNombreFieldNotification().shouldBe(visible).shouldHave(text(lessThenFortyCharacters));
    }

}
