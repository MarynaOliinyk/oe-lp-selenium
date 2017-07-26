package com.openenglish.login.restablecercontrasena.fieldsvalidation;

import com.openenglish.core.DriverBase;
import com.openenglish.pages.AbstractPage;
import com.openenglish.pages.FAQPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.core.TestData.FAQ.faqText;
import static com.openenglish.core.TestData.General.lpUrl;
import static com.openenglish.core.TestData.Login.correctPassword;
import static com.openenglish.core.TestData.Login.registeredEmail;
import static com.openenglish.core.TestData.Recovery.recoveryPasswordFaq;

public class C148VerifyFAQTest extends DriverBase {
    private AbstractPage page = new AbstractPage();

    @Test
    public void redirectedToFAQPageTest() {
        open(lpUrl);
        page.positiveLogIn(registeredEmail, correctPassword);
        page.logOut();
        page.loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(recoveryPasswordFaq)).click();
        FAQPage faqPage = new FAQPage();
        faqPage.getFaqText().shouldBe(visible).should(text(faqText));

    }
}
