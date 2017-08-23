package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class HowToVideosPage {
    private SelenideElement image = $(By.xpath(".//*[@class='heroShot']")),
            videoContent = $(By.id("row1")),
            video = $(By.id("video1")),
            titleOnVideos = $(By.xpath(".//*[@id='row1']/div[1]/p[1]")),
            descriptionOnVideo = $(By.xpath(".//*[@id='row1']/div[1]/p[2]")),
            backwardButtonPopUp = $(By.xpath(".//*[@class='skip-back-btn']")),
            forwardButtonPopUp = $(By.xpath(".//*[@class='skip-fwd-btn']")),
            bufferVideo = $(By.xpath(".//*[@class='current-time']"));
}