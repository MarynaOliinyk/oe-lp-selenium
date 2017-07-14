package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Getter
    private SelenideElement email = $(By.id("username")),
            password = $(By.id("password")),
            loginButton = $(By.id("login-btn")),
            banner = $(By.xpath("//div[@class='banner-content']")),
            bannerTitle = $(By.xpath(".//*[@id='login_content']//div[@class='banner-title']")),
            rememberLogin = $(By.xpath(".//*[@id='login_content']//label[@for='rememberLogin']")),
            continueButton = $(By.xpath(".//*[@id='login_content']//a[@class='black-btn migration-continue-btn']")),
    closeCookieBannerChevron = $(By.xpath(".//*[@id='login_content']/div[1]/div[1]/i")),
    questionIcon = $(By.xpath(".//*[@id='login_content']/div[3]/div/form/fieldset/div/div/div/div[3]/div[1]/span/i")),
    tooltip = $(By.xpath(".//div[@class='tooltipster-base tooltipster-default tooltipster-fade tooltipster-fade-show']")),
    passwordReset = $(By.xpath(".//*[@id='login_content']/div[3]/div/form/fieldset/div/div/div/div[3]/div[2]/a")),
    signUp = $(By.id("sign-up"));

    public void logIn(String email, String password) {
        this.email.shouldBe(visible).val(email);
        this.password.shouldBe(visible).val(password);
        loginButton.click();
    }

    public void cookieBannerVisibility() {
        if(continueButton.isDisplayed()) {
            continueButton.click();
        }
    }
}
