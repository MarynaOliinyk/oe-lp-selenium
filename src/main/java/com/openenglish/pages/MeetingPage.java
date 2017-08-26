package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class MeetingPage {
    private SelenideElement text = $(By.xpath(".//*[@id='gecko']/h1")),
            adobeConnectHeaderTestText = $(By.xpath(".//*[@id='mainLogo']/h1/a")),
            adobeConnectTest = $(By.xpath(".//*[@id='test']/embed"));
}
