package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenEnglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class C4414VerifyApellidoFieldAtThePopUp extends TestBase {

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(oeUrl);
        OpenEnglishPage oePage = new OpenEnglishPage();

        switchTo().frame(oePage.getPopUpIdentifier());
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
