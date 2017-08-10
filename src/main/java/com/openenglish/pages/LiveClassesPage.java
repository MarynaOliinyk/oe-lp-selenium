package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LiveClassesPage {


    private SelenideElement headerText = $(By.xpath(".//div[@class='title-bar']//h1")),
            dropBlock = $(By.xpath(".//*[@class='reminder-opener']")),
            dropBlockHeaderText = $(By.xpath(".//*[@class='reminder-drop']/strong")),
            dropBlockMessage = $(By.id("msg")),
            carousel = $(By.id("liveCarousel")),
            timer = $(By.xpath(".//*[@class='time liveclass-banner']")),
            timesUpButton = $(By.xpath(".//*[@class='timesUp']")),
            rightBanner = $(By.xpath("(//IMG[@class='slide'])[4]")),
            leftBanner = $(By.xpath("(//IMG[@class='slide'])[2]")),
            titleText = $(By.xpath(".//*[@class='events-section']/h1")),
            contentText = $(By.xpath(".//*[@class='events-section']/p")),
            dates = $(By.xpath(".//*[@class='date']")),
            imageOnVideo = $(By.xpath(".//*[@class='image-holder']"));


    private String dropBlockLessonLinkID = "lessonLink",
            dropBlockImmersionLinkID = "immersionLink",
            attribute = "href";

}
