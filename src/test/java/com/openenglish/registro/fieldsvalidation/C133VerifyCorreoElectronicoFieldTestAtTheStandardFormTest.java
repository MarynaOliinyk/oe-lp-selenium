package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.OE_URL;
import static com.openenglish.core.TestData.Recovery.EMAIL_WITHOUT_A_TSYMBOL;
import static com.openenglish.core.TestData.Recovery.EMAIL_WITHOUT_DOT_COM;
import static com.openenglish.core.TestData.Register.COMIENZA_AHORA;
import static com.openenglish.core.TestData.Register.FIELD_SHOULD_BE_COMPLETED;
import static com.openenglish.core.TestData.Register.NOT_VALID_EMAIL_TEXT_FOR_REGISTRATION;

public class C133VerifyCorreoElectronicoFieldTestAtTheStandardFormTest extends DriverBase {


    @Test
    public void correoElectronicoFieldNegativeFlowTest() {
        open(OE_URL);
        RegisterPage regForm = new RegisterPage();
        regForm.bannerVisibility();
        regForm.getCorreoElectronFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(FIELD_SHOULD_BE_COMPLETED));

        regForm.getCorreoElectronField().sendKeys(EMAIL_WITHOUT_A_TSYMBOL);
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(NOT_VALID_EMAIL_TEXT_FOR_REGISTRATION));
        regForm.getCorreoElectronField().clear();

        regForm.getCorreoElectronField().sendKeys(EMAIL_WITHOUT_DOT_COM);
        regForm.getComienzaAhoraButton().shouldHave(text(COMIENZA_AHORA)).click();
        regForm.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(NOT_VALID_EMAIL_TEXT_FOR_REGISTRATION));
        regForm.getCorreoElectronField().clear();
    }

}
