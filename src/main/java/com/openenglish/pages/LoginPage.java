package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    @Getter
    private SelenideElement email = $(By.id("username")),
                         password = $(By.id("password")),
                      loginButton = $(By.id("login-btn")),
                   continueButton = $(By.xpath(".//*[@id='login_content']//a[@class='black-btn migration-continue-btn']")),
         closeCookieBannerChevron = $(By.xpath(".//*[@id='login_content']/div[1]/div[1]/i")),
                     questionIcon = $(By.xpath(".//*[@id='login_content']/div[3]/div/form/fieldset/div/div/div/div[3]/div[1]/span/i")),
                          tooltip = $(By.xpath(".//div[@class='tooltipster-base tooltipster-default tooltipster-fade tooltipster-fade-show']")),
                    passwordReset = $(By.xpath(".//*[@id='login_content']/div[3]/div/form/fieldset/div/div/div/div[3]/div[2]/a")),
                           signUp = $(By.id("sign-up"));

    public void logIn(String email, String password) {
        this.email.val(email);
        this.password.val(password);
        continueButton.click();
        loginButton.click();
    }
}
