package com.openenglish.reset_password.filds_validatoin;


import com.openenglish.core.TestBase;
import com.openenglish.pages.FAQPage;
import com.openenglish.pages.InicioPage;
import com.openenglish.pages.LoginPage;
import com.openenglish.pages.RecoveryPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.openenglish.util.PropertiesCache.getInstance;

public class VerifyFAQTest extends TestBase{
    private String email = getInstance().getProperty("email");
    private String password = getInstance().getProperty("password");
    private String resetPasswordFaq = getInstance().getProperty("reset.password.faq");
    private String faqText = getInstance().getProperty("faq.text");
    @Test
    public void redirectedToFAQPageTest (){
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(email, password);
        InicioPage inicioPage = new InicioPage();
        inicioPage.getAccountMenu().hover();
        inicioPage.getLogOutLink().click();
        loginPage.getPasswordReset().should(exist).click();
        RecoveryPage recoveryPage = new RecoveryPage();
        recoveryPage.getFaq().shouldBe(visible).shouldHave(text(resetPasswordFaq)).click();
        FAQPage faqPage = new FAQPage();
        faqPage.getFaqText().shouldBe(visible).should(text(faqText));

    }
}
