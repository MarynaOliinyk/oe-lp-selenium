package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static com.openenglish.core.TestData.Recovery.RECOVERY_TOOLTIP_EMAIL;

public class LoginPage {
    @Getter
    private SelenideElement email = $(By.id("username")),
            password = $(By.id("password")),
            loginButton = $(By.id("login-btn")),
            banner = $(By.id("banner-content")),
            bannerTitle = $(By.id("banner-title")),
            rememberLogin = $(By.id("remember-login-label")),
            continueButton = $(By.id("banner-continue-btn")),
            closeCookieBannerChevron = $(By.id("banner-collapse")),
            questionIcon = $(By.id("question-mark")),
            tooltip = $(By.xpath(".//div[@class='tooltipster-base tooltipster-default tooltipster-fade tooltipster-fade-show']")),
            passwordReset = $(By.id("recovery-link")),
            signUp = $(By.id("sign-up")),
            tooltipText = $(By.xpath("//div[@class='tooltipster-content']")),
            recoverLink = $(By.xpath(".//*[@id='login_content']//a[@href='recovery.html']")),
            securityField = $(By.id("captcharesponse")),
            popUpTextAfterIncorrectCode = $(By.xpath("dialog-title")),
            popUpCloseAfterIncorrectCode = $(By.xpath("//*[@class='ui-icon ui-icon-closethick']")),
            popUpResetPassword = $(By.id("recovery-link")),
            loginForm = $(By.id("login-form"));

    public void logIn(String email, String password) {
        this.email.shouldBe(visible).val(email);
        this.password.shouldBe(visible).val(password);
        loginButton.click();
    }

    public void cookieBannerVisibility() {
        continueButton.should(visible).click();
    }

    public void logInAndCheckText(String validEmail, String incorrectPassword, String tooltipTexts) {
        logIn(validEmail, incorrectPassword);
        getTooltipText().shouldBe(visible).shouldHave(text(tooltipTexts));
    }

    public void verifyEmail(String email, String password) {
        getEmail().clear();
        logIn(email, password);
        getTooltipText().shouldBe(visible).shouldHave(text(RECOVERY_TOOLTIP_EMAIL));
        back();
    }
}
