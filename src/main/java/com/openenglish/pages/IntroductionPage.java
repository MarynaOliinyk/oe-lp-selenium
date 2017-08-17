package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class IntroductionPage {

    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            dropBlock = $(By.xpath(".//*[@class='reminder-opener']")),
            dropBlockHeaderText = $(By.xpath(".//*[@class='reminder-drop']/strong")),
            dropBlockMessage = $(By.id("msg")),
            carousel = $(By.xpath(".//*[@id='immersionCarousel']")),
            prevButton = $(By.xpath(".//*[@class='btn-prev']")),
            nextButton = $(By.xpath(".//*[@class='btn-next']")),
            leftLessonsImage = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[10]/span")),
            rightLessonsImage = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[12]/span")),
            centreLessonsImage = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[11]/img")),
            lessonAndNumber = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[11]/div/div[1]/strong")),
            titleAllLessons = $(By.xpath(".//*[@id='main']/div[1]/h1")),
            imageOfEachLesson = $(By.xpath(".//*[@id='immersionResultsTable']//ul/li/div[1]")),
            numberOfEachLesson = $(By.xpath(".//*[@id='immersionResultsTable']//ul/li/div[2]")),
            descriptionOfEachLesson = $(By.xpath(".//*[@id='immersionResultsTable']//ul/li/div[3]"));

    private String dropBlockLessonLinkID = "lessonLink",
            dropBlockClasesEnVivoLinkID = "liveClassLink",
            attributeForLink = "href",
            attributeForNumberLesson = "alt";
}
