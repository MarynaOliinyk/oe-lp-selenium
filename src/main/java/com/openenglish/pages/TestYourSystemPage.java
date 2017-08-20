package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestYourSystemPage {

    @Getter
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            systemRequirements = $(By.xpath(".//*[@id='system-requirements']/span")),
            browserRequirements = $(By.xpath(".//*[@id='browser-requirements']/span")),
            otherRequirements = $(By.xpath(".//*[@id='other-requirements']/span")),
            verificarTuSistemaButton = $(By.id("test-button"));
}
