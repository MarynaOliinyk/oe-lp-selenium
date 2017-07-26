package com.openenglish.login.restablecercontrasena.fieldsvalidation;

import com.openenglish.core.TestBase;
import com.openenglish.pages.FAQsPage;
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
        FAQsPage FAQsPage = new FAQsPage();
        FAQsPage.getFaqsText().shouldBe(visible).should(text(faqsText));

    }
}
