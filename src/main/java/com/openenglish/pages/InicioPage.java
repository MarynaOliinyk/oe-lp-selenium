package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InicioPage {

    @Getter
    private SelenideElement userName = $(By.xpath(".//*[@id='student-info']//div[@class='display-name']")),
                          inicioLink = $(By.id("nav-home"));


}
