package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HowToVideosPage {
    @Getter
    private SelenideElement image = $(By.xpath(".//*[@class='heroShot']")),
            videoContent = $(By.id("row1")),
            video = $(By.id("video1")),
            titleOnVideos = $(By.xpath(".//*[@id='row1']/div[1]/p[1]")),
            descriptionOnVideo = $(By.xpath(".//*[@id='row1']/div[1]/p[2]")),
            popUpVideo = $(By.id("video-popup")),
            popUpControlPanel = $(By.xpath(".//*[@id='video-popup']/div[2]/div[3]")),
            playButtonOnPopUp = $(By.xpath(".//*[@class='play-btn']")),
    pauseButtonPopUp = $(By.xpath(".//*[@class='pause-btn']")),
    backwardButtonPopUp = $(By.xpath(".//*[@class='skip-back-btn']")),
    forwardButtonPopUp = $(By.xpath(".//*[@class='skip-fwd-btn']"));
}
