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
            continueButton = $(By.xpath(".//*[@id='login_content']//a[@class='black-btn migration-continue-btn']"));

    public void logIn(String email, String password) {
        this.email.shouldBe(visible).val(email);
        this.password.shouldBe(visible).val(password);
        if(continueButton.isDisplayed()) {
            continueButton.click();
        }
        loginButton.click();
    }
}
