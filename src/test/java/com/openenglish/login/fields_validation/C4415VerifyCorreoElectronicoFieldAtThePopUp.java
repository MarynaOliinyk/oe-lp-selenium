package com.openenglish.login.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.OpenEnglishPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class C4415VerifyCorreoElectronicoFieldAtThePopUp extends TestBase {

    @Test
    public void correoElectronicoFieldNegativeFlowTest() {
        open(oeUrl);
        OpenEnglishPage oePage = new OpenEnglishPage();

        switchTo().frame(oePage.getPopUpIdentifier());

        oePage.getCorreoElectronFieldNotification().shouldNotBe(visible);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(fieldShouldBeCompleted));

        oePage.getCorreoElectronField().sendKeys(emailWithoutATsymbol);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(notValidEmailTextForRegistration));
        oePage.getCorreoElectronField().clear();

        oePage.getCorreoElectronField().sendKeys(emailWithoutDotCom);
        oePage.getComienzaAhoraButton().shouldHave(text(comienzaAhora)).click();
        oePage.getCorreoElectronFieldNotification().shouldBe(visible).shouldHave(text(notValidEmailTextForRegistration));
        oePage.getCorreoElectronField().clear();
    }

}

