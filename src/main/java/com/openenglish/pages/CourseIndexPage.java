package com.openenglish.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class CourseIndexPage {
    private SelenideElement headerText = $(By.xpath(".//*[@id='body-content']//h1")),
            filterText = $(By.xpath(".//*[@class='show-all']")),
            lessonContent = $(By.xpath(".//*[@id='twocolumns']")),
            nextArrowButton = $(By.xpath(".//*[@class='next']")),
            previousArrowButton = $(By.xpath(".//*[@class='prev']")),
            levelsHolder = $(By.xpath(".//*[@class='top-holder']")),
            contentOfEachLevel = $(By.xpath(".//*[@class='open-close']"));
}
