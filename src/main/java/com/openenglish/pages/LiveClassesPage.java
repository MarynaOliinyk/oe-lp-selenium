package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LiveClassesPage {

    @Getter

    private SelenideElement headerText = $(By.xpath(".//*[@id='main']/header/div/h1"));
}
