package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class VideoPopUp {

    private SelenideElement reproducirButton = $(By.xpath(".//span[@class='play-pause-label paused']"));
}
