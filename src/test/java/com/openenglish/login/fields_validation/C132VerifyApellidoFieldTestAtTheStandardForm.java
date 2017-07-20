package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenenglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class C132VerifyApellidoFieldTestAtTheStandardForm extends TestBase {

    private String oeUrl = getInstance().getProperty("base.oe.url");
    private String specialCharacters = getInstance().getProperty("special.characters");
    private String comienzaAhora = getInstance().getProperty("comienza.ahora.button.text");
    private String fieldShouldBeCompleted = getInstance().getProperty("obligatory.field.message");
    private String inCorrectValue = getInstance().getProperty("incorrect.field.value.message");
    private String lessThenForty = getInstance().getProperty("field.surname.lenth.acceptense.message");
    private String charQuantity = getInstance().getProperty("char.quantity.surname");
    private String numberLength = getInstance().getProperty("number.length");

    @Test
    public void appelidoFieldNegativeFlowTest() {
        open(oeUrl);
        OpenenglishPage oePage = new OpenenglishPage();
        oePage.bannerVisibility();
        oePage.getAppelidoFieldNotification().shouldNotBe(visible);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        oePage.getAppelidoField().sendKeys(oePage.randonNumbers(Integer.parseInt(numberLength)));
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        oePage.getAppelidoField().clear();

        oePage.getAppelidoField().sendKeys(specialCharacters);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(inCorrectValue));
        oePage.getAppelidoField().clear();

        oePage.getAppelidoField().sendKeys(oePage.randCharacters(Integer.parseInt(charQuantity)));
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getAppelidoFieldNotification().shouldBe(visible).shouldHave(text(lessThenForty));
    }

}
