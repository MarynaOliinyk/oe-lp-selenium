package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class VideoPopUp {

    private SelenideElement videoIframe = $(By.xpath(".//div[@id='ec-player']//iframe")),
            videoWindow = $(By.xpath(".//*[@class='vjs-text-track-display']")),
            pausaButton = $(By.xpath(".//span[@class='play-pause-label playing']")),
            reproducirButton = $(By.xpath(".//span[@class='play-pause-label paused']"));
}
