package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement email = $(By.id("username")),
                         password = $(By.id("password")),
                      loginButton = $(By.id("login-btn")),
                   continueButton = $(By.xpath(".//*[@id='login_content']//a[@class='black-btn migration-continue-btn']"));

    public void logIn(String email, String password) {
        this.email.val(email);
        this.password.val(password);
        continueButton.click();
        loginButton.click();
    }


}
