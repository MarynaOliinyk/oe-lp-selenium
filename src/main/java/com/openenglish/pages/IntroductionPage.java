package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class IntroductionPage {
    public String lessonNumber = ".//*[@class='slideset']/div[%s]/div/div[1]/strong",
            lessonsImage = ".//*[@id='immersionCarousel']/div/div/div/div[%s]/span",
            immersionResultsTable = ".//*[@id='immersionResultsTable']//ul/li/div[%s]";
    private SelenideElement headerText = $(By.xpath(".//*[@class='title-bar']//h1")),
            dropBlock = $(By.xpath(".//*[@class='reminder-opener']")),
            dropBlockHeaderText = $(By.xpath(".//*[@class='reminder-drop']/strong")),
            dropBlockMessage = $(By.id("msg")),
            carousel = $(By.xpath(".//*[@id='immersionCarousel']")),
            prevButton = $(By.xpath(".//*[@class='btn-prev']")),
            nextButton = $(By.xpath(".//*[@class='btn-next']")),
            leftLessonsImage = $(By.xpath(String.format(lessonsImage, 10))),
            rightLessonsImage = $(By.xpath(String.format(lessonsImage, 12))),
            centreLessonsImage = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[11]/img")),
            lessonThirdOnCarousel = $(By.xpath(String.format(lessonNumber, 11))),
            lessonFourthOnCarousel = $(By.xpath(String.format(lessonNumber, 12))),
            lessonTwelfthOnCarousel = $(By.xpath(String.format(lessonNumber, 10))),
            lessonFifthOnCarousel = $(By.xpath(String.format(lessonNumber, 13))),
            titleAllLessons = $(By.xpath(".//*[@id='main']/div[1]/h1")),
            imageOfEachLesson = $(By.xpath(String.format(immersionResultsTable, 1))),
            numberOfEachLesson = $(By.xpath(String.format(immersionResultsTable, 2))),
            descriptionOfEachLesson = $(By.xpath(String.format(immersionResultsTable, 3))),
            lessonCentreHolder = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[12]/div/div[1]")),
            descriptionCentreLesson = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[12]/div/div[2]/span")),
            nameAndNumberCenterLesson = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[12]/div/div[1]/strong")),
            comenzarButtonCentreLesson = $(By.xpath(".//*[@id='immersionCarousel']/div/div/div/div[12]/div/div[2]/div/a"));

    private String dropBlockLessonLinkID = "lessonLink",
            dropBlockClasesEnVivoLinkID = "liveClassLink";
}
