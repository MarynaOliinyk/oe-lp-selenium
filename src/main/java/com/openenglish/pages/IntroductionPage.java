package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IntroductionPage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@id='content']/div/div[1]/div/h1"));
}
