package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LessonsPage {

    @Getter
    private SelenideElement text = $(By.xpath(".//*[@class='instructions']")),
            reminderTab = $(By.xpath(".//div[@class='reminder']")),
            reminderTabTitle = $(By.xpath(".//*[@id='progressCheck']//strong[@class='title']")),
            reminderTabBody = $(By.id("msg")),
            reminderTabLessonsLink = $(By.id("indexLink")),
            reminderTabPracticaLink = $(By.id("immersionLink")),
            reminderTabLiveClassesLink = $(By.id("liveClassLink")),
            lessonIFrame = $(By.id("lesson")),
            lessonContentBlock = $(By.xpath(".//*[@class='learning-player-wrapper']")),
            beginLessonButton = $(By.xpath(".//button[@class='continue']")),
            lessonMenu = $(By.xpath(".//*[@id='content']//div[@class='row']")),
            lessonMenuTitle = $(By.id("lesson-title")),
            lessonMenuProgress = $(By.id("progress")),
            lessonMenuLinkBox = $(By.xpath(".//*[@id='content']//div[@class='link-box']"));
}
