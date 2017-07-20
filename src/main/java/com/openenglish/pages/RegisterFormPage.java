package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterFormPage {

    @Getter
    private SelenideElement startNowButton = $(By.id("submit-button")),
            tooltipWindowClose = $(By.xpath(".//*[@id='popmake-1005']/button"));

}
