package com.openenglish.login.restablecer_contrasena.fields_validation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.FAQPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class С148VerifyFAQTest extends TestBase {

    @Test
    public void redirectedToFAQPageTest() {
        positiveLogIn();
        logOut();
        loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(resetPasswordFaq)).click();
        FAQPage faqPage = new FAQPage();
        faqPage.getFaqText().shouldBe(visible).should(text(faqText));

    }
}
