package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class ParticipantsGuidePage {
    @Getter
    private SelenideElement pageTitle = $(By.id("plugin")),
            pageContainerFirstPage = $(By.xpath(".//*[@class='textLayer']")),
            pageContainerSecondPage = $(By.xpath(".//*[@id='pageContainer2']/xhtml:div[2]"));
}
