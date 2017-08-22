package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class MensajesPage {

    private SelenideElement pageTitle = $(By.xpath(".//div[@class='title-bar']//h1")),
            tableFirstRowFirstColumn = $(By.xpath(".//*[@id='table-holder']//td[1]")),
            popupBlock = $(By.id("notification")),
            popupCloseButton = $(By.xpath(".//a[@role='button']"));

}
