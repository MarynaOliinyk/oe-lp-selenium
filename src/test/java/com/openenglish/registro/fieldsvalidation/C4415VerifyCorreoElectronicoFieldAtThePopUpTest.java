package com.openenglish.registro.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.RegisterPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class C4415VerifyCorreoElectronicoFieldAtThePopUpTest extends TestBase {

    @Test
    public void correoElectronicoFieldNegativeFlowTest() {
        open(oeUrl);
        RegisterPage regForm = new RegisterPage();

        switchTo().frame(regForm.getPopUpIdentifier());

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

