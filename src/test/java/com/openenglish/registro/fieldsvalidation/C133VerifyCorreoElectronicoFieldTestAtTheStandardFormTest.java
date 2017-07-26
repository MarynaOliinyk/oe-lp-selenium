package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.General.oeUrl;
import static com.openenglish.core.TestData.Recovery.emailWithoutATsymbol;
import static com.openenglish.core.TestData.Recovery.emailWithoutDotCom;
import static com.openenglish.core.TestData.Register.comienzaAhora;
import static com.openenglish.core.TestData.Register.fieldShouldBeCompleted;
import static com.openenglish.core.TestData.Register.notValidEmailTextForRegistration;

public class C133VerifyCorreoElectronicoFieldTestAtTheStandardFormTest extends DriverBase {


    @Test
    public void correoElectronicoFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterPage regForm = new RegisterPage();
        regForm.bannerVisibility();
        regForm.getCorreoElectronFieldNotification().shouldNotBe(visible);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        regForm.getCorreoElectronField().sendKeys(emailWithoutATsymbol);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(notValidEmailTextForRegistration));
        regForm.getCorreoElectronField().clear();

        regForm.getCorreoElectronField().sendKeys(emailWithoutDotCom);
        regForm.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        regForm.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(notValidEmailTextForRegistration));
        regForm.getCorreoElectronField().clear();
    }

}
