package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OpenenglishPage {

    @Getter
    private SelenideElement registerForm = $(By.id("leadForm"));

}
