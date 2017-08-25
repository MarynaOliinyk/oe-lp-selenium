package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class FAQPage {
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1"));
}
